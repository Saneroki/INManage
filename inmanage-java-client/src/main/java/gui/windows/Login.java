package main.java.gui.windows;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import main.java.gui.ClientLauncher;


public class Login{
    public void signUp(ActionEvent actionEvent) {
        ClientLauncher.getWindowChanger().setScene("/fxml/windows/SignUp.fxml");
    }

    public void SignIn(ActionEvent actionEvent) {
        ClientLauncher.getWindowChanger().setScene("/fxml/windows/Dashboard.fxml");
    }

    public void turnOff(MouseEvent mouseEvent) {
        Platform.exit();
    }
}
