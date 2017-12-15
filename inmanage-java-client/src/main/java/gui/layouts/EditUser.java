package main.java.gui.layouts;


/**
 * Created by omnhaww on 14/12/2017.
 */

import gen.java.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.java.gui.ClientLauncher;
import main.java.serverCom.ServerCom;

public class EditUser {

    @FXML
    private Button editUserCancelBtn;

    @FXML
    private TextField editUserCurrentPWField;

    @FXML
    private TextField editUsernameField;

    @FXML
    private TextField editUserConfirmPWField;

    @FXML
    private TextField editUserNewPWField;

    @FXML
    private Button editUserConfirmBtn;

    private ServerCom serv = ClientLauncher.getServer();
    private User user;


    @FXML
    public void initialize() {

        user = ClientLauncher.getUser();
        editUsernameField.setText(user.getName());

    }

    @FXML
    void editUserConfirmAction(ActionEvent event) {

        if(editUserCurrentPWField.getText().equals(user.getPassword())){
            if(editUserNewPWField.getText().equals(editUserConfirmPWField.getText())){
                user.setName(editUsernameField.getText());
                user.setPassword(editUserConfirmPWField.getText());
                serv.editUser(user);
                ClientLauncher.getWindowChanger().setLayout("ProjectDashboard");
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("The passwords doesn't match!");
                alert.setHeaderText("Password error");
                alert.setContentText("You need to make sure your passwords match!");
                alert.showAndWait();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Wrong current password!");
            alert.setHeaderText("Password error");
            alert.setContentText("You need to enter the correct current password!");
            alert.showAndWait();
        }

    }

    @FXML
    void editUserCancelAction(ActionEvent event) {
        ClientLauncher.getWindowChanger().setLayout("ProjectDashboard");
    }
}
