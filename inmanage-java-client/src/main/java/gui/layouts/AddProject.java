package main.java.gui.layouts;

import gen.java.model.Project;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.java.gui.ClientLauncher;
import main.java.serverCom.ServerCom;

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

    private final ServerCom serv = ClientLauncher.getServer();

    @FXML
    void addProjectCancelButton(ActionEvent event) {

        ClientLauncher.getWindowChanger().setLayout("ProjectDashboard");

    }

    @FXML
    void addProjectConfirmAction(ActionEvent event) {
        String projName = addProjNameField.getText();
        String projDesc = addProjDescField.getText();

        Project proj = new Project();
        proj.setName(projName);
        proj.setDescription(projDesc);
        proj.setUserid(ClientLauncher.getUserID());

        serv.addProject(proj);

        ClientLauncher.getWindowChanger().setLayout("ProjectDashboard");

        // Remember to auto-bind the project to the user who creates it
        // Use the user info from when he/she logged in.
    }

}

