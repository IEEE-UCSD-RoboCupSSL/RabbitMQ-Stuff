package com.triton.module.processing_module;

import com.rabbitmq.client.Delivery;
import com.triton.module.Module;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static com.triton.messaging.Exchange.AI_ROBOT_COMMAND;
import static com.triton.messaging.Exchange.AI_TRITON_BOT_COMMAND;
import static com.triton.messaging.SimpleSerialize.simpleDeserialize;
import static proto.simulation.SslSimulationRobotControl.RobotCommand;
import static proto.triton.TritonBotCommunication.TritonBotCommand;

public class TritonBotCommandBuilder extends Module {
    public TritonBotCommandBuilder() throws IOException, TimeoutException {
        super();
    }

    @Override
    protected void loadConfig() throws IOException {
        super.loadConfig();
    }

    @Override
    protected void prepare() {
        super.prepare();
    }

    @Override
    protected void declareExchanges() throws IOException, TimeoutException {
        super.declareExchanges();
        declareConsume(AI_ROBOT_COMMAND, this::callbackRobotCommand);
        declarePublish(AI_TRITON_BOT_COMMAND);
    }

    private void callbackRobotCommand(String s, Delivery delivery) {
        RobotCommand robotCommand;
        try {
            robotCommand = (RobotCommand) simpleDeserialize(delivery.getBody());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        TritonBotCommand.Builder tritonBotCommand = TritonBotCommand.newBuilder();
        tritonBotCommand.setRobotCommand(robotCommand);

        try {
            publish(AI_TRITON_BOT_COMMAND, tritonBotCommand);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}