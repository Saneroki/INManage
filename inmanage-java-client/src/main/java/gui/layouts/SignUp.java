package main.java.gui.layouts;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.java.gui.ClientLauncher;
import main.java.serverCom.ServerCom;
import main.java.serverCom.ServerComImpl;

public class SignUp extends Controller{
    @FXML
    private TextField usernameInput;

    @FXML
    private TextField passwordInput;

    @FXML
    private TextField passwordConfirmInput;

    private final ServerCom serv = new ServerComImpl();

    public void cancel(ActionEvent actionEvent) {
        ClientLauncher.getWindowChanger().setLayout("Login");
    }

    public void signup(ActionEvent actionEvent) {
        Alert alert;
        if (checkedPassword() == null) {
            passwordInput.setText("");
            passwordConfirmInput.setText("");
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error with Password field");
            alert.setContentText("The passwords do not match,\n " +
                    "please try again.");
            alert.showAndWait();
        } else {
            serv.addUser(checkedUsername(), checkedPassword());
            ClientLauncher.getWindowChanger().setLayout("Login");
        }

    }

    private String checkedUsername() {
        //TODO: Create a check if the username is unique
        return usernameInput.getText();
    }


    //TODO: Better check needed. Like if the Password is null or to short etc.
    private String checkedPassword() {
        if (passwordInput.getText().equals(passwordConfirmInput.getText())) {
            return passwordConfirmInput.getText(); }
        return null;
    }

}
