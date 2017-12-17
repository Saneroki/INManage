package main.java.clientCom;

import gen.java.model.Project;
import gen.java.model.*;
import main.java.databaseCom.ISQLCommands;
import main.java.databaseCom.SQLCommands;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * The "main" class on the server side that handles the requests coming in
 * the apis uses this server for in their responses.
 * The server is connected to the database and calls methods from the SQLCommands
 * class that fetches information from the database.
 */

public class INManageServer {

    private static ISQLCommands sql;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static INManageServer get(){
        if(sql==null){
            try {
                sql=SQLCommands.getInstance();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return singleton;
    }

    public static final INManageServer singleton = new INManageServer();


    /**
     * An example of a response method, the response methods is used in the api implementations
     *
     * @param user
     * @return
     */

    public String addUserResponse(User user){
        System.out.println("Adding new user: " + user.getName());

        lock.writeLock().lock();
        try {
            sql.addUser(user.getName(),user.getPassword(),"bob","Loblaw","user");
            return "Succes!";
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
        return "No succes";
    }

    /**
     *
     * @param project
     * @return
     */
    public String addProjectResponse(Project project){
        System.out.println("Adding new project: " + project.getName());
        lock.writeLock().lock();
        try {
            sql.addProject(project.getUserid(),project.getName(),project.getDescription());
            return "Succes!";
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
        return "No succes";


    }

    /**
     *
     *
     * @param username
     * @param password
     * @return
     */
    public String loginResponse(String username, String password){
        System.out.println("Logging in user: " + username);
        String uuid = null;
        lock.readLock().lock();
        try {
            uuid = sql.loginUser(username,password);
            return uuid;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
        return null;
    }

    /**
     *
     * @param projectID
     * @return
     */
    public List<Project> getProjectsResponse(String projectID){

        List<Project> list = new ArrayList<>();
        lock.readLock().lock();
        try {
            list = sql.getProject(projectID);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
        return list;
    }

    /**
     *
     * @param addTask
     * @return
     */
    public String addTaskResponse(AddTaskObject addTask) {

        System.out.println("Adding new task: " + addTask.getTaskName());
        lock.writeLock().lock();
        try {
            sql.addTaskToProject(addTask.getTaskName(),addTask.getDescription(),addTask.getDueDate(),addTask.getProjectId());
            return "Succes!";
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
        return "No succes";
    }

    /**
     *
     * @param projectId
     * @return
     */
    public List<Task> getTaskResponse(String projectId){
        List<Task> list = new ArrayList<>();

        System.out.println("Getting tasks for the project: " + projectId);
        lock.readLock().lock();
        try {
           list = sql.getAllTaskByProject(projectId);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
        return list;
    }

    /**
     *
     * @param projectId
     * @param userID
     * @return
     */
    public String addUserToProjectResponse(String projectId, String userID){
        lock.writeLock().lock();
        try {
            //It says userid, but it is username
            sql.addUserToProject(userID,projectId);
            return "Succes!";
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
        return "No succes";
    }

    /**
     *
     * @param userId
     * @param password
     * @return
     */
    public String deleteUserResponse (String userId, String password){
        lock.writeLock().lock();
        try {
            sql.deleteUser(userId,password);
            return "Succes!";
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
        return "No succes";
    }

    /**
     *
     * @param user
     * @return
     */
    public String editUserResponse (User user){
        lock.writeLock().lock();
        try {
            sql.editFirstname(user.getName(),user.getFirstName());
            sql.editLastname(user.getName(),user.getLastName());
            sql.editPassword(user.getName(),user.getPassword());
            sql.editUsername(user.getId().toString(),user.getName());
            return "Succes!";
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
        return "Unsuccesful...";
    }

    /**
     *
     * @param userID
     * @return
     */
    public User getUserResponse(String userID){
        lock.readLock().lock();
        try {
            return sql.getSpecificUser(userID);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
        return null;
    }

    /**
     *
     * @param name
     * @param limit
     * @return
     */
    public List<User> searchUsersResponse(String name, Integer limit){
        lock.readLock().lock();
        try {
            return sql.searchUser(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
        return null;
    }

    /**
     *
     * @param task
     * @return
     */
    public String editTaskResponse(Task task){
        lock.writeLock().lock();
        try {
            sql.editTaskDescription(task.getId().toString(),task.getDescription());
            sql.editTaskName(task.getId().toString(),task.getName());
            sql.editTaskDue(task.getId().toString(),task.getDuedate());
            return "Succes!";
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
        return "No succes";
    }

    /**
     *
     * @param projectId
     * @param password
     * @return
     */
    public String deleteProjectResponse(String projectId, String password){
        lock.writeLock().lock();
        try {
            sql.deleteProject(projectId);
            return "Succes!";
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
        return "No succes";
    }

    /**
     *
     * @param project
     * @return
     */
    public String editProjectResponse(Project project){
        lock.writeLock().lock();
        try {
            sql.editProjectDescription(project.getId(),project.getDescription());
            sql.editProjectName(project.getId(),project.getName());
            return "Succes!";
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
        return "no succes";
    }

    /**
     *
     * @param projectID
     * @return
     */
    public Project getSpecificProjectResponse(String projectID){
        lock.readLock().lock();
        try {
            return sql.getSpecificProject(projectID);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
        return null;
    }

    /**
     *
     * @param projectID
     * @return
     */
    public Integer getUserAmountResponse(String projectID){
        lock.readLock().lock();
        try {
            return sql.getUserAmount(projectID);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
        return null;
    }

    /**
     *
     * @param projectID
     * @return
     */
    public Integer getTaskAmountResponse(String projectID){
        lock.readLock().lock();
        try {
            return sql.getTaskAmount(projectID);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
        return null;
    }

    /**
     *
     * @param taskId
     * @return
     */
    public String deleteTaskResponse(String taskId){
        lock.writeLock().lock();
        try {
            sql.deleteTask(taskId);
            return "Succes!";
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
        return "No succes";
    }
}
