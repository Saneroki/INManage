package main.java.gui.layouts;

import gen.java.model.Project;
import gen.java.model.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import main.java.gui.ClientLauncher;
import main.java.gui.components.TaskView;
import main.java.serverCom.ServerCom;

import java.util.ArrayList;

public class ProjectOverview extends Controller{

    public Text dueDateText;
    public Label projectName;
    @FXML
    private VBox mainVbox;

    @FXML
    private Text projectNameText;

    @FXML
    private Text projectDescText;

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
    private Button backBtn;

    ServerCom serv = ClientLauncher.getServer();

    private ArrayList<Task> list;

    @FXML
    public void initialize(){

        list = (ArrayList<Task>) serv.getAllTasks(ClientLauncher.getProj().getId());

        Project proj = ClientLauncher.getProj();

        mainVbox.setAlignment(Pos.CENTER);

        projectName.setTextAlignment(TextAlignment.CENTER);
        projectName.setStyle("-fx-font-size: 30px");
        projectName.setText(proj.getName());
        projectDescText.setStyle("-fx-font-size: 15px");
        projectDescText.setText(proj.getDescription());

        goToTasks.setOnAction(event -> {
            System.out.println("Current proj id: " + ClientLauncher.getProj().getId());
            ClientLauncher.getWindowChanger().setLayout("TaskOverview");
        });

        editProj.setOnAction(event -> {
            ClientLauncher.getWindowChanger().setLayout("EditProject");
        });

        addTaskBtn.setOnAction(event -> ClientLauncher.getWindowChanger().setLayout("AddTask"));

        addUser.setOnAction(event -> ClientLauncher.getWindowChanger().setLayout("AddUserToProject"));

        list.parallelStream().forEach(task -> new TaskView(task,mainVbox));

        backBtn.setOnAction(event -> {
            ClientLauncher.getWindowChanger().setLayout("ProjectDashboard");
        });
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


    public void GoHome(ActionEvent actionEvent) {
        ClientLauncher.getWindowChanger().setLayout("ProjectDashboard");
    }

    public void GoChat(ActionEvent actionEvent) {
    }

    public void ShowProfile(ActionEvent actionEvent) {
    }

    public void SignOut(ActionEvent actionEvent) {
        ClientLauncher.getWindowChanger().setLayout("Login");
    }
}
