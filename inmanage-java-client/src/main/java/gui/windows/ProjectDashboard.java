package main.java.gui.windows;

import gen.java.model.Project;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.java.gui.ClientLauncher;
import main.java.serverCom.ServerCom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProjectDashboard {

    @FXML
    private ListView<Project> projectList;

    @FXML
    private VBox vboxLeft;

    public ArrayList<Project> list = (ArrayList<Project>) ClientLauncher.getServer().getAllProjects(ClientLauncher.getUserID());


    ServerCom serv = ClientLauncher.getServer();

    @FXML
    public void initialize(){
        vboxLeft.getChildren().add(new Text("Projects:"));
        for (Project proj : list) {
            addProjectView(proj);
        }

    }

    @FXML
    void arrowDown(MouseEvent event) {

    }

    @FXML
    void back(MouseEvent event) {

    }

    @FXML
    void turnOff(MouseEvent event) {

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
            ClientLauncher.getWindowChanger().setScene("fxml/windows/ProjectOverview.fxml");
        });
        vboxLeft.getChildren().add(btn);
    }


}