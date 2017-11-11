package main.java.gui.windows;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Created by omnhaww on 10/11/2017.
 */

public class AddProject {

    @FXML
    private TextField addProjNameField;

    @FXML
    private TextArea addProjDescField;

    @FXML
    private Button addProjConfirmBtn;

    @FXML
    private Button addProjCancelBtn;

    private String projName;

    private String projDesc;

    @FXML
    void addProjectCancelButton(ActionEvent event) {
        System.exit(1);
    }

    @FXML
    void addProjectConfirmAction(ActionEvent event) {
        projName = addProjNameField.getText();
        projDesc = addProjDescField.getText();

        // Remember to auto-bind the project to the user who creates it
        // Use the user info from when he/she logged in.
    }

}

