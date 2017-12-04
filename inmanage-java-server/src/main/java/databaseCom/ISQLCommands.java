package main.java.databaseCom;

import gen.java.model.Project;
import gen.java.model.User;

import java.util.List;
import java.sql.SQLException;
import java.util.UUID;

interface ISQLCommands {

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

    User getUser (String userId) throws SQLException;

    int getUserAmount(String projectId) throws SQLException;

    //Project

    public boolean addProject(String userid, String projectname,String projectdescription) throws SQLException;

    boolean addUserToProject(String username,String projectid) throws SQLException;

    String getProjectName(String userid) throws SQLException;

    boolean editProjectName(String projectid, String name) throws SQLException;

    String getProjectDescription(String userid) throws SQLException;

    boolean editProjectDescription(String projectid, String description) throws SQLException;

    List<Project> getProjectByUser(String userid) throws SQLException;

    Project getSpecificProject(String projectId) throws SQLException;

    //Task

    boolean addTaskToProject(String taskname, String taskdescription, String taskdue, String projectid) throws SQLException;

    boolean editTaskStatus(String taskid, int statusid) throws SQLException;

    boolean deleteTask(String taskid) throws SQLException;

    boolean deleteAllTaskForProject(String projectid) throws SQLException;

    List getTaskByStatus(String projectid, int statusid) throws SQLException;

    List getAllTaskByProject(String projectid) throws SQLException;

    int getTaskAmount(String projectId) throws SQLException;

    String getTaskNameByStatus(String projectId, int statusId) throws SQLException;

}
