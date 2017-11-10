package main.java.gui.windows;

import gen.java.model.Project;
import gen.java.model.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import main.java.gui.ClientLauncher;
import main.java.gui.windows.Controller;
import main.java.serverCom.ServerCom;

import java.util.ArrayList;

public class ProjectOverview extends Controller {

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


    }

}