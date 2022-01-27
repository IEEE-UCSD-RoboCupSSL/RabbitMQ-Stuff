package com.triton.skill.individual_skill;

import com.triton.module.Module;
import com.triton.search.implementation.PathfindGridGroup;
import com.triton.skill.Skill;
import com.triton.skill.basic_skill.Dribble;
import com.triton.util.Vector2d;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static com.triton.util.ProtobufUtils.getPos;
import static com.triton.util.ProtobufUtils.getVel;
import static proto.triton.ObjectWithMetadata.Ball;
import static proto.triton.ObjectWithMetadata.Robot;

public class ChaseBall extends Skill {
    private final Robot actor;
    private final Ball ball;
    private final PathfindGridGroup pathfindGridGroup;

    public ChaseBall(Module module,
                     Robot actor,
                     PathfindGridGroup pathfindGridGroup,
                     Ball ball) {
        super(module);
        this.actor = actor;
        this.pathfindGridGroup = pathfindGridGroup;
        this.ball = ball;
    }

    @Override
    protected void execute() {
        Vector2d ballPos = getPos(ball);
        Vector2d ballVel = getVel(ball);
        Vector2d targetPos = ballPos.add(ballVel.scale(0.1f));

        PathToTarget pathToTarget = new PathToTarget(module, actor, targetPos, ballPos, pathfindGridGroup);
        submitSkill(pathToTarget);

        Dribble dribble = new Dribble(module, actor, true);
        submitSkill(dribble);
    }

    @Override
    protected void declarePublishes() throws IOException, TimeoutException {
    }
}
