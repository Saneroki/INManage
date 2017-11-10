package main.java.gui;

/*
  Created by Glenn on 25/10/2017.
*/
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
}
