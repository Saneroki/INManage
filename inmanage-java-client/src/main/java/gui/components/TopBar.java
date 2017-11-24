package main.java.gui.components;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import main.java.gui.ClientLauncher;

public class TopBar {

    //Goes back to Dashboard(projectView)
    public void GoHome(ActionEvent actionEvent) {
        ClientLauncher.getWindowChanger().setScene("fxml/windows/Dashboard.fxml");
    }

    //Opens up chat
    public void GoChat(ActionEvent actionEvent) {
        ClientLauncher.getWindowChanger().setScene("fxml/components/Chat.fxml");
    }

    //Shows the users profile
    public void ShowProfile(ActionEvent actionEvent) {
        /*ClientLauncher.getWindowChanger().setScene("fxml/windows/UserProfile.fxml"); NOT MADE YET*/
    }

    //Logs the user out, and then sends them back to login screen.
    public void SignOut(ActionEvent actionEvent) {
        //NOT DONE YET
        ClientLauncher.getWindowChanger().setScene("fxml/windows/Login.fxml");
    }
}
