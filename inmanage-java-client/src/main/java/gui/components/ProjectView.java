package main.java.gui.components;

import gen.java.model.Project;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import main.java.gui.ClientLauncher;
import main.java.serverCom.ServerCom;

import java.awt.event.MouseEvent;

/**
 * Created by Malte on 07-12-2017.
 */
public class ProjectView {

    Project proj;
    Integer userAmount;
    Integer taskAmount;

    public ProjectView(Project proj, Integer userAmount, Integer taskAmount, VBox vb) {
        this.proj = proj;
        this.userAmount = userAmount;
        this.taskAmount = taskAmount;
        generateView(vb);
    }

    private void generateView(VBox vb){
        System.out.println("Generating view...");
        HBox hb = new HBox();
        hb.setSpacing(5);
        hb.setMinWidth(250);
        hb.setMaxWidth(250);
        hb.setOnMouseClicked((event -> {
            ClientLauncher.setProj(this.proj);
            ClientLauncher.getWindowChanger().setLayout("ProjectOverview");
        }));

        hb.setOnMouseEntered((event -> {
            hb.setStyle("-fx-background-color: darkgray");
        }));
        hb.setOnMouseExited((event -> {
            hb.setStyle("-fx-background-color: white");
        }));

        GridPane grid = new GridPane();
        grid.setHgap(5);

        Text title = new Text(proj.getName());
        title.setWrappingWidth(250);
        title.setStyle("-fx-font-size: 20");
        grid.add((title),0,0);

        Text desc = new Text(proj.getDescription());
        desc.setWrappingWidth(250);
        grid.setStyle("-fx-border-color: #84AF9E; -fx-border-width: 1px");
        grid.add((desc),0,1);


        GridPane grid2 = new GridPane();
        grid2.setHgap(5);
        grid2.setVgap(5);

        try {
            grid2.add(new ImageView(new Image("img/tasks.png")),0,0);
        }catch (IllegalArgumentException e){
            System.out.println("The image url is not valid...");
        }

        try {
            grid2.add(new ImageView(new Image("img/userAssigned.png")),0,1);
        }catch (IllegalArgumentException e){
            System.out.println("The image url is not valid...");
        }

        Text taskAmountText = new Text(taskAmount.toString());
        Text userAmountText = new Text(userAmount.toString());

        taskAmountText.setFill(Color.WHITE);
        userAmountText.setFill(Color.WHITE);

        grid2.add(new Text(taskAmount.toString()),1,0);
        grid2.add(new Text(userAmount.toString()),1,1);
        grid2.setStyle("-fx-background-color: #648674");

        hb.getChildren().add(grid);
        hb.getChildren().add(grid2);

        //Important to have thos synced because it otherwise causes errors.
        synchronized (vb){
            vb.getChildren().add(hb);
        }

        System.out.println("view generated!");
    }

}
