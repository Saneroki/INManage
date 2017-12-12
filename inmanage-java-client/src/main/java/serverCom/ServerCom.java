package main.java.serverCom;

import gen.java.model.AddTaskObject;
import gen.java.model.Project;
import gen.java.model.Task;
import gen.java.model.User;

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

    void deleteUsers(String userID, String password);

    void editUser(User user);

    List<User> searchUser(String name, Integer limit);

    User getSpecificUser(String userID);

    void deleteProject(String projectID, String password);

    void editProject(Project proj);

    Project getSpecificProject(String projID);

    Integer getUserAmount(String projID);

    void deleteTask(String taskID);

    void editTask(Task task);

    Integer getTaskAmount(String taskID);







}