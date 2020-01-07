import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Data {
    private VBox rightSide = new VBox(10);
    private Guesses guesses = new Guesses();
    private Word word = new Word();
    private Alphabet alphabet;
    private KeyPress keyPress;

    public Data(Man man, String x, Alphabet a) {
        if (x == null) {
            word.activateWord();
            alphabet = new Alphabet();
        } else {
            word.activateWord(x);
            this.alphabet = a;
        }
        rightSide.setPadding(new Insets(10));
        keyPress = new KeyPress(guesses, word.getListOfLetter(), alphabet.getListOfButtons(), man);
        rightSide.getChildren().addAll(guesses.getGuesses(), word.getWord(), alphabet.getAlpha());
        rightSide.setAlignment(Pos.CENTER_LEFT);
        rightSide.setPrefWidth(900);
        rightSide.setPrefHeight(600);
        rightSide.setBackground(new Background(new BackgroundFill(Color.web("#ffd1dc"), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public KeyPress getKeyPress() {
        return keyPress;
    }

    public VBox getRightSide() {
        return rightSide;
    }
}