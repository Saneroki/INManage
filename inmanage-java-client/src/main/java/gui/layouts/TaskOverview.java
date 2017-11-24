package main.java.gui.layouts;

import gen.java.model.Task;
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

public class TaskOverview extends Controller {

    @FXML
    private ListView<?> projectList;

    @FXML
    private HBox centerHbox;

    private final ServerCom serv = ClientLauncher.getServer();

    private final ArrayList<Task> list = (ArrayList<Task>) serv.getAllTasks(ClientLauncher.getProj().getId());


    @FXML
    void arrowDown(MouseEvent event) {

    }

    @FXML
    void back(MouseEvent event) {
        ClientLauncher.getWindowChanger().setScene("fxml/layouts/ProjectOverview.fxml");
    }

    @FXML
    void turnOff(MouseEvent event) {
        System.exit(1);
    }

    @FXML
    public void initialize(){
        //Make for loop that loops through task statusses and makes one VBOX for each
        //for now we just have one VBOX

        VBox vboxLeft = new VBox();
        centerHbox.getChildren().add(vboxLeft);

        vboxLeft.setAlignment(Pos.CENTER);
        int tmp = 0;
        System.out.println("Starting for loop: ");
        for (Task task: list) {
            System.out.println(tmp++);
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