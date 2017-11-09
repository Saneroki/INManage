
package main.java.gui.windows;

        import javafx.application.Platform;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.layout.Pane;

        import java.io.IOException;

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

    public Dashboard(){
        try {
            topPane = FXMLLoader.load(getClass().getResource("/fxml/components/TopBar.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new Error();
        }
    }

    @FXML
    public void initialize(){
        try {
            topPane = FXMLLoader.load(getClass().getResource("/fxml/components/TopBar.fxml"));
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
