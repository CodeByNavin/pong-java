package pong;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import pong.Constants;
import pong.PaddleSide;

import pong.Components.*;
import pong.Helpers.*;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, Constants.Game.WIDTH, Constants.Game.HEIGHT);
        scene.setFill(Constants.Game.BACKGROUND);

        ScoreBoard scoreBoard = new ScoreBoard();
        root.setTop(scoreBoard.getScoreBoard());


        Ball ball = new Ball();
        root.getChildren().add(ball.getBall());
        
        Paddle paddle1 = new Paddle(PaddleSide.RIGHT);
        root.getChildren().add(paddle1.getPaddle());

        Paddle paddle2 = new Paddle(PaddleSide.LEFT);
        root.getChildren().add(paddle2.getPaddle());

        KeyController keyController = new KeyController();

        scene.setOnKeyPressed(e -> keyController.keyPressed(e.getCode()));
        scene.setOnKeyReleased(e -> keyController.keyReleased(e.getCode()));

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                ball.move();

                // Ball Pos
                if (ball.getXPOS() < 0 || ball.getXPOS() > Constants.Game.WIDTH) {
                    ball.swapXSpeed();
                }

                if (ball.getYPOS() < 0 || ball.getYPOS() > Constants.Game.HEIGHT) {
                    ball.swapYSpeed();
                }

                if (ball.getBall().getBoundsInParent().intersects(paddle1.getPaddle().getBoundsInParent()) || ball.getBall().getBoundsInParent().intersects(paddle2.getPaddle().getBoundsInParent())) {
                    ball.swapXSpeed();
                }

                // Points
                if (ball.getXPOS() == 0) {
                    scoreBoard.addP2Point();
                    ball.resetPOS();
                    paddle1.resetPOS();
                    paddle2.resetPOS();
                }

                if (ball.getXPOS() == Constants.Game.WIDTH) {
                    scoreBoard.addP1Point();
                    ball.resetPOS();
                    paddle1.resetPOS();
                    paddle2.resetPOS();
                }


                // Movement
                if (keyController.isWPressed()) {
                    paddle1.moveUP();
                }
                if (keyController.isSPressed()) {
                    paddle1.moveDown();
                }
                if (keyController.isUpPressed()) {
                    paddle2.moveUP();
                }
                if (keyController.isDownPressed()) {
                    paddle2.moveDown();
                }

                // Restart Game
                if (keyController.isRPressed()) {
                    scoreBoard.resetPoints();
                    ball.resetPOS();
                    paddle1.resetPOS();
                    paddle2.resetPOS();
                }

                // Exit Game
                if (keyController.isXPressed()) {
                    primaryStage.close();
                }

            }
        }.start();

        primaryStage.setTitle("Pong Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
