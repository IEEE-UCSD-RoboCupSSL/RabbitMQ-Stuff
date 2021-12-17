package com.triton.module;

import proto.simulation.SslSimulationControl.TeleportRobot;
import proto.simulation.SslSimulationRobotControl;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static com.triton.publisher_consumer.Exchange.ROBOT_CONTROL;
import static com.triton.publisher_consumer.Exchange.SIMULATOR_COMMAND;
import static proto.simulation.SslGcCommon.RobotId;
import static proto.simulation.SslGcCommon.Team;
import static proto.simulation.SslSimulationConfig.SimulatorConfig;
import static proto.simulation.SslSimulationControl.SimulatorCommand;
import static proto.simulation.SslSimulationControl.SimulatorControl;
import static proto.simulation.SslSimulationRobotControl.*;

public class RobotControlCreator extends Module {
    public RobotControlCreator() throws IOException, TimeoutException {
        super();
        declareExchanges();
    }

    @Override
    protected void declareExchanges() throws IOException, TimeoutException {
        super.declareExchanges();
        declarePublish(ROBOT_CONTROL);
    }

    @Override
    public void run() {
        super.run();

        while (true) {
            try {
                RobotControl.Builder robotControl = RobotControl.newBuilder();

                RobotCommand.Builder robotCommand = RobotCommand.newBuilder();

                robotCommand.setId(1);

                RobotMoveCommand.Builder moveCommand = RobotMoveCommand.newBuilder();
                MoveLocalVelocity.Builder localVelocity = MoveLocalVelocity.newBuilder();
                localVelocity.setForward(100);
                localVelocity.setLeft(0);
                localVelocity.setAngular(1);
                moveCommand.setLocalVelocity(localVelocity);
                robotCommand.setMoveCommand(moveCommand);

                robotCommand.setKickSpeed(10);
                robotCommand.setKickAngle(0);
                robotCommand.setDribblerSpeed(10);

                robotControl.addRobotCommands(robotCommand);

                publish(ROBOT_CONTROL, robotControl.build());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}