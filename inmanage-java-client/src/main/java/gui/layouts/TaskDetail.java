package main.java.gui.layouts;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
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
    private Text taskDesc;

    @FXML
    private Label taskDue;

    @FXML
    private Label taskTitle;

    @FXML
    private Button editTaskBtn;

    @FXML
    private Button backBtn;

    @FXML
    void GoChat(ActionEvent event) {

    }

    @FXML
    public void initialize(){
        taskTitle.setText(ClientLauncher.getTask().getName());
        taskDesc.setText(ClientLauncher.getTask().getDescription());
        taskDue.setText(ClientLauncher.getTask().getDuedate());

        editTaskBtn.setOnAction(event -> ClientLauncher.getWindowChanger().setLayout("EditTask"));

        backBtn.setOnAction(event -> {
            ClientLauncher.getWindowChanger().setLayout("ProjectOverview");
        });
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
