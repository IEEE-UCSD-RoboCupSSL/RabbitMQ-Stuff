package com.triton.module.interface_module;

import com.rabbitmq.client.Delivery;
import com.triton.config.NetworkConfig;
import com.triton.module.Module;
import com.triton.networking.UDP_Client;
import proto.simulation.SslGcCommon;
import proto.simulation.SslSimulationConfig.SimulatorConfig;
import proto.simulation.SslSimulationControl;
import proto.simulation.SslSimulationControl.SimulatorResponse;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static com.triton.config.ConfigPath.NETWORK_CONFIG;
import static com.triton.config.ConfigReader.readConfig;
import static com.triton.messaging.Exchange.AI_SIMULATOR_CONFIG;
import static com.triton.messaging.Exchange.AI_SIMULATOR_CONTROL;
import static com.triton.messaging.SimpleSerialize.simpleDeserialize;
import static proto.simulation.SslGcCommon.*;
import static proto.simulation.SslGcCommon.Team.BLUE;
import static proto.simulation.SslGcCommon.Team.YELLOW;
import static proto.simulation.SslSimulationControl.*;
import static proto.simulation.SslSimulationControl.SimulatorCommand;
import static proto.simulation.SslSimulationControl.SimulatorControl;

public class SimulatorCommandInterface extends Module {
    private NetworkConfig networkConfig;

    private UDP_Client client;

    public SimulatorCommandInterface() throws IOException, TimeoutException {
        super();
    }

    @Override
    protected void loadConfig() throws IOException {
        super.loadConfig();
        networkConfig = (NetworkConfig) readConfig(NETWORK_CONFIG);
    }

    @Override
    protected void prepare() {
        super.prepare();

        try {
            setupClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void declareExchanges() throws IOException, TimeoutException {
        super.declareExchanges();
        declareConsume(AI_SIMULATOR_CONTROL, this::callbackSimulatorControl);
        declareConsume(AI_SIMULATOR_CONFIG, this::callbackSimulatorConfig);
    }

    @Override
    public void run() {
        super.run();

        setupSimulator();
    }

    private void setupClient() throws IOException {
        client = new UDP_Client(networkConfig.simulationCommandAddress,
                networkConfig.simulationCommandPort,
                this::callbackSimulatorResponse,
                10);
        client.start();
    }

    private void setupSimulator() {
        SimulatorControl.Builder simulatorControl = SimulatorControl.newBuilder();

        for (int id = 6; id < 12; id++) {
            TeleportRobot.Builder teleportRobot = TeleportRobot.newBuilder();
            RobotId.Builder robotId = RobotId.newBuilder();
            robotId.setTeam(BLUE);
            robotId.setId(id);
            teleportRobot.setId(robotId);
            teleportRobot.setPresent(false);
            simulatorControl.addTeleportRobot(teleportRobot);
        }

        for (int id = 6; id < 12; id++) {
            TeleportRobot.Builder teleportRobot = TeleportRobot.newBuilder();
            RobotId.Builder robotId = RobotId.newBuilder();
            robotId.setTeam(YELLOW);
            robotId.setId(id);
            teleportRobot.setId(robotId);
            teleportRobot.setPresent(false);
            simulatorControl.addTeleportRobot(teleportRobot);
        }

        try {
            publish(AI_SIMULATOR_CONTROL, simulatorControl.build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void callbackSimulatorControl(String s, Delivery delivery) {
        SimulatorControl simulatorControl;
        try {
            simulatorControl = (SimulatorControl) simpleDeserialize(delivery.getBody());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        SimulatorCommand.Builder simulatorCommand = SimulatorCommand.newBuilder();
        simulatorCommand.setControl(simulatorControl);
        client.addSend(simulatorCommand.build().toByteArray());
    }

    private void callbackSimulatorConfig(String s, Delivery delivery) {
        SimulatorConfig simulatorConfig;
        try {
            simulatorConfig = (SimulatorConfig) simpleDeserialize(delivery.getBody());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        SimulatorCommand.Builder simulatorCommand = SimulatorCommand.newBuilder();
        simulatorCommand.setConfig(simulatorConfig);
        client.addSend(simulatorCommand.build().toByteArray());
    }

    private void callbackSimulatorResponse(byte[] bytes) {
        try {
            SimulatorResponse simulatorResponse = SimulatorResponse.parseFrom(bytes);
            System.out.println(simulatorResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
