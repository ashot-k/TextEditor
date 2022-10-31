package texteditor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.*;

public class Controller {
    @FXML
    Button b;
    //REFERENCE TO TEXT AREA
    @FXML
    TextArea mainBody;
    // FILE CHOOSER FOR OPENING AND SAVING FILES
    FileChooser fileChooser = new FileChooser();
    File currentFile;

    //FILE TAB BUTTONS
    public void saveButton(ActionEvent e) throws FileNotFoundException {
        Window stage = mainBody.getScene().getWindow();

        // write on the same file if currently editing it
        if (((MenuItem)e.getSource()).getId().equals("saveButton"))
            if (currentFile != null) {
                writeFile(currentFile);
                return;
            }

            //choose file destination
            fileChooser.setTitle("Save");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Document ", "*.txt"));
            if(currentFile != null) fileChooser.setInitialFileName(currentFile.getName());
            File file = fileChooser.showSaveDialog(stage);

            //try to create text file at destination
            writeFile(file);

    }

    public void writeFile(File file) throws FileNotFoundException {
        if (file != null)
            try (PrintWriter output = new PrintWriter(file)) {
                output.println(mainBody.getText());
            }
    }

    public void openButton() {
        Window stage = mainBody.getScene().getWindow();

        fileChooser.setTitle("Open File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Document ", "*.txt"));
        File file = fileChooser.showOpenDialog(stage);
        //try reading text from file
        if (file != null) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                StringBuffer textFromFile = new StringBuffer("");
                while (line != null) {
                    textFromFile.append(line);
                    textFromFile.append(System.lineSeparator());
                    line = br.readLine();
                }
                //displaying text on main body
                mainBody.setText(textFromFile.toString());

            } catch (IOException err) {
                System.out.println(err);
            }
            currentFile = file;
            System.out.println(file);
        }

    }

    public void closeButton() {
        System.exit(0);
    }
    //EDIT TAB BUTTONS


    //FORMAT TAB BUTTONS

}