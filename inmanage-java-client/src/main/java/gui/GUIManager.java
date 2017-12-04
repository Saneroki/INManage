package main.java.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This Class does all the work for changing scenes and content of them
 */
public class GUIManager {
    private FXMLLoader loader;
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

    public void setLayout(String layout) {
        Stage stage = ClientLauncher.getPrimaryStage();
        Parent position;
        setFxmlLoader(layout);
        try {
            position = loader.load();
        } catch (IOException e) {
            throw new Error("The file for " + layout + " could not be found!");
        }
        stage.setTitle("INManage");
        stage.setScene(new Scene(position));
        stage.show();
    }

    /**
     * Sets the fxml loader depending on the requested path
     * Used by setScene
     *
     * @param fxmlPath
     */
    private void setFxmlLoader(String fxmlPath) {
        loader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlPath));
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