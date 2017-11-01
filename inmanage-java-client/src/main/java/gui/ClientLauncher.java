package main.java.gui;

/*
  Created by Glenn on 25/10/2017.
*/
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ClientLauncher extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.initStyle(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();



    }

    private void customWindowTop(){
        ToolBar toolBar = new ToolBar();

        int height = 25;
        toolBar.setPrefHeight(height);
        toolBar.setMinHeight(height);
        toolBar.setMaxHeight(height);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
