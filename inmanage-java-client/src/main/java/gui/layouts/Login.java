package main.java.gui.layouts;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.java.gui.ClientLauncher;
import main.java.serverCom.ServerCom;


public class Login extends Controller {

    @FXML
    private TextField usernameInput;

    @FXML
    private PasswordField passwordInput;

    private final ServerCom serv = ClientLauncher.getServer();

    public void signUp(ActionEvent actionEvent) {
        ClientLauncher.getWindowChanger().setLayout("SignUp");
    }

    public void SignIn(ActionEvent actionEvent) {
        String resp = serv.loginUser(usernameInput.getText(),passwordInput.getText());
        //Store resp which is the user UUID in a local user object variable so we can use it later to acces the other data
        System.out.println(resp);
        ClientLauncher.setUserId(resp);
        if((resp)!=null){
            ClientLauncher.getWindowChanger().setLayout("ProjectDashboard");
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error logging in");
            alert.setHeaderText("There was an error logging in");
            alert.setContentText("Are you sure your login information is correct?");

            alert.showAndWait();
        }

    }

    public void turnOff(MouseEvent mouseEvent) {
        System.exit(1);
    }

    public void open(MouseEvent mouseEvent) {
    }
}