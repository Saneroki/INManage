package main.java.gui.layouts;

import gen.java.model.Project;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import main.java.gui.ClientLauncher;
import main.java.serverCom.ServerCom;

public class ProjectOverview {

    public Text dueDateText;
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
    private Button addUser;

    ServerCom serv = ClientLauncher.getServer();

    @FXML
    public void initialize(){


        Project proj = ClientLauncher.getProj();

        mainVbox.setAlignment(Pos.CENTER);

        projectNameText.setTextAlignment(TextAlignment.CENTER);
        projectNameText.setStyle("-fx-font-size: 30px");
        projectNameText.setText(proj.getName());
        projectDescText.setStyle("-fx-font-size: 15px");
        projectDescText.setText(proj.getDescription());

        goToTasks.setOnAction(event -> {
            System.out.println("Current proj id: " + ClientLauncher.getProj().getId());
            ClientLauncher.getWindowChanger().setScene("fxml/layouts/TaskOverview.fxml");
        });

        addTaskBtn.setOnAction(event -> ClientLauncher.getWindowChanger().setScene("fxml/layouts/AddTask.fxml"));

        addUser.setOnAction(event -> ClientLauncher.getWindowChanger().setScene("fxml/layouts/AddUserToProject.fxml"));
    }

    @FXML
    void arrowDown(MouseEvent event) {

    }

    @FXML
    void back(MouseEvent event) {
        ClientLauncher.getWindowChanger().setScene("fxml/layouts/ProjectDashboard.fxml");
    }

    @FXML
    void turnOff(MouseEvent event) {
        System.exit(1);
    }


}
