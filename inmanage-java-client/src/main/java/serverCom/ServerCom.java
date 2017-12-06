package main.java.serverCom;

import gen.java.model.AddTaskObject;
import gen.java.model.Project;
import gen.java.model.Task;

import java.util.List;

/**
 * Interface to communicate to the Server
 */
public interface ServerCom {

    void addUser(String username, String password);

    String loginUser(String userName, String password);

    void addProject(Project project);

    void addTask(AddTaskObject task);

    List<Project> getAllProjects(String userID);

    List<Task> getAllTasks(String projectID);

    void addUserToProject(String userID, String projecID);






}