package main.java.gui.layouts;

import gen.java.model.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.java.gui.ClientLauncher;
import main.java.serverCom.ServerCom;

import java.util.ArrayList;

/**
 *
 * Controller for the TaskDetail fxml controller.
 *
 */

public class TaskOverview extends Controller {

    @FXML
    private ListView<?> projectList;

    @FXML
    private HBox centerHbox;

    private final ServerCom serv = ClientLauncher.getServer();

    private ArrayList<Task> list;

    @FXML
    private Button backBtn;

    @FXML
    void arrowDown(MouseEvent event) {

    }

    @FXML
    void back(MouseEvent event) {
        ClientLauncher.getWindowChanger().setLayout("ProjectOverview");
    }

    @FXML
    void turnOff(MouseEvent event) {
        System.exit(1);
    }

    @FXML
    public void initialize(){

        //Get the list of all the tasks for this project
        list = (ArrayList<Task>) serv.getAllTasks(ClientLauncher.getProj().getId());

        //Make new VBox and iterate through the list of tasks, adding them to the VBox with a taskview one by one.
        //an example of threading in out program
        VBox vboxLeft = new VBox();
        centerHbox.getChildren().add(vboxLeft);
        vboxLeft.setAlignment(Pos.CENTER);
        list.parallelStream().forEach(task -> taskView(task, vboxLeft));

        backBtn.setOnAction(event -> {
            ClientLauncher.getWindowChanger().setLayout("ProjectOverview");
        });

    }

    private void taskView(Task task, VBox vbox){
        String taskText = task.getName() + "\n" + task.getDescription() + "\n" + task.getDuedate();
        Button btn = new Button(taskText);
        btn.setStyle("-fx-border-radius: 5px");
        btn.setStyle("-fx-font-size: 20px");
        btn.setAlignment(Pos.CENTER);
        vbox.getChildren().add(btn);
    }

    public void GoHome(ActionEvent actionEvent) {ClientLauncher.getWindowChanger().setLayout("ProjectDashboard");
    }

    public void GoChat(ActionEvent actionEvent) {
    }

    public void ShowProfile(ActionEvent actionEvent) {
    }

    public void SignOut(ActionEvent actionEvent) {ClientLauncher.getWindowChanger().setLayout("Login");
    }
}