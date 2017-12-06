package main.java.gui.layouts;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.java.gui.ClientLauncher;
import main.java.serverCom.ServerCom;
import main.java.serverCom.ServerComImpl;

public class SignUp{
    @FXML
    private TextField usernameInput;

    @FXML
    private TextField passwordInput;

    @FXML
    private TextField passwordConfirmInput;

    private ServerCom serv = new ServerComImpl();

    public void cancel(ActionEvent actionEvent) {
        ClientLauncher.getWindowChanger().setLayout("fxml/windows/Login.fxml");
    }

    public void signup(ActionEvent actionEvent) {
        if (checkedPassword() == null) {
            passwordConfirmInput.setText("");
            passwordConfirmInput.setPromptText("The passwords don't match");
        } else {
            serv.addUser(checkedUsername(), checkedPassword());
            ClientLauncher.getWindowChanger().setLayout("fxml/windows/ProjectDashboard.fxml");
        }

    }

    private String checkedUsername() {
        //TODO: Create a check if the username is unique
        return usernameInput.getText();
    }

    private String checkedPassword() {
        if (passwordInput.getText().equals(passwordConfirmInput.getText())) {
            System.out.println("Confirmed!");
            return passwordConfirmInput.getText(); }
        return null;
    }

    public void turnOff(MouseEvent mouseEvent) {
        Platform.exit();
    }
}
