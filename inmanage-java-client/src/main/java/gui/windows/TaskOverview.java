package main.java.gui.windows;

import gen.java.model.Project;
import gen.java.model.Task;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.java.gui.ClientLauncher;
import main.java.gui.windows.Controller;
import main.java.serverCom.ServerCom;

import java.util.ArrayList;

public class TaskOverview extends Controller {

    @FXML
    private ListView<?> projectList;

    @FXML
    private HBox centerHbox;

    ServerCom serv = ClientLauncher.getServer();

    private ArrayList<Task> list = (ArrayList<Task>) serv.getAllTasks(ClientLauncher.getCurrentProjectId());


    @FXML
    void arrowDown(MouseEvent event) {

    }

    @FXML
    void back(MouseEvent event) {
        ClientLauncher.getWindowChanger().setScene("/fxml/windows/Login.fxml");
    }

    @FXML
    public void initialize(){
        //Make for loop that loops through task statusses and makes one VBOX for each
        //for now we just have one VBOX

        VBox vboxLeft = new VBox();
        centerHbox.getChildren().add(vboxLeft);

        vboxLeft.setAlignment(Pos.CENTER);

        for (Task task: list) {
            taskView(task, vboxLeft);
        }


    }

    private void taskView(Task task, VBox vbox){
        String taskText = task.getName() + "\n" + task.getDescription() + "\n" + task.getDuedate();
        Button btn = new Button(taskText);
        btn.setStyle("-fx-border-radius: 5px");
        btn.setStyle("-fx-font-size: 20px");
        btn.setAlignment(Pos.CENTER);
        vbox.getChildren().add(btn);
    }

}