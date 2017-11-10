package main.java.gui.windows;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import main.java.gui.ClientLauncher;
import main.java.gui.windows.Controller;

public class ProjectOverview extends Controller {

    @FXML
    private ListView<?> projectList;

    @FXML
    void arrowDown(MouseEvent event) {

    }

    @FXML
    void back(MouseEvent event) {
        ClientLauncher.getWindowChanger().setScene("/fxml/windows/Login.fxml");
    }

}