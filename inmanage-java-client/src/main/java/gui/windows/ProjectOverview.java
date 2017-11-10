package main.java.gui.windows;

import gen.java.model.Project;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.java.gui.ClientLauncher;
import main.java.serverCom.ServerCom;

public class ProjectOverview {

    @FXML
    private VBox mainVbox;

    @FXML
    private Text projectNameText;

    @FXML
    private Text projectDescText;

    @FXML
    private Text dueDateText;

    @FXML
    private Button goToTasks;

    @FXML
    private TableView<String> userList;

    ServerCom serv = ClientLauncher.getServer();

    @FXML
    public void initialize(){

        Project proj = serv.get

    }


}
