package main.java.gui;

import gen.java.model.Project;
import gen.java.model.Task;
import gen.java.model.User;
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
 * This class is used for keeping track of important variables that are shared across the gui
 * these include the current user, project and task. All of this is static to make it accesible
 * from everywhere.
 */
public class ClientLauncher extends Application {
    private static GUIManager guiManager;
    private static Stage primaryStage;
    private static ServerCom serv;
    private static Project proj;
    private static Task task;
    private static User user = null;


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
        primaryStage.setTitle("INManage");
        primaryStage.show();
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
        launch();
    }

    public static ServerCom getServer(){ return serv; }

    public static Project getProj() {
        return proj;
    }

    public static void setProj(Project proj) {
        ClientLauncher.proj = proj;
    }

    public static Task getTask() {
        return task;
    }

    public static void setTask(Task task) {
        ClientLauncher.task = task;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        ClientLauncher.user = user;
    }
}
