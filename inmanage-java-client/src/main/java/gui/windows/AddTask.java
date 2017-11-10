package main.java.gui.windows;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;


/**
 * Created by omnhaww on 10/11/2017.
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

    private String taskName;

    private String taskDesc;

    private LocalDate taskDueDate;

    @FXML
    void addTaskCancelButton(ActionEvent event) {
        System.exit(1);
    }

    @FXML
    void addTaskConfirmAction(ActionEvent event) {
        taskName = addTaskNameField.getText();
        taskDesc = addTaskDescField.getText();
        taskDueDate = dueDateField.getValue();

        // When implementing this with SQL we have to check whether LocalDate can be used, or whether we need
        // another solution. /omhaw16
    }

}
