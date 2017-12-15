package main.java.gui.layouts;

import gen.java.model.AddTaskObject;
import gen.java.model.Task;
import javafx.event.ActionEvent;

/**
 * Created by omnhaww on 14/12/2017.
 */
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.java.gui.ClientLauncher;
import main.java.serverCom.ServerCom;

public class EditTask {

    @FXML
    private Button editTaskCancelBtn;

    @FXML
    private TextField editTaskNameField;

    @FXML
    private DatePicker dueDateField;

    @FXML
    private Button editTaskConfirmBtn;

    @FXML
    private TextArea editTaskDescField;

    ServerCom serv = ClientLauncher.getServer();

    @FXML
    public void initialize(){
        Task task = ClientLauncher.getTask();
        editTaskNameField.setText(task.getName());
        editTaskDescField.setText(task.getDescription());

    }

    @FXML
    void editTaskConfirmAction(ActionEvent event) {

        Task task = ClientLauncher.getTask();
        task.setName(editTaskNameField.getText());
        task.setDescription(editTaskDescField.getText());
        if(dueDateField.getValue()!=null){
            task.setDuedate(dueDateField.getValue().toString());
        }
        System.out.println(task.getDescription());
        serv.editTask(task);
        ClientLauncher.getWindowChanger().setLayout("TaskDetails");

    }

    @FXML
    void editTaskCancelButton(ActionEvent event) {
        ClientLauncher.getWindowChanger().setLayout("TaskDetails");
    }
}
