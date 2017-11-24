
package main.java.gui.layouts;

        import gen.java.model.Project;
        import javafx.application.Platform;
        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.control.ListView;
        import javafx.scene.control.cell.ComboBoxListCell;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.layout.Pane;
        import main.java.gui.ClientLauncher;
        import main.java.serverCom.ServerCom;

        import java.io.IOException;
        import java.util.List;

public class Dashboard extends Controller {

    @FXML
    private Pane topPane;

    @FXML
    private Pane leftPane;

    @FXML
    private Pane centerPane;

    @FXML
    private Pane rightPane;

    @FXML
    private Pane bottomPane;

    @FXML
    private ListView<Project> projects;

    private List<Project> list = FXCollections.observableArrayList();

    private final ServerCom serv = ClientLauncher.getServer();

    public Dashboard(){
        try {
            topPane = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/components/TopBar.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new Error();
        }
    }

    @FXML
    public void initialize(){
        try {
            topPane = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/components/TopBar.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new Error();
        }
    }

    @FXML
    void TurnOff(MouseEvent event) {
        Platform.exit();
    }


}
