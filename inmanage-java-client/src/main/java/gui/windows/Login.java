package main.java.gui.windows;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.java.gui.ClientLauncher;


public class Login {

    @FXML
    private TextField usernameInput;

    @FXML
    private TextField UsernameInput;

    public void signUp(ActionEvent actionEvent) {
        ClientLauncher.getWindowChanger().setScene("/fxml/windows/SignUp.fxml");
    }

    public void SignIn(ActionEvent actionEvent) {
        ClientLauncher.getWindowChanger().setScene("/fxml/windows/ProjectOverview.fxml");
    }

    public void turnOff(MouseEvent mouseEvent) {
    }
}




