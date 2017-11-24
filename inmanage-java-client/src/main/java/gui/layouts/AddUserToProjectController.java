package main.java.gui.layouts;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.java.gui.ClientLauncher;
import main.java.serverCom.ServerCom;

import java.util.Objects;

public class AddUserToProjectController {

    @FXML
    private TextArea TextAreaAddedPersons;

    @FXML
    private TextField TextFieldUsernameInput;

    @FXML
    private Button ButtonAdd;

    @FXML
    private Button ButtonClose;

    private final ServerCom serv = ClientLauncher.getServer();

    @FXML
    void onClickAdd(ActionEvent event) {
        if(event.getSource() == ButtonClose){
            ClientLauncher.getWindowChanger().setScene("fxml/layouts/ProjectOverview.fxml");
        }
        if(event.getSource()== ButtonAdd){
            if(!(Objects.equals(TextFieldUsernameInput.getText(), ""))){

                //implement add user method/ call to class
                //responsible for searching database and connects user to current project
                //
                //
                serv.addUserToProject(TextFieldUsernameInput.getText(),ClientLauncher.getProj().getId());

                ClientLauncher.getWindowChanger().setScene("fxml/layouts/ProjectOverview.fxml");

            }
        }
    }




}