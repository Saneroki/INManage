package main.java.gui.components;

/**
 * Sample Skeleton for 'ChatWindow.fxml' Controller Class
 */



        import javafx.fxml.FXML;
        import javafx.scene.control.TitledPane;
        import javafx.scene.layout.AnchorPane;
        import javafx.scene.layout.VBox;

public class ChatWindow {

    @FXML // fx:id="channelPaneVBox"
    private VBox channelPaneVBox; // Value injected by FXMLLoader

    @FXML // fx:id="chatPane"
    private AnchorPane chatPane; // Value injected by FXMLLoader

    @FXML // fx:id="channelPane"
    private TitledPane channelPane; // Value injected by FXMLLoader

}


