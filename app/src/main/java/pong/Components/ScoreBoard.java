package pong.Components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import pong.Constants;

public class ScoreBoard {

    private int player1 = 0;
    private int player2 = 0;

    private final Text p1Text = new Text();
    private final Text p2Text = new Text();
    private final Text mainText = new Text("Pong");

    private final BorderPane root = new BorderPane();

    public ScoreBoard() {

        mainText.setFont(Constants.Text.FONT);
        mainText.setFill(Constants.Text.COLOR);

        p1Text.setFont(Constants.Text.FONT);
        p1Text.setFill(Constants.Text.COLOR);

        p2Text.setFont(Constants.Text.FONT);
        p2Text.setFill(Constants.Text.COLOR);

        updateText();

        root.setLeft(p1Text);
        root.setCenter(mainText);
        root.setRight(p2Text);

        BorderPane.setAlignment(p1Text, Pos.CENTER_LEFT);
        BorderPane.setAlignment(mainText, Pos.CENTER);
        BorderPane.setAlignment(p2Text, Pos.CENTER_RIGHT);

        root.setPadding(new Insets(20));
    }

    private void updateText() {
        p1Text.setText("Player 1: " + player1);
        p2Text.setText("Player 2: " + player2);
    }

    public void addP1Point() {
        player1++;
        updateText();
    }

    public void addP2Point() {
        player2++;
        updateText();
    }

    public void resetPoints() {
        player1 = 0;
        player2 = 0;
        updateText();
    }

    public BorderPane getScoreBoard() {  return root; }
}
