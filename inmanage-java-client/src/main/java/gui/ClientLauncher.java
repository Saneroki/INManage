package main.java.gui;

/*
  Created by Glenn on 25/10/2017.
*/
import gen.java.model.Project;
import gen.java.model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.java.gui.windows.WindowChanger;
import main.java.serverCom.ServerCom;
import main.java.serverCom.ServerComImpl;

import java.io.IOException;

public class ClientLauncher extends Application {
    private static WindowChanger windowChanger;
    private static Stage primaryStage;
    private static ServerCom serv;
    private static String userID;
    private static String currentProjectId;
    //Here i will save the project locally and use it,
    //I think that in the future i will have use a sql command to get it for the specific projects
    private static Project proj;

    @Override
    public void start(Stage primaryStage) throws Exception{
        serv = new ServerComImpl();
        this.primaryStage = primaryStage;
        primaryStage.initStyle(StageStyle.UNDECORATED);
        windowChanger = new WindowChanger();
        windowChanger.setScene("fxml/windows/Login.fxml");
        primaryStage.isMaximized();
    }

    public static WindowChanger getWindowChanger(){
        return windowChanger;
    }

    public static Stage getPrimaryStage(){
        return primaryStage;
    }

    public void turnOff(){
        Platform.exit();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static ServerCom getServer(){ return serv; }

    public static void setUserId(String setUserID){
        userID = setUserID;
    }

    public static String getUserID(){return userID;}

    public static String getCurrentProjectId() {
        return currentProjectId;
    }

    public static void setCurrentProjectId(String currentProjectId) {
        ClientLauncher.currentProjectId = currentProjectId;
    }

    public static Project getProj() {
        return proj;
    }

    public static void setProj(Project proj) {
        ClientLauncher.proj = proj;
    }
}
