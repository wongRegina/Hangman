import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Word {
    private ArrayList<String> words = new ArrayList<>();
    private FlowPane word = new FlowPane(2, 2);
    private ArrayList<Button> listOfLetter = new ArrayList<>();

    public Word() {
        try {
            BufferedReader b = new BufferedReader(new FileReader(new File("words.txt")));
            String readLine = "";
            while ((readLine = b.readLine()) != null) {
                words.add(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String activateWord() {
        String word = words.get(new Random().nextInt(words.size()));
        String[] letters = word.toUpperCase().split("");
        for (String x : letters) {
            Button button = new Button(x);
            button.setStyle(("-fx-background-color: #000000; -fx-font-size: 16;-fx-text-fill: black ;-fx-opacity: 1"));
            button.setMinWidth(20);
            button.setMinHeight(20);
            (this.word).getChildren().add(button);
            listOfLetter.add(button);
        }
        return word;
    }

    public String activateWord(String word) {
        String[] letters = word.toUpperCase().split("");
        for (String x : letters) {
            Button button = new Button(x);
            button.setStyle(("-fx-background-color: #000000; -fx-font-size: 16;-fx-text-fill: white ;-fx-opacity: 1"));
            button.setMinWidth(20);
            button.setMinHeight(20);
            (this.word).getChildren().add(button);
            listOfLetter.add(button);
        }
        return word;
    }

    public ArrayList<Button> getListOfLetter() {
        return listOfLetter;
    }

    public FlowPane getWord() {
        return word;
    }
}
