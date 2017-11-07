package main.java.gui.windows;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class Dashboard extends Windows {

    @FXML
    void TurnOff(MouseEvent event) {
        Platform.exit();
    }
}
