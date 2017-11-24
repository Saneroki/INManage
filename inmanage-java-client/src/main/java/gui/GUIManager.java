package main.java.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;

/**
 * This Class does all the work for changing scenes and content of them
 */
public class GUIManager {
    private FXMLLoader loader;

    /**
     * Searches for all the fxml files and creates a map with its name and path
     * @author Glenn
     */
    public GUIManager(){
        HashMap<String, String> layouts = createFXMLFileMap("fxml/layouts");
        HashMap<String, String> components = createFXMLFileMap("fxml/components");
        System.out.println(layouts.get("Login"));
    }



    public void setScene(String window){
        Stage stage = ClientLauncher.getPrimaryStage();
        Parent position;
        setFxmlLoader(window);
        try {
            position = loader.load();
        } catch (IOException e) {
            throw new Error("The file for " + window + " could not be found!");
        }
        stage.setTitle("INManage");
        stage.setScene(new Scene(position));
        stage.show();
    }

    /**
     * Sets the fxml loader depending on the requested path
     * Used by setScene
     * @param fxmlPath
     */
    private void setFxmlLoader(String fxmlPath){
        loader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlPath));
    }

    /**
     * Creates a hashmap for all the files in the param directory with its name as key and path as value.
     * Used by the constructor
     * @author Glenn
     * @param path the path to the desired resource folder
     * @return a Hashmap with all the files in the param directory
     */
    private HashMap createFXMLFileMap(String path) {
        HashMap<String, String> hashmap = new HashMap<>();
        ClassLoader classLoader = getClass().getClassLoader();
        File folder = new File(classLoader.getResource(path).getFile());
        File[] listOfFiles = folder.listFiles((dir, name) -> name.endsWith(".fxml"));

        for (File listOfFile : listOfFiles) {
            String filename = listOfFile.getName();
            filename = filename.substring(0, filename.length() - 5);
            hashmap.put(filename, listOfFile.getPath());
        }
        return hashmap;
    }

    /**
     * Get files or directories from the resource folder.
     * This was developed because a normal string as path gave a lot of errors.
     * @author Glenn
     * @param resFolder path to a desired resource folder.
     * @return the path, which java can read
     */
    private File getFileFromURL(String resFolder) {
        URL url = this.getClass().getClassLoader().getResource(resFolder);
        File file = null;
        try{
            file = new File(url.toURI());
        } catch (URISyntaxException e) {
            url.getPath();
            file = new File(url.getPath());
        } finally {
            return file;
        }
    }
}
