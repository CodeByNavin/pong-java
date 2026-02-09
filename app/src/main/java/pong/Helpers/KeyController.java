package pong.Helpers;

import javafx.scene.input.KeyCode;

public class KeyController {
    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean wPressed = false;
    private boolean sPressed = false;
    private boolean xPressed = false;
    private boolean rPressed = false;

    public void keyPressed(KeyCode code) {
        switch (code) {
            case UP:
                upPressed = true;
                break;
            case DOWN:
                downPressed = true;
                break;
            case W:
                wPressed = true;
                break;
            case S:
                sPressed = true;
                break;            
            case X:
                xPressed = true;
                break;
            case R:
                rPressed = true;
                break;
        }
    }

    public void keyReleased(KeyCode code) {
        switch (code) {
            case UP:
                upPressed = false;
                break;
            case DOWN:
                downPressed = false;
                break;
            case W:
                wPressed = false;
                break;
            case S:
                sPressed = false;
                break;
            case R:
                rPressed = false;
                break;
        }
    }

    public boolean isUpPressed() { return upPressed; }
    public boolean isDownPressed() { return downPressed; }
    public boolean isWPressed() { return wPressed; }
    public boolean isSPressed() { return sPressed; }
    public boolean isXPressed() { return xPressed; }
    public boolean isRPressed() { return rPressed; }

}