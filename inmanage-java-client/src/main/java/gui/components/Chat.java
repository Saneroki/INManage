package main.java.gui.components;

/**
 * Sample Skeleton for 'Chat.fxml' Controller Class
 */


import Logic.ChatMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;
import main.java.serverCom.ServerCom;
import main.java.serverCom.ServerComImpl;
//import main.java.Logic.Components.ChatLogic;//file moved

public class Chat {

    @FXML // fx:id="ButtonMembers"
    private Button ButtonMembers; // Value injected by FXMLLoader

    @FXML // fx:id="TitlePane"
    private TitledPane TitlePane; // Value injected by FXMLLoader

    @FXML // fx:id="textAreaChat"
    private TextArea textAreaChat; // Value injected by FXMLLoader

    @FXML // fx:id="ButtonSend"
    private Button ButtonSend; // Value injected by FXMLLoader

    @FXML // fx:id="ButtonClose"
    private Button ButtonClose; // Value injected by FXMLLoader

    @FXML // fx:id="textAreaWriteMessage"
    private TextArea textAreaWriteMessage; // Value injected by FXMLLoader

    //ChatLogic chatLogic = new ChatLogic();
    //call Chatlogic via server connection


    ServerComImpl serverCom = new ServerComImpl();
    @FXML
    void OnButtonClicked(ActionEvent event) {
        ChatMessage message = null;
        if (event.getSource() == ButtonSend) {
            if (!(textAreaWriteMessage.getText() == null || textAreaWriteMessage.getText() == ""))
                message = new ChatMessage(textAreaWriteMessage.getText(), null , null);
                serverCom.sendChatMessage(message);
            textAreaWriteMessage.clear();

        }
        if (event.getSource() == ButtonMembers) {
            //implementation
        }
        if (event.getSource()== ButtonClose){
            //terminate users connection from currently open channel.
            Stage stage = (Stage) ButtonClose.getScene().getWindow();
            stage.close();

        }
    }

}
