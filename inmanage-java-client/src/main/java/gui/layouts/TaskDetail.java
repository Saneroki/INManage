package main.java.gui.layouts;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import main.java.gui.ClientLauncher;

public class TaskDetail extends Controller {

    @FXML
    private Button HomeBtn;

    @FXML
    private Button ChatBtn;

    @FXML
    private MenuButton UserProfile;

    @FXML
    private MenuItem MyProfile;

    @FXML
    private MenuItem SignOut;

    @FXML
    private HBox centerHbox;

    @FXML
    void GoChat(ActionEvent event) {

    }

    @FXML
    void GoHome(ActionEvent event) {
        ClientLauncher.getWindowChanger().setLayout("ProjectDashboard");
    }

    @FXML
    void ShowProfile(ActionEvent event) {

    }

    @FXML
    void SignOut(ActionEvent event) {
        ClientLauncher.getWindowChanger().setLayout("Login");
    }

}
