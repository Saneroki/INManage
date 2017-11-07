package main.java.gui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import main.java.gui.ClientLauncher;
import main.java.gui.windows.Windows;


public class Login{
    public void signUp(ActionEvent actionEvent) {
        ClientLauncher.getWindowChanger().setScene("SignUp");
    }

    public void SignIn(ActionEvent actionEvent) {
        ClientLauncher.getWindowChanger().setScene("Dashboard");
    }

    public void turnOff(MouseEvent mouseEvent) {
        Platform.exit();
    }
}
