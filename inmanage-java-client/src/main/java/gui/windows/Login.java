package main.java.gui.windows;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.java.gui.ClientLauncher;
import main.java.serverCom.ServerCom;
import main.java.serverCom.ServerComImpl;


public class Login {

    @FXML
    private TextField usernameInput;

    @FXML
    private TextField passwordInput;

    private ServerCom serv = ClientLauncher.getServer();

    public void signUp(ActionEvent actionEvent) {
        ClientLauncher.getWindowChanger().setScene("fxml/windows/SignUp.fxml");
    }

    public void SignIn(ActionEvent actionEvent) {
        String resp = serv.loginUser(usernameInput.getText(),passwordInput.getText());
        //Store resp which is the user UUID in a local user object variable so we can use it later to acces the other data
        System.out.println(resp);
        if((resp)!=null){
            ClientLauncher.getWindowChanger().setScene("fxml/windows/ProjectOverview.fxml");
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error logging in");
            alert.setHeaderText("There was an error logging in");
            alert.setContentText("Are you sure your login information is correct?");

            alert.showAndWait();
        }

    }

    public void turnOff(MouseEvent mouseEvent) {
    }
}




