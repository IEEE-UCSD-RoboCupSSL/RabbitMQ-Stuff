package com.triton.module.test_module.individual_skill_test;

import com.rabbitmq.client.Delivery;
import com.triton.module.TestRunner;
import com.triton.search.node2d.PathfindGrid;
import com.triton.skill.individual_skill.ChaseBall;
import com.triton.skill.individual_skill.KickToPoint;
import com.triton.skill.individual_skill.PathToPoint;
import com.triton.util.ObjectHelper;
import com.triton.util.Vector2d;
import proto.simulation.SslSimulationControl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static com.triton.messaging.Exchange.*;
import static com.triton.messaging.SimpleSerialize.simpleDeserialize;
import static com.triton.util.ProtobufUtils.createTeleportBall;
import static proto.simulation.SslSimulationRobotFeedback.RobotFeedback;
import static proto.triton.ObjectWithMetadata.Ball;
import static proto.triton.ObjectWithMetadata.Robot;
import static proto.vision.MessagesRobocupSslGeometry.SSL_GeometryFieldSize;

public class KickToPointTest extends TestRunner {
    private Map<Integer, PathfindGrid> pathfindGrids;

    private SSL_GeometryFieldSize field;
    private Ball ball;
    private Map<Integer, Robot> allies;
    private Map<Integer, Robot> foes;
    private Map<Integer, RobotFeedback> feedbacks;

    public KickToPointTest(ScheduledThreadPoolExecutor executor) {
        super(executor);
        scheduleSetupTest(0, 10000, TimeUnit.MILLISECONDS);
    }

    @Override
    protected void setupTest() {
        SslSimulationControl.SimulatorControl.Builder simulatorControl = SslSimulationControl.SimulatorControl.newBuilder();
        simulatorControl.setTeleportBall(createTeleportBall(0, 0, 0));
        publish(AI_BIASED_SIMULATOR_CONTROL, simulatorControl.build());
    }

    @Override
    protected void execute() {
        if (field == null || ball == null || allies == null || foes == null || feedbacks == null) return;

        int id = 1;
        Robot ally = allies.get(1);

        if (!pathfindGrids.containsKey(id))
            pathfindGrids.put(id, new PathfindGrid(field));
        pathfindGrids.get(id).updateObstacles(allies, foes, ally);

        if (feedbacks.get(id).getDribblerBallContact()) {
            Vector2d kickFrom = new Vector2d(1000, 1000);
            if (ObjectHelper.matchPos(ally, kickFrom, 100)) {
                KickToPoint kickToPoint = new KickToPoint(this, ally, new Vector2d(0, 0));
                submitSkill(kickToPoint);
            } else {
                PathToPoint pathToPoint = new PathToPoint(this,
                        ally,
                        kickFrom,
                        (float) Math.PI,
                        pathfindGrids.get(id));
                submitSkill(pathToPoint);
            }
        } else {
            ChaseBall chaseBall = new ChaseBall(this,
                    allies.get(id),
                    pathfindGrids.get(id),
                    ball,
                    allies,
                    foes);
            submitSkill(chaseBall);
        }
    }

    @Override
    protected void prepare() {
        pathfindGrids = new HashMap<>();
    }

    @Override
    protected void declarePublishes() throws IOException, TimeoutException {
        declarePublish(AI_BIASED_SIMULATOR_CONTROL);
    }

    @Override
    protected void declareConsumes() throws IOException, TimeoutException {
        declareConsume(AI_BIASED_FIELD, this::callbackField);
        declareConsume(AI_FILTERED_BALL, this::callbackBalls);
        declareConsume(AI_FILTERED_ALLIES, this::callbackAllies);
        declareConsume(AI_FILTERED_FOES, this::callbackFoes);
        declareConsume(AI_ROBOT_FEEDBACKS, this::callbackFeedbacks);
    }

    private void callbackField(String s, Delivery delivery) {
        field = (SSL_GeometryFieldSize) simpleDeserialize(delivery.getBody());
    }

    private void callbackBalls(String s, Delivery delivery) {
        ball = (Ball) simpleDeserialize(delivery.getBody());
    }

    private void callbackAllies(String s, Delivery delivery) {
        allies = (Map<Integer, Robot>) simpleDeserialize(delivery.getBody());
    }

    private void callbackFoes(String s, Delivery delivery) {
        foes = (Map<Integer, Robot>) simpleDeserialize(delivery.getBody());
    }

    private void callbackFeedbacks(String s, Delivery delivery) {
        feedbacks = (Map<Integer, RobotFeedback>) simpleDeserialize(delivery.getBody());
    }
}