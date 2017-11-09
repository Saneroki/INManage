package main.java.databaseCom;

import java.awt.*;
import java.sql.SQLException;
import java.util.UUID;

public interface ISQLCommands {

    boolean registerUser(UUID id, String username, String password, String firstname, String lastname, String type) throws SQLException;

    boolean checkUserLogin(String username, String password) throws SQLException;

    String getPassword(String username) throws SQLException;

    String getFirstname(String username) throws SQLException;

    String getLastname(String username) throws SQLException;

    boolean setUsername(String username) throws SQLException;

    boolean setPassword(String username, String password) throws SQLException;

    boolean setFirstname(String username, String firstname) throws SQLException;

    boolean setLastname(String username, String lastname) throws SQLException;

    boolean setUserType(String username, String type) throws SQLException;

    boolean isUserExisting(String username) throws SQLException;

    boolean isUserAdmin(String username) throws SQLException;

    String loginUser(String username, String password) throws SQLException;

    //Task

    boolean addTaskToProject(UUID taskId, String taskName, String taskDescription, String taskDue, int projectId) throws SQLException;

    boolean setTaskStatus(int taskId, int taskStatus) throws SQLException;

    boolean deleteTask(int taskId) throws SQLException;

    boolean deleteAllTaskForProject(int projectId) throws SQLException;

    List getTaskByStatus(int projectId, String taskStatus) throws SQLException;

    List getAllTaskByProject(int projectId) throws SQLException;



}
