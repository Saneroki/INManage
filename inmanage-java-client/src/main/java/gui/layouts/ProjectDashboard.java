package main.java.gui.layouts;

import gen.java.model.Project;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.java.gui.ClientLauncher;
import main.java.serverCom.ServerCom;

import java.util.ArrayList;

public class ProjectDashboard {

    @FXML
    private ListView<Project> projectList;

    @FXML
    private VBox vboxLeft;

    @FXML
    private Button addNewProjectBtn;

    private final ArrayList<Project> list = (ArrayList<Project>) ClientLauncher.getServer().getAllProjects(ClientLauncher.getUserID());


    ServerCom serv = ClientLauncher.getServer();



    @FXML
    public void initialize(){
        vboxLeft.getChildren().add(new Text("Projects:"));
        for (Project proj : list) {
            addProjectView(proj);
        }

        addNewProjectBtn.setOnAction(event -> ClientLauncher.getWindowChanger().setLayout("AddProject"));

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

    private void addProjectView(Project proj){
        String btnText = proj.getName() + "\n " + proj.getDescription();
        Button btn = new Button(btnText);
        btn.setMinWidth(300);
        btn.setMaxWidth(300);
        btn.setAlignment(Pos.CENTER);
        vboxLeft.setAlignment(Pos.CENTER);
        vboxLeft.setStyle("-fx-font-size: 20px");
        btn.setOnAction(event -> {
            ClientLauncher.setCurrentProjectId(proj.getId());
            //delete later
            ClientLauncher.setProj(proj);
            ClientLauncher.getWindowChanger().setLayout("ProjectOverview");
        });
        vboxLeft.getChildren().add(btn);
    }


}