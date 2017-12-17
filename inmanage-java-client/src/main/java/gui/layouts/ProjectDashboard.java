package main.java.gui.layouts;

import gen.java.model.Project;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.java.gui.ClientLauncher;
import main.java.gui.components.ProjectView;
import main.java.serverCom.ServerCom;

import java.util.ArrayList;

public class ProjectDashboard extends Controller {

    @FXML
    private VBox vboxLeft;

    @FXML
    private Button addNewProjectBtn;

    @FXML
    private Button editUserBtn;


    private final ArrayList<Project> list =
            (ArrayList<Project>) ClientLauncher.getServer().getAllProjects(ClientLauncher.getUserID());


    private ServerCom serv = ClientLauncher.getServer();

    @FXML
    public void initialize(){
        vboxLeft.setSpacing(15);
        vboxLeft.setMinWidth(250);
        vboxLeft.setMaxHeight(250);

        list.parallelStream().forEach(proj -> new ProjectView(proj,serv.getUserAmount(proj.getId()),serv.getTaskAmount(proj.getId()),vboxLeft));



        addNewProjectBtn.setOnAction(event -> ClientLauncher.getWindowChanger().setLayout("AddProject"));

        editUserBtn.setOnAction(event -> ClientLauncher.getWindowChanger().setLayout("EditUser"));
    }

    @FXML
    void arrowDown(MouseEvent event) {

    }

    @FXML
    void back(MouseEvent event) {
        ClientLauncher.getWindowChanger().setLayout("Login");
    }

    @FXML
    void turnOff(MouseEvent event) {
        System.exit(1);
    }



    private void populateListView(){
        //list = serv.getAllProjects(ClientLauncher.getUserID());

        //projectList = new ListView<Project>();

    }

    public void GoHome(ActionEvent actionEvent) {
        ClientLauncher.getWindowChanger().setLayout("ProjectDashboard");
    }

    public void ShowProfile(ActionEvent actionEvent) {
    }

    public void SignOut(ActionEvent actionEvent) {
        ClientLauncher.getWindowChanger().setLayout("Login");
    }
}