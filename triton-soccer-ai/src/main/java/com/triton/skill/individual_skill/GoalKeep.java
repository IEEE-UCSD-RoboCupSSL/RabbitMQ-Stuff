package com.triton.skill.individual_skill;

import com.triton.module.Module;
import com.triton.skill.Skill;
import com.triton.skill.basic_skill.Dribble;
import com.triton.util.Vector2d;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static com.triton.util.ProtobufUtils.getPos;
import static proto.triton.ObjectWithMetadata.Ball;
import static proto.triton.ObjectWithMetadata.Robot;
import static proto.vision.MessagesRobocupSslGeometry.SSL_GeometryFieldSize;

public class GoalKeep extends Skill {
    private final Robot actor;
    private final SSL_GeometryFieldSize field;
    private final Ball ball;

    public GoalKeep(Module module, Robot actor, SSL_GeometryFieldSize field, Ball ball) {
        super(module);
        this.actor = actor;
        this.field = field;
        this.ball = ball;
    }

    @Override
    protected void execute() {
        float xMin = -field.getGoalWidth() / 2f;
        float xMax = field.getGoalWidth() / 2f;
        float x = Math.min(Math.max(ball.getX(), xMin), xMax);
        float y = -field.getFieldLength() / 2f + 250f;
        Vector2d pos = new Vector2d(x, y);

        Vector2d ballPos = getPos(ball);

        MoveToTarget moveToTarget = new MoveToTarget(module, actor, pos, ballPos);
        submitSkill(moveToTarget);

        Dribble dribble = new Dribble(module, actor, true);
        submitSkill(dribble);
    }

    @Override
    protected void declarePublishes() throws IOException, TimeoutException {
    }
}
