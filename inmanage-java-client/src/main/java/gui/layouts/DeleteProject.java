package main.java.gui.layouts;

/**
 * Created by Malte on 17-12-2017.
 *
 * Controller for the DeleteProject fxml file
 *
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import main.java.gui.ClientLauncher;
import main.java.serverCom.ServerCom;

public class DeleteProject {

    @FXML
    private Button editProjConfirmBtn;

    @FXML
    private Button editProjCancelBtn;

    @FXML
    private PasswordField passworField;

    ServerCom serv =  ClientLauncher.getServer();

    @FXML
    void editProjectConfirmAction(ActionEvent event) {
        if(passworField.getText().equals(ClientLauncher.getUser().getPassword())){
            serv.deleteProject(ClientLauncher.getProj().getId(),passworField.getText());
            ClientLauncher.getWindowChanger().setLayout("ProjectDashboard");
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error deleting project");
            alert.setHeaderText("There was an error deleting the project");
            alert.setContentText("Are you sure your password is correct?");
            alert.showAndWait();
        }


    }

    @FXML
    void editProjectCancelButton(ActionEvent event) {
        ClientLauncher.getWindowChanger().setLayout("ProjectOverview");
    }

}