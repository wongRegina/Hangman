import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class KeyPress {
    private Guesses guesses;
    private List<Button> words, alpha;
    private Scene scene;
    private ArrayList<String> usedLetter = new ArrayList<>();
    private int guess = 10;
    private EndGame endGame;
    private Man man;
    private boolean gameOver = true;

    public KeyPress(Guesses guesses, List<Button> words, List<Button> alpha, Man man) {
        this.guesses = guesses;
        this.words = words;
        this.alpha = alpha;
        this.man = man;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void keyPress() {
        scene.setOnKeyPressed((final KeyEvent ke) -> {
            if (!gameOver) {
                if (ke != null) {
                    KeyCode keyCode = ke.getCode();
                    if (!checkAlph(keyCode))
                        return;
                    if (!checkWord(keyCode)) {
                        man.updateMan(true);
                        guess = guesses.updateRemainingGuesses();
                    }
                    endGameCheck();
                }
            }
        });
    }

    private boolean checkAlph(KeyCode keyCode) {
        boolean validAlp = false;
        for (Button letter : alpha) {
            if (keyCode.equals(KeyCode.getKeyCode(letter.getText())) || keyCode.equals(KeyCode.getKeyCode(letter.getText().toLowerCase()))) {
                validAlp = true;
                if (usedLetter.contains(letter.getText()) || usedLetter.contains(letter.getText().toLowerCase()))
                    return false;
                letter.setStyle(("-fx-background-color: #756d96; -fx-font-size: 24; -fx-text-fill: black; -fx-opacity: 0.5"));
                usedLetter.add(letter.getText());
                return true;
            }
        }
        if (!validAlp)
            return false;
        return true;
    }

    private boolean checkWord(KeyCode keyCode) {
        boolean valid = false;
        for (Button letter : words) {
            if (keyCode.equals(KeyCode.getKeyCode(letter.getText())) || keyCode.equals(KeyCode.getKeyCode(letter.getText().toUpperCase()))) {
                letter.setDisable(true);
                letter.setStyle(("-fx-background-color: #000000; -fx-font-size: 16;-fx-text-fill: white ;-fx-opacity: 1"));
                letter.setMinWidth(20);
                letter.setMinHeight(20);
                valid = true;
            }
        }
        return valid;
    }

    private boolean checkWin() {
        for (Button x : words) {
            if (!x.isDisable())
                return false;
        }
        return true;
    }

    private void endGameCheck() {
        if (checkWin()) {
            endGame = new EndGame(true, words);
            endGame.display();
            gameOver = true;
        }
        if (guess <= 0) {
            endGame = new EndGame(false, words);
            endGame.display();
            gameOverFixLetters();
            gameOver = true;
        }
    }

    private void gameOverFixLetters() {
        for (Button letter : words) {
            if (!letter.isDisable()) {
                letter.setDisable(true);
                letter.setStyle(("-fx-background-color: #a5faff; -fx-font-size: 16;-fx-text-fill: #000000 ;-fx-opacity: 1"));
                letter.setMinWidth(20);
                letter.setMinHeight(20);
            }
        }
    }
}
