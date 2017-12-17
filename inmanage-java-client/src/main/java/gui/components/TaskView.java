package main.java.gui.components;

import gen.java.model.Task;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.java.gui.ClientLauncher;


/**
 * Created by Malte on 13-12-2017.
 *
 * Taskview created to make a "view" of a task.
 *
 */
public class TaskView {

    Task task;

    public TaskView(Task task, VBox mainBox) {
        this.task = task;
        generateView(mainBox);
    }

    private void generateView(VBox vBox){
        HBox hBox = new HBox(5);

        hBox.setMinWidth(250);
        hBox.setMaxWidth(250);

        vBox.setSpacing(5);

        Text taskTitle = new Text();
        hBox.setStyle("-fx-font-size: 18; -fx-border-color: #84AF9E; -fx-border-width: 3px;");
        taskTitle.setWrappingWidth(250);
        taskTitle.setText(task.getName());
        hBox.getChildren().add(taskTitle);

        taskTitle.setStyle("-fx-background-color: white");

        taskTitle.setOnMouseEntered((event -> {
            hBox.setStyle("-fx-font-size: 18; -fx-border-color: darkgray; -fx-border-width: 3px;");
        }));
        taskTitle.setOnMouseExited((event -> {
            hBox.setStyle("-fx-font-size: 18; -fx-border-color: #84AF9E; -fx-border-width: 3px;");
        }));

        try {
            Pane imageHolder = new Pane();
            imageHolder.setMinWidth(20);
            imageHolder.setMinHeight(20);
            ImageView icon = new ImageView(new Image("img/info.png"));
            imageHolder.setStyle("-fx-background-color: #648674");
            imageHolder.getChildren().add(icon);

            hBox.getChildren().add(imageHolder);
        }catch (IllegalArgumentException e){
            System.out.println("The image url is not valid...");
        }

        hBox.setOnMouseClicked(event -> {
            ClientLauncher.setTask(task);
            ClientLauncher.getWindowChanger().setLayout("TaskDetails");
        });

        //Important to have this synced because it otherwise causes errors.
        synchronized (vBox){
            vBox.getChildren().add(hBox);
        }

    }

}
