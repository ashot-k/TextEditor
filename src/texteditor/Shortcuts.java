package texteditor;

import javafx.scene.Parent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Shortcuts {



    public static void shortcutSetup(Parent scene, Stage primaryStage){

        KeyCombination combination = new KeyCodeCombination(KeyCode.W,KeyCodeCombination.SHIFT_DOWN);

        scene.setOnKeyPressed(event -> {
            if (combination.match(event)){



            }

        });


    }

}
