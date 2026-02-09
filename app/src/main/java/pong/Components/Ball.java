package pong.Components;

import javafx.scene.shape.Circle;

import pong.Constants;

public class Ball {
    private final Circle ball;
    private double x_speed = Constants.Ball.X_SPEED;
    private double y_speed = Constants.Ball.Y_SPEED;
    
    public Ball() {
        ball = new Circle(Constants.Ball.SIZE, Constants.Ball.COLOR);

        ball.setCenterX(Constants.Ball.SIZE / 2);
        ball.setCenterY(Constants.Ball.SIZE / 2);
    }

    public Circle getBall() { return ball; }
    public double getXPOS() { return ball.getCenterX(); }
    public double getYPOS() { return ball.getCenterY(); }

    public void move() {
        ball.setCenterX(
            getXPOS() + x_speed
        );
        ball.setCenterY(
            getYPOS() + y_speed
        );
    }

    public void swapXSpeed() {
        x_speed = -x_speed;
    }    
    
    public void swapYSpeed() {
        y_speed = -y_speed;
    }
    
    public void resetPOS() {
        ball.setCenterX(Constants.Game.WIDTH / 2);
        ball.setCenterY(Constants.Game.HEIGHT / 2);
    }
}
