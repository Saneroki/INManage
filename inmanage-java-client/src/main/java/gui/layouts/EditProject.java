package main.java.gui.layouts;

import com.sun.corba.se.spi.activation.Server;
import gen.java.model.Project;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.java.gui.ClientLauncher;
import main.java.serverCom.ServerCom;

/**
 * Created by omnhaww on 14/12/2017.
 */
public class EditProject {


    @FXML
    private Button editProjConfirmBtn;

    @FXML
    private TextArea editProjDescField;

    @FXML
    private TextField editProjNameField;

    @FXML
    private Button editProjCancelBtn;

    ServerCom serv = ClientLauncher.getServer();

    @FXML
    public void initialize(){
        Project project = ClientLauncher.getProj();
        editProjNameField.setText(project.getName());
        editProjDescField.setText(project.getDescription());
    }

    public void editProjectConfirmAction(ActionEvent actionEvent) {
        Project proj = ClientLauncher.getProj();

        proj.setName(editProjNameField.getText());
        proj.setDescription(editProjDescField.getText());
        serv.editProject(proj);
        ClientLauncher.getWindowChanger().setLayout("ProjectOverview");

    }

    public void editProjectCancelButton(ActionEvent actionEvent) {
        ClientLauncher.getWindowChanger().setLayout("ProjectOverview");
    }
}
