package main.java.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class WindowChanger {
    private FXMLLoader loader;
    private static HashMap<String, String> windows;

    public WindowChanger(){
        windows = new HashMap<String, String>();
        windows.put("Login", "/main/java/gui/Login.fxml");
        windows.put("SignUp", "/main/java/gui/windows/SignUp.fxml");
        windows.put("Dashboard", "/main/java/gui/windows/Dashboard.fxml");
    }

    public Stage setScene(String window){
        Parent root = null;
        Stage stage = ClientLauncher.getPrimaryStage();
        loader = new FXMLLoader(getClass().getResource("/main/java/gui/Login.fxml"));
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

    private String getFxmlPath(String window){
        String fxmlPath = windows.get(window);
        return fxmlPath;
    }

    private void setFxmlLoader(String fxmlPath){
        loader = new FXMLLoader(getClass().getResource(fxmlPath));
    }
}
