package main.java.gui.layouts;

import gen.java.model.AddTaskObject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.java.gui.ClientLauncher;
import main.java.serverCom.ServerCom;

import java.time.LocalDate;


/**
 * Created by omnhaww on 10/11/2017.
 *
 * Controller for the AddTask fxml file
 *
 */

public class AddTask {

    @FXML
    private TextField addTaskNameField;

    @FXML
    private TextArea addTaskDescField;

    @FXML
    private Button addTaskConfirmBtn;

    @FXML
    private Button addTaskCancelBtn;

    @FXML
    private DatePicker dueDateField;

    private final ServerCom serv = ClientLauncher.getServer();

    @FXML
    void addTaskCancelButton(ActionEvent event) {

        ClientLauncher.getWindowChanger().setLayout("ProjectOverview");

    }

    @FXML
    void addTaskConfirmAction(ActionEvent event) {
        String taskName = addTaskNameField.getText();
        String taskDesc = addTaskDescField.getText();
        LocalDate taskDueDate = dueDateField.getValue();

        AddTaskObject task = new AddTaskObject();
        task.setTaskName(taskName);
        task.setDescription(taskDesc);
        task.setDueDate(taskDueDate.toString());
        task.setProjectId(ClientLauncher.getProj().getId());
        task.setUserId(ClientLauncher.getUser().getId().toString());

        serv.addTask(task);

        ClientLauncher.getWindowChanger().setLayout("ProjectOverview");

        // When implementing this with SQL we have to check whether LocalDate can be used, or whether we need
        // another solution. /omhaw16
    }

}
