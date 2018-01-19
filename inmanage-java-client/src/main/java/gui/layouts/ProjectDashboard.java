package main.java.gui.layouts;

import com.sun.scenario.animation.shared.ClipInterpolator;
import gen.java.model.Project;
import gen.java.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.java.gui.ClientLauncher;
import main.java.gui.components.ProjectView;
import main.java.serverCom.ServerCom;

import java.util.ArrayList;

/**
 * The controller for the fxml where you land after logging in, displays the projects and some basic functionality.
 */

public class ProjectDashboard extends Controller {

    @FXML
    private VBox vboxLeft;

    @FXML
    private Button addNewProjectBtn;

    @FXML
    private Button editUserBtn;

    @FXML
    private Label welcomeText;

    private Alert alert;


    private final ArrayList<Project> list =
            (ArrayList<Project>) ClientLauncher.getServer().getAllProjects(ClientLauncher.getUser().getId().toString());


    private ServerCom serv = ClientLauncher.getServer();

    @FXML
    public void initialize() {
        vboxLeft.setSpacing(15);
        vboxLeft.setMinWidth(250);
        vboxLeft.setMaxHeight(250);

        list.parallelStream().forEach(proj -> new ProjectView(proj, serv.getUserAmount(proj.getId()), serv.getTaskAmount(proj.getId()), vboxLeft));


        addNewProjectBtn.setOnAction(event -> ClientLauncher.getWindowChanger().setLayout("AddProject"));

        editUserBtn.setOnAction(event -> ClientLauncher.getWindowChanger().setLayout("EditUser"));

        welcomeText.setText("You're logged in as: " + ClientLauncher.getUser().getName());

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


    private void populateListView() {
        //list = serv.getAllProjects(ClientLauncher.getUserID());

        //projectList = new ListView<Project>();

    }

    @FXML
    public void GoHome(ActionEvent actionEvent) {
        ClientLauncher.getWindowChanger().setLayout("ProjectDashboard");
    }

    @FXML
    public void SignOut(ActionEvent actionEvent) {
        alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Sign out?");
        alert.setContentText("Are you sure you'd like to sign out?");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.OK) {
            ClientLauncher.setUser(null);
            welcomeText.setText("");
            ClientLauncher.getWindowChanger().setLayout("Login");

        } if (alert.getResult() == ButtonType.CANCEL) {
            alert.close();
        }
    }
}