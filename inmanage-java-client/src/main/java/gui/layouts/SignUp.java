package main.java.gui.layouts;

import javafx.application.Platform;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.java.gui.ClientLauncher;
import main.java.serverCom.ServerCom;
import main.java.serverCom.ServerComImpl;

/**
 *
 * Controller for the SignUp fxml file
 *
 */

public class SignUp extends Controller{

    Alert alert;

    @FXML
    private TextField usernameInput;

    @FXML
    private TextField passwordInput;

    @FXML
    private TextField passwordConfirmInput;

    @FXML
    private Button signUpBtn;

    private final ServerCom serv = new ServerComImpl();

    public void cancel(ActionEvent actionEvent) {
        ClientLauncher.getWindowChanger().setLayout("Login");
    }

    public void signup(ActionEvent actionEvent) {
        if (checkedPassword().length() > 0 && checkedUsername() != null) {
            serv.addUser(checkedUsername(), checkedPassword());
            ClientLauncher.getWindowChanger().setLayout("Login");
        }

    }

    private String checkedUsername() {
        //TODO: Create a check if the username is unique
        if (!serv.searchUser(usernameInput.getText(), 999).isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Username taken");
            alert.setContentText("The username you picked is already occupied. \n" +
                    "Please try again.");
            alert.showAndWait();
        }
        else if (serv.searchUser(usernameInput.getText(), 999).isEmpty()) {
            return usernameInput.getText();
        }
        return null;
    }


    private String checkedPassword() {
        if (passwordInput.getText().isEmpty() | passwordConfirmInput.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Password field is empty");
            alert.setContentText("Please specify your desired password. \n" +
                    "Please try again.");
            alert.showAndWait();
        }

        if (!passwordInput.getText().equals(passwordConfirmInput.getText())) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Passwords do not match.");
            alert.setContentText("Please enter the same password in both textboxes. \n" +
                    "Please try again.");
            alert.showAndWait();
        } else {
            return passwordConfirmInput.getText();
        }
        return null;
    }

}
