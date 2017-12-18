package main.java.gui.layouts;

import gen.java.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import main.java.gui.ClientLauncher;
import main.java.serverCom.ServerCom;

import java.util.List;
import java.util.Objects;

/**
 * Controller of the AddUserToProjectController fxml file
 */

public class AddUserToProjectController extends Controller {

    @FXML
    private TextArea TextAreaAddedPersons;

    @FXML
    private TextField TextFieldUsernameInput;

    @FXML
    private Button ButtonAdd;

    @FXML
    private Button ButtonClose;

    @FXML
    private TextField searchInput;

    @FXML
    private TextArea userSearchResults;

    @FXML
    private Button searchBtn;

    private Alert alert;

    private final ServerCom serv = ClientLauncher.getServer();

    @FXML
    public void initialize(){
        searchBtn.setOnAction(event -> {
            String results = "";
            List<User> list = serv.searchUser(searchInput.getText().toLowerCase(),100);
            for (User user:list) {
                results = results + user.getName() + "\n";
            }
            userSearchResults.setText(results);
        });
    }

    @FXML
    void onClickAdd(ActionEvent event) {
        if(event.getSource() == ButtonClose){
            ClientLauncher.getWindowChanger().setLayout("ProjectOverview");
        }
        if(event.getSource()== ButtonAdd){
            if(!(Objects.equals(TextFieldUsernameInput.getText(), ""))){
                serv.addUserToProject(TextFieldUsernameInput.getText().toLowerCase(),ClientLauncher.getProj().getId());

                alert = new Alert(Alert.AlertType.INFORMATION);

                alert.setTitle("User added!");
                alert.setHeaderText("User added!");
                alert.setContentText("The selected user " + TextFieldUsernameInput.getText() + " has been added to your project!");
                alert.showAndWait();

            }
        }
    }


    public void ButtonClose(ActionEvent actionEvent) {
        ClientLauncher.getWindowChanger().setLayout("ProjectOverview");
    }
}