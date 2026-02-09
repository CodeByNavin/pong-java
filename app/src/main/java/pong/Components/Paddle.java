package pong.Components;

import javafx.scene.shape.Rectangle;

import pong.Constants;
import pong.PaddleSide;

public class Paddle {
    private final Rectangle paddle;
    
    public Paddle(PaddleSide side) {
        double x;

        if (side == PaddleSide.LEFT) {
            x = Constants.Game.WIDTH
            - Constants.Paddle.SPACING
            - Constants.Paddle.WIDTH;
        } else {
            x = Constants.Paddle.SPACING;
        }

        paddle = new Rectangle(
            x,
            Constants.Game.HEIGHT / 2 - Constants.Paddle.HEIGHT / 2,
            Constants.Paddle.WIDTH,
            Constants.Paddle.HEIGHT
        );

        paddle.setFill(Constants.Paddle.COLOR);
    }

    public Rectangle getPaddle() { return paddle; }

    public void moveUP() {
        paddle.setY(
            Math.max(0,paddle.getY() - Constants.Paddle.MOVEMENT)
        );
    };

    public void moveDown() {
        paddle.setY(
            Math.min(
                Constants.Game.HEIGHT - Constants.Paddle.HEIGHT,
                paddle.getY() + Constants.Paddle.MOVEMENT
            )
        );
    }

    public double getYPOS() { return paddle.getY(); }

    public void resetPOS() {
        paddle.setY(Constants.Game.HEIGHT / 2);
    }
}