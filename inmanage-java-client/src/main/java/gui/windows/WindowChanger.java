package main.java.gui.windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.gui.ClientLauncher;

import java.io.IOException;
import java.util.HashMap;

public class WindowChanger {
    private FXMLLoader loader;

    public Stage setScene(String window){
        Parent root = null;
        Stage stage = ClientLauncher.getPrimaryStage();
        setFxmlLoader(window);
        try {
            root = loader.load();
        } catch (IOException e) {
            System.out.println("The file for " + window + " could not be found!");
        }
        stage.setTitle("INManage");
        stage.setScene(new Scene(root));
        stage.show();
        return stage;
    }

    private void setFxmlLoader(String fxmlPath){
        loader = new FXMLLoader(getClass().getResource(fxmlPath));
    }
}
