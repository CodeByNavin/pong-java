package pong;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Constants {

    public static class Game {
        public static final int WIDTH = 800;
        public static final int HEIGHT = 600;
        public static final Color BACKGROUND = Color.BLACK;

    }

    public static class Ball {
        public static final int SIZE = 20;
        public static final double X_SPEED = 5;
        public static final double Y_SPEED = 5;
        public static final Color COLOR = Color.WHITE;
    }

    public static class Paddle {
        public static final int WIDTH = 10;
        public static final int HEIGHT = 100;
        public static final int SPACING = 15;
        public static final int MOVEMENT = 20;
        public static final Color COLOR = Color.WHITE;
        
    }

    public static class Text {
        public static final Color COLOR = Color.GRAY;
        public static final Font FONT = Font.font("Arial", FontWeight.BOLD, 24);
    }
}
