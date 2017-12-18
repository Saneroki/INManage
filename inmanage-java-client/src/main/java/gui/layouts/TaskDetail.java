package main.java.gui.layouts;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import main.java.gui.ClientLauncher;

import java.util.UUID;

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
    private Button deleteTaskBtn;

    private Alert alert;

    @FXML
    private Label welcomeText;

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

        deleteTaskBtn.setOnAction(event -> {
            ClientLauncher.getServer().deleteTask(ClientLauncher.getTask().getId().toString());
            ClientLauncher.getWindowChanger().setLayout("ProjectOverview");
        });

        welcomeText.setText("You're logged in as: " + ClientLauncher.getUser().getName());
    }

    @FXML
    void GoHome(ActionEvent event) {
        ClientLauncher.getWindowChanger().setLayout("ProjectDashboard");
    }

    @FXML
    void ShowProfile(ActionEvent event) {

    }

    @FXML
    public void SignOut(ActionEvent actionEvent) {
        alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Sign out?");
        alert.setContentText("Are you sure you'd like to sign out?");

        alert.showAndWait();

        if (alert.getResult() == ButtonType.OK) {
            ClientLauncher.setUserId("");
            ClientLauncher.getUser().setName("");
            ClientLauncher.getUser().setPassword("");
            welcomeText.setText("");
            ClientLauncher.getWindowChanger().setLayout("Login");

        } if (alert.getResult() == ButtonType.CANCEL) {
            alert.close();
        }
    }

}
