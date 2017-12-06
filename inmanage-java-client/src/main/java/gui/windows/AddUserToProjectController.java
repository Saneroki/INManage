package main.java.gui.windows;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.java.gui.ClientLauncher;
import main.java.serverCom.ServerCom;
import org.omg.CORBA.INITIALIZE;

public class AddUserToProjectController {

    @FXML
    private TextArea TextAreaAddedPersons;

    @FXML
    private TextField TextFieldUsernameInput;

    @FXML
    private Button ButtonAdd;

    @FXML
    private Button ButtonClose;

    ServerCom serv = ClientLauncher.getServer();

    @FXML
    void onClickAdd(ActionEvent event) {
        if(event.getSource() == ButtonClose){
            ClientLauncher.getWindowChanger().setScene("fxml/windows/ProjectOverview.fxml");
        }
        if(event.getSource()== ButtonAdd){
            if(!(TextFieldUsernameInput.getText()=="")){

                //implement add user method/ call to class
                //responsible for searching database and connects user to current project
                //
                //
                serv.addUserToProject(TextFieldUsernameInput.getText().toString(),ClientLauncher.getProj().getId());

                ClientLauncher.getWindowChanger().setScene("fxml/windows/ProjectOverview.fxml");

            }
        }
    }




}