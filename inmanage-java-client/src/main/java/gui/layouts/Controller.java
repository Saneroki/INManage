package main.java.gui.layouts;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class Controller {
    @FXML
    private AnchorPane root;

    public void turnOff(){
        Platform.exit();
    }

    public void setContent(Node node){
        root.getChildren().setAll(node);
    }
}
