package com.triton.ai.skills.basic_skills;

import com.triton.messaging.Exchange;
import com.triton.module.Module;
import proto.simulation.SslSimulationRobotControl;
import proto.triton.AiBasicSkills;
import proto.vision.MessagesRobocupSslDetection;

import java.io.IOException;

import static com.triton.messaging.Exchange.*;

public class MoveToPointSkill {
    public static void moveToPointSkill(Module module, int id, AiBasicSkills.MoveToPoint moveToPoint, MessagesRobocupSslDetection.SSL_DetectionRobot ally) throws IOException {
        if (ally == null) return;

        SslSimulationRobotControl.RobotCommand.Builder robotCommand = SslSimulationRobotControl.RobotCommand.newBuilder();
        robotCommand.setId(id);
        SslSimulationRobotControl.RobotMoveCommand.Builder moveCommand = SslSimulationRobotControl.RobotMoveCommand.newBuilder();
        SslSimulationRobotControl.MoveGlobalVelocity.Builder globalVelocity = SslSimulationRobotControl.MoveGlobalVelocity.newBuilder();

        float vx = moveToPoint.getX() - ally.getX();
        float vy = moveToPoint.getY() - ally.getY();
        float angular = moveToPoint.getOrientation() - ally.getOrientation();

        // TODO CONSIDER SPEED CAP LATER
        vx /= 200;
        vy /= 200;
        angular /= 1;

        globalVelocity.setX(vx);
        globalVelocity.setY(vy);
        globalVelocity.setAngular(angular);
        moveCommand.setGlobalVelocity(globalVelocity);
        robotCommand.setMoveCommand(moveCommand);

        module.publish(AI_BIASED_ROBOT_COMMAND, robotCommand.build());
    }
}