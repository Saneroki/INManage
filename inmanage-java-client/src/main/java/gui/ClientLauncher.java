package main.java.gui;

/*
  Created by Glenn on 25/10/2017.
*/
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ClientLauncher extends Application {
    private static WindowChanger windowChanger;
    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        primaryStage.initStyle(StageStyle.UNDECORATED);
        test();
        //windowChanger = new WindowChanger();
        //windowChanger.setScene("Login");
        primaryStage.isMaximized();
    }

    public static WindowChanger getWindowChanger() {
        return windowChanger;
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public void test() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
