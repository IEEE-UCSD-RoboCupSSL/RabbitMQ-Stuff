package com.triton.module.source_module;

import com.triton.module.Module;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static com.triton.messaging.Exchange.AI_BIASED_ROBOT_COMMAND;
import static proto.simulation.SslSimulationRobotControl.*;

public class RobotCommandSource extends Module {
    public RobotCommandSource() throws IOException, TimeoutException {
        super();
        declareExchanges();
    }

    @Override
    protected void declareExchanges() throws IOException, TimeoutException {
        super.declareExchanges();
        declarePublish(AI_BIASED_ROBOT_COMMAND);
    }

    @Override
    public void run() {
        super.run();

        while (true) {
            try {
                RobotCommand.Builder robotCommand = RobotCommand.newBuilder();

                robotCommand.setId(0);

                RobotMoveCommand.Builder moveCommand = RobotMoveCommand.newBuilder();
                MoveLocalVelocity.Builder localVelocity = MoveLocalVelocity.newBuilder();
                localVelocity.setForward(10);
                localVelocity.setLeft(10);
                localVelocity.setAngular(1);
                moveCommand.setLocalVelocity(localVelocity);
                robotCommand.setMoveCommand(moveCommand);

                robotCommand.setKickSpeed(10);
                robotCommand.setKickAngle(0);
                robotCommand.setDribblerSpeed(10);

                publish(AI_BIASED_ROBOT_COMMAND, robotCommand.build());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}