package main.java.databaseCom;

import gen.java.model.Project;

import java.util.List;
import java.sql.SQLException;
import java.util.UUID;

public interface ISQLCommands {

    boolean addUser(String username, String password, String firstname, String lastname, String type) throws SQLException;

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

    //Project

    boolean addProject(UUID userid,String name,String description) throws SQLException;

    boolean deleteProject(UUID projectid) throws SQLException;

    boolean addUserToProject(String username,UUID projectid) throws SQLException;

    boolean deleteUserFromProject(UUID userid, UUID projectid) throws SQLException;

    String getProjectName(UUID userid) throws SQLException;

    boolean setProjectName(UUID projectid, String name) throws SQLException;

    String getProjectDescription(UUID userid) throws SQLException;

    boolean setProjectDescription(UUID projectid, String name) throws SQLException;

    List<Project> getProject(UUID userid) throws SQLException;

    //Task

    boolean addTaskToProject(String taskname, String taskdescription, String taskdue, String projectid) throws SQLException;

    boolean setTaskStatus(String taskid, int statusid) throws SQLException;

    boolean deleteTask(String taskid) throws SQLException;

    boolean deleteAllTaskForProject(String projectid) throws SQLException;

    List getTaskByStatus(String projectid, int statusid) throws SQLException;

    List getAllTaskByProject(String projectid) throws SQLException;

}
