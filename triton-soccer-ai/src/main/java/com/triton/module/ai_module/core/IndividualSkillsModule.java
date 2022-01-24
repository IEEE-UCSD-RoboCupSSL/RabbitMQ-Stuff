package com.triton.module.ai_module.core;

import com.rabbitmq.client.Delivery;
import com.triton.ai.skills.individual_skills.*;
import com.triton.module.Module;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

import static com.triton.messaging.Exchange.*;
import static com.triton.messaging.SimpleSerialize.simpleDeserialize;
import static proto.triton.AiIndividualSkills.IndividualSkill;
import static proto.triton.ObjectWithMetadata.Ball;
import static proto.triton.ObjectWithMetadata.Robot;
import static proto.vision.MessagesRobocupSslGeometry.SSL_GeometryFieldSize;

public class IndividualSkillsModule extends Module {
    SSL_GeometryFieldSize field;
    HashMap<Integer, Robot> allies;
    HashMap<Integer, Robot> foes;
    Ball ball;

    public IndividualSkillsModule() throws IOException, TimeoutException {
        super();
    }

    @Override
    protected void declareExchanges() throws IOException, TimeoutException {
        super.declareExchanges();
        declareConsume(AI_BIASED_FIELD, this::callbackField);
        declareConsume(AI_FILTERED_BIASED_ALLIES, this::callbackAllies);
        declareConsume(AI_FILTERED_BIASED_FOES, this::callbackFoes);
        declareConsume(AI_FILTERED_BIASED_BALLS, this::callbackBalls);
        declareConsume(AI_INDIVIDUAL_SKILL, this::callbackIndividualSkill);

        declarePublish(AI_BASIC_SKILL);
    }

    private void callbackField(String s, Delivery delivery) {
        SSL_GeometryFieldSize field;
        field = (SSL_GeometryFieldSize) simpleDeserialize(delivery.getBody());

        this.field = field;
    }

    private void callbackAllies(String s, Delivery delivery) {
        this.allies = (HashMap<Integer, Robot>) simpleDeserialize(delivery.getBody());
    }

    private void callbackFoes(String s, Delivery delivery) {
        this.foes = (HashMap<Integer, Robot>) simpleDeserialize(delivery.getBody());
    }

    private void callbackBalls(String s, Delivery delivery) {
        this.ball = (Ball) simpleDeserialize(delivery.getBody());
    }

    private void callbackIndividualSkill(String s, Delivery delivery) {
        IndividualSkill individualSkill = (IndividualSkill) simpleDeserialize(delivery.getBody());
        int id = individualSkill.getId();

        try {
            switch (individualSkill.getCommandCase()) {
                case GOAL_KEEP -> GoalKeepSkill.goalKeepSkill(this, id, individualSkill.getGoalKeep(), field, ball, allies);
                case PATH_TO_POINT -> PathToPointSkill.pathFindToPointSkill(this, id, individualSkill.getPathToPoint(), field, allies, foes);
                case CHASE_BALL -> ChaseBallSkill.chaseBallSkill(this, id, individualSkill.getChaseBall(), ball, allies);
                case CATCH_BALL -> CatchBallSkill.catchBallSkill(this, id, individualSkill.getCatchBall(), ball, allies);
                case KICK_BALL_TO_POINT -> KickBallToPointSkill.kickBallToPointSkill(this, id, individualSkill.getKickBallToPoint());
                case DRIBBLE_BALL -> DribbleBallSkill.dribbleBallSkill(this, id, individualSkill.getDribbleBall(), 1, 1);
                case SHOOT -> ShootSkill.shootSkill(this, id, individualSkill.getShoot());
                case STEAL -> Stealskill.stealSkill(this, id, individualSkill.getSteal());
                case JUKE -> JukeSkill.jukeSkill(this, id, individualSkill.getJuke());
                default -> throw new IllegalStateException("Unexpected value: " + individualSkill.getCommandCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}