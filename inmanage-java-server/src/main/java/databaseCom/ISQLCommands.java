package main.java.databaseCom;

import gen.java.model.Project;
import gen.java.model.Task;
import gen.java.model.User;

import java.text.ParseException;
import java.util.List;
import java.sql.SQLException;
import java.util.UUID;

interface ISQLCommands {

    boolean addUser(String username, String password, String firstname, String lastname, String type) throws SQLException;

    boolean deleteUser(String userid, String password) throws SQLException;

    List<User> searchUser(String searchString) throws SQLException;

    String getPassword(String username) throws SQLException;

    String getFirstname(String username) throws SQLException;

    String getLastname(String username) throws SQLException;

    boolean editUsername(String username, String newUsername) throws SQLException;

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

    boolean deleteProject(String projectid) throws SQLException;

    boolean addUserToProject(String username, String projectid) throws SQLException;

    String getProjectName(String userid) throws SQLException;


    boolean editProjectName(String projectid, String name) throws SQLException;

    String getProjectDescription(String userid) throws SQLException;

    boolean editProjectDescription(String projectid, String description) throws SQLException;

    List<Project> getProject(String userid) throws SQLException;

    Project getSpecificProject(String projectId) throws SQLException;

    //Task

    boolean addTaskToProject(String taskname, String taskdescription, String taskdue, String projectid) throws SQLException, ParseException;

    boolean editTaskName(String taskid,String taskname) throws SQLException;

    boolean editTaskDescription(String taskid,String taskdescription) throws SQLException;

    boolean editTaskDue(String taskid,String taskdue) throws SQLException;

    boolean editTaskToProject(String taskid,String projectid) throws SQLException;

    boolean editTaskStatus(String taskid, int statusid) throws SQLException;

    boolean deleteTask(String taskid) throws SQLException;

    boolean deleteAllTaskForProject(String projectid) throws SQLException;

    List<Task> getTaskByStatus(String projectid, int statusid) throws SQLException;

    List<Task> getAllTaskByProject(String projectid) throws SQLException;

    int getTaskAmount(String projectId) throws SQLException;

    String getTaskNameByStatus(String projectId, int statusId) throws SQLException;

}
