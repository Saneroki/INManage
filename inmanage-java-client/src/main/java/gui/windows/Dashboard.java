package main.java.gui.windows;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class Dashboard extends Controller {

    @FXML
    void TurnOff(MouseEvent event) {
        Platform.exit();
    }
}
