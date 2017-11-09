package main.java.gui;

/*
  Created by Glenn on 25/10/2017.
*/
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.java.gui.windows.WindowChanger;

public class ClientLauncher extends Application {
    private static WindowChanger windowChanger;
    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        primaryStage.initStyle(StageStyle.UNDECORATED);
        windowChanger = new WindowChanger();
        windowChanger.setScene("/fxml/windows/Login.fxml");
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

}
