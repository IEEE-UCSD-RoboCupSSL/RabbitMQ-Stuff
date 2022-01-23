package com.triton.module.interface_module;

import com.rabbitmq.client.Delivery;
import com.triton.config.GameConfig;
import com.triton.config.NetworkConfig;
import com.triton.constant.RuntimeConstants;
import com.triton.module.Module;
import com.triton.networking.UDP_Client;
import proto.triton.TritonBotCommunication.TritonBotMessage;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

import static com.triton.config.ConfigPath.GAME_CONFIG;
import static com.triton.config.ConfigPath.NETWORK_CONFIG;
import static com.triton.config.ConfigReader.readConfig;
import static com.triton.messaging.Exchange.AI_ROBOT_FEEDBACKS;
import static com.triton.messaging.Exchange.AI_TRITON_BOT_MESSAGE;
import static com.triton.messaging.SimpleSerialize.simpleDeserialize;
import static proto.simulation.SslSimulationRobotFeedback.RobotFeedback;

public class TritonBotMessageInterface extends Module {
    private NetworkConfig networkConfig;
    private GameConfig gameConfig;

    private HashMap<Integer, UDP_Client> clientMap;
    private HashMap<Integer, RobotFeedback> feedbacks;

    public TritonBotMessageInterface() throws IOException, TimeoutException {
        super();
    }

    @Override
    protected void loadConfig() throws IOException {
        super.loadConfig();
        networkConfig = (NetworkConfig) readConfig(NETWORK_CONFIG);
        gameConfig = (GameConfig) readConfig(GAME_CONFIG);
    }

    @Override
    protected void prepare() {
        super.prepare();

        clientMap = new HashMap<>();
        feedbacks = new HashMap<>();

        try {
            setupClients();
        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void declareExchanges() throws IOException, TimeoutException {
        super.declareExchanges();
        declareConsume(AI_TRITON_BOT_MESSAGE, this::callbackTritonBotMessage);
    }

    private void setupClients() throws SocketException, UnknownHostException {
        for (int id = 0; id < gameConfig.numBots; id++) {
            String serverAddress;
            int serverPort;
            switch (RuntimeConstants.team) {
                case YELLOW -> {
                    serverAddress = networkConfig.tritonBotAddressYellow;
                    serverPort = networkConfig.tritonBotPortBaseYellow + id * networkConfig.tritonBotPortIncr;
                }
                case BLUE -> {
                    serverAddress = networkConfig.tritonBotAddressBlue;
                    serverPort = networkConfig.tritonBotPortBaseBlue + id * networkConfig.tritonBotPortIncr;
                }
                default -> throw new IllegalStateException("Unexpected value: " + RuntimeConstants.team);
            }

            UDP_Client client = new UDP_Client(serverAddress, serverPort, this::callbackTritonBotFeedback, 10);
            client.start();
            clientMap.put(id, client);
        }
    }

    private void callbackTritonBotMessage(String s, Delivery delivery) {
        TritonBotMessage message = (TritonBotMessage) simpleDeserialize(delivery.getBody());
        clientMap.get(message.getId()).addSend(message.toByteArray());
    }

    private void callbackTritonBotFeedback(byte[] bytes) {
        RobotFeedback feedback = null;
        try {
            feedback = RobotFeedback.parseFrom(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (feedback == null) return;
        feedbacks.put(feedback.getId(), feedback);

        publish(AI_ROBOT_FEEDBACKS, feedbacks);
    }
}
