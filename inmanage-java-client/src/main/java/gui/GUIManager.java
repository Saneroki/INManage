package main.java.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * This Class does all the work for changing scenes and content of them
 */
public class GUIManager {
    private HashMap<String, String> layouts;
    private HashMap<String, String> components;

    /**
     * Loads all the correct fxml file paths and makes them available via the filename
     *
     * @author Glenn
     */
    public GUIManager() {
        layouts = getFxmlRes("fxml/layouts");
        components = getFxmlRes("fxml/components");
    }

    public void setLayout(String fxml) {
        Stage stage = ClientLauncher.getPrimaryStage();
        System.out.println(layouts.get(fxml));
        Parent position = getFXMLParent(layouts.get(fxml));
        stage.setTitle("INManage");
        stage.setScene(new Scene(position));
        stage.show();
    }

    /**
     * Creates the Parent for a fxml file
     * Used by setLayout
     *
     * @param fxml The fxml file name. It can either be a layout or a domain.
     */
    private Parent getFXMLParent(String fxml) {
        try {
            URL fxmlUrl = Paths.get(fxml).toUri().toURL();
            Parent root = new FXMLLoader().load(fxmlUrl);
            return root;
        } catch (IOException e) {
            throw new Error("The file " + fxml + " was not found");
        }
    }

    /**
     * Creates a hashmap for all the files in the param directory with its name as key and path as value.
     * Used by the constructor
     *
     * @param path the path to the desired resource folder
     * @return a Hashmap with all the files in the param directory
     * @author Glenn
     */
    private HashMap<String, String> getFxmlRes(String path) {
        HashMap<String, String> hashmap = new HashMap<>();
        File folder = null;
        try {
            folder = new File(getClass().getClassLoader().getResource(path).toURI());
        } catch (URISyntaxException e) {
            throw new Error("Unable to convert the Folder path into a URI");
        }
        for (final File file : folder.listFiles()) {
            if (file.getName().endsWith(".fxml")) {
                /** Removes the FXML extension from the filename */
                String fileName = file.getName().substring(0, file.getName().length() - 5);
                hashmap.put(fileName, file.getPath());
            }
        }
        return hashmap;
    }
}