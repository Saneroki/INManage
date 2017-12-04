package main.java.gui.components;


import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import main.java.gui.ClientLauncher;

public class TopBar {

    public ListView projectList;

    //Goes back to Dashboard(projectView)
    public void GoHome(ActionEvent actionEvent) {
        ClientLauncher.getWindowChanger().setLayout("Dashboard");
    }

    //Opens up chat
    public void GoChat(ActionEvent actionEvent) {
        ClientLauncher.getWindowChanger().setLayout("Chat");
    }

    //Shows the users profile
    public void ShowProfile(ActionEvent actionEvent) {
        /*ClientLauncher.getWindowChanger().setScene("fxml/layouts/UserProfile.fxml"); NOT MADE YET*/
    }

    //Logs the user out, and then sends them back to login screen.
    public void SignOut(ActionEvent actionEvent) {
        //NOT DONE YET
        ClientLauncher.getWindowChanger().setLayout("Login");
    }

    public void turnOff(MouseEvent mouseEvent) {
    }

    public void arrowDown(MouseEvent mouseEvent) {
    }

    public void back(MouseEvent mouseEvent) {
    }
}
