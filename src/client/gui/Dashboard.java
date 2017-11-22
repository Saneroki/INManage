package client.gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class Dashboard {

    @FXML
    void TurnOff(MouseEvent event) {
        Platform.exit();
    }
}
