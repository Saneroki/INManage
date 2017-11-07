package main.java.gui.windows;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.java.gui.ClientLauncher;
import main.java.serverCom.ServerCom;

public class SignUp{
    @FXML
    private TextField usernameInput;

    @FXML
    private TextField passwordInput;

    @FXML
    private TextField passwordConfirmInput;



    public void cancel(ActionEvent actionEvent) {
        ClientLauncher.getWindowChanger().setScene("/fxml/windows/Login.fxml");
    }

    public void signup(ActionEvent actionEvent) {
        if (checkedPassword() == null) {
            passwordConfirmInput.setText("");
            passwordConfirmInput.setPromptText("The passwords don't match");
        } else {
            ServerCom.createUser(checkedUsername(), checkedPassword());
            ClientLauncher.getWindowChanger().setScene("/fxml/windows/Dashboard.fxml");
        }

    }

    private String checkedUsername() {
        //TODO: Create a check if the username is unique
        return usernameInput.getText();
    }

    private String checkedPassword() {
        if (passwordInput.getText().equals(passwordConfirmInput.getText())) {
            return passwordConfirmInput.getText(); }
        return null;
    }

    public void turnOff(MouseEvent mouseEvent) {
        Platform.exit();
    }
}
