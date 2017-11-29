package main.java.databaseCom;

import gen.java.model.Project;

import java.util.List;
import java.sql.SQLException;
import java.util.UUID;

public interface ISQLCommands {

    boolean addUser(String username, String password, String firstname, String lastname, String type) throws SQLException;

    String getPassword(String username) throws SQLException;

    String getFirstname(String username) throws SQLException;

    String getLastname(String username) throws SQLException;

    boolean editUsername(String username) throws SQLException;

    boolean editPassword(String username, String password) throws SQLException;

    boolean editFirstname(String username, String firstname) throws SQLException;

    boolean editLastname(String username, String lastname) throws SQLException;

    boolean editUserType(String username, String type) throws SQLException;

    boolean isUserExisting(String username) throws SQLException;

    boolean isUserAdmin(String username) throws SQLException;

    String loginUser(String username, String password) throws SQLException;

    //Project

    public boolean addProject(String userid, String projectname,String projectdescription) throws SQLException;

    boolean addUserToProject(String username,UUID projectid) throws SQLException;

    String getProjectName(UUID userid) throws SQLException;

    boolean editProjectName(UUID projectid, String name) throws SQLException;

    String getProjectDescription(UUID userid) throws SQLException;

    boolean editProjectDescription(UUID projectid, String name) throws SQLException;

    List<Project> getProject(UUID userid) throws SQLException;

    //Task

    boolean addTaskToProject(String taskname, String taskdescription, String taskdue, String projectid) throws SQLException;

    boolean editTaskStatus(String taskid, int statusid) throws SQLException;

    boolean deleteTask(String taskid) throws SQLException;

    boolean deleteAllTaskForProject(String projectid) throws SQLException;

    List getTaskByStatus(String projectid, int statusid) throws SQLException;

    List getAllTaskByProject(String projectid) throws SQLException;

}
