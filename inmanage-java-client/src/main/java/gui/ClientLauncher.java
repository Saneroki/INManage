package main.java.gui;

import gen.java.model.Project;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import main.java.serverCom.ServerCom;
import main.java.serverCom.ServerComImpl;

import java.io.IOException;

/**
 * This class is meant to start the Gui Client
 *
 * @author Glenn
 */
public class ClientLauncher extends Application {
    private static GUIManager guiManager;
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
        setupStartGui(primaryStage);

    }

    /**
     * Sets up the basics of the starting Gui
     * @author Glenn
     */
    private static void setupStartGui(Stage primaryStage){
        ClientLauncher.primaryStage = primaryStage;
        primaryStage.getIcons().add(new Image("img/inManage_150px.png"));
        guiManager = new GUIManager();
        guiManager.setLayout("Login");
        primaryStage.setMaximized(true);
    }

    public static GUIManager getWindowChanger(){
        return guiManager;
    }

    public static Stage getPrimaryStage(){
        return primaryStage;
    }

    /**
     * Will exit the whole Client.
     */
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
