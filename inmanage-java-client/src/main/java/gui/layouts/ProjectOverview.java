package main.java.gui.layouts;

import gen.java.model.Project;
import gen.java.model.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import main.java.gui.ClientLauncher;
import main.java.gui.components.TaskView;
import main.java.serverCom.ServerCom;

import java.util.ArrayList;

/**
 * Here you get the overview of the project displaying the full title, description and a list of all tasks
 */

public class ProjectOverview extends Controller{

    public Text dueDateText;
    public Label projectName;
    @FXML
    private VBox mainVbox;

    @FXML
    private Text projectNameText;

    @FXML
    private TextArea projectDescText;

    @FXML
    private Button goToTasks;

    @FXML
    private TableView<String> userList;

    @FXML
    private Button addTaskBtn;

    @FXML
    private Button editProj;

    @FXML
    private Button addUser;

    @FXML
    private Button deleteProjBtn;

    @FXML
    private Button backBtn;

    @FXML
    private Label welcomeText;

    ServerCom serv = ClientLauncher.getServer();

    private ArrayList<Task> list;

    private Alert alert;

    @FXML
    public void initialize(){
        //Get a list of all tasks for this project
        list = (ArrayList<Task>) serv.getAllTasks(ClientLauncher.getProj().getId());

        Project proj = ClientLauncher.getProj();
        mainVbox.setAlignment(Pos.CENTER);
        projectName.setTextAlignment(TextAlignment.CENTER);
        projectName.setStyle("-fx-font-size: 30px");
        projectName.setText(proj.getName());
        projectDescText.setStyle("-fx-font-size: 15px");
        projectDescText.setText(proj.getDescription());


        addTaskBtn.setOnAction(event -> ClientLauncher.getWindowChanger().setLayout("AddTask"));

        addUser.setOnAction(event -> ClientLauncher.getWindowChanger().setLayout("AddUserToProject"));

        //Iterate through the list of tasks for this specific project
        list.parallelStream().forEach(task -> new TaskView(task,mainVbox));

        //Set actions of the buttons,
        editProj.setOnAction(event -> {
            ClientLauncher.getWindowChanger().setLayout("EditProject");
        });

        backBtn.setOnAction(event -> {
            ClientLauncher.getWindowChanger().setLayout("ProjectDashboard");
        });

        deleteProjBtn.setOnAction(event -> {
            ClientLauncher.getWindowChanger().setLayout("DeleteProject");
        });

        welcomeText.setText("You're logged in as: " + ClientLauncher.getUser().getName());
    }

    @FXML
    void arrowDown(MouseEvent event) {

    }

    @FXML
    void back(MouseEvent event) {
        ClientLauncher.getWindowChanger().setLayout("ProjectDashboard");
    }

    @FXML
    void turnOff(MouseEvent event) {
        System.exit(1);
    }

    @FXML
    public void GoHome(ActionEvent actionEvent) {
        ClientLauncher.getWindowChanger().setLayout("ProjectDashboard");
    }

    public void GoChat(ActionEvent actionEvent) {
    }

    public void ShowProfile(ActionEvent actionEvent) {
    }

    @FXML
    public void SignOut(ActionEvent actionEvent) {
        alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Sign out?");
        alert.setContentText("Are you sure you'd like to sign out?");

        alert.showAndWait();

        if (alert.getResult() == ButtonType.OK) {
            //ClientLauncher.setUser(null);
            ClientLauncher.getUser().setName("");
            ClientLauncher.getUser().setPassword("");
            welcomeText.setText("");
            ClientLauncher.getWindowChanger().setLayout("Login");

        } if (alert.getResult() == ButtonType.CANCEL) {
            alert.close();
        }
    }
}
