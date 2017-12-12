package main.java.clientCom;


import gen.java.model.Project;
import gen.java.model.*;
import main.java.databaseCom.ISQLCommands;
import main.java.databaseCom.SQLCommands;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class INManageServer {

    private static ISQLCommands sql;

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



    public String addUserResponse(User user){

        System.out.println("Adding new user: " + user.getName());

        try {
            if(sql == null){
                System.out.println("SQL ER NULL!!!!!");
            }
            sql.addUser(user.getName(),user.getPassword(),"bob","Loblaw","user");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Succes!";

    }
    public String addProjectResponse(Project project){
        System.out.println("Adding new project: " + project.getName());
        try {
            sql.addProject(project.getUserid(),project.getName(),project.getDescription());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Succes!";

    }

    public String loginResponse(String username, String password){
        System.out.println("Logging in user: " + username);
        String uuid = null;
        try {
            uuid = sql.loginUser(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (uuid.equals(null)){
            return uuid;
        }else {
            //Turn this into JSON
            //Or maybe not
            return uuid;
        }
    }

    public List<Project> getProjectsResponse(String projectID){

        List<Project> list = new ArrayList<>();

        try {
            list = sql.getProject(projectID);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public String addTaskResponse(AddTaskObject addTask) {

        System.out.println("Adding new task: " + addTask.getTaskName());

        try {
            sql.addTaskToProject(addTask.getTaskName(),addTask.getDescription(),addTask.getDueDate(),addTask.getProjectId());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "Succes!";

    }

    /*



     */

    public List<Task> getTaskResponse(String projectId){
        List<Task> list = new ArrayList<>();

        System.out.println("Getting tasks for the project: " + projectId);

        try {
           list = sql.getAllTaskByProject(projectId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //add tasks to list

        return list;

    }

    public String addUserToProjectResponse(String projectId, String userID){

        try {
            //It says userid, but it is username
            sql.addUserToProject(userID,projectId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Succes!";
    }

    public String deleteUserResponse (String userId, String password){
        try {
            sql.deleteUser(userId,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Succes!";
    }

    public String editUserResponse (User user){
        try {
            sql.editFirstname(user.getName(),user.getFirstName());
            sql.editLastname(user.getName(),user.getLastName());
            sql.editPassword(user.getName(),user.getPassword());
            //TODO: How is this supposed to work????
            //sql.editUsername(user.getName());
            return "Succes!";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Unsuccesful...";
    }

    public User getUserResponse(String userID){
        try {
            sql.getUser(userID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> searchUsersResponse(String name, Integer limit){
        try {
            sql.searchUser(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String editTaskResponse(Task task){
        try {
            sql.editTaskDescription(task.getId(),task.getDescription());
            sql.editTaskName(task.getId(),task.getName());
            sql.editTaskDue(task.getId(),task.getDuedate());
            return "Succes!";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "No succes";
    }

    public String deleteProjectResponse(String projectId, String password){
        try {
            sql.deleteProject(projectId);
            return "Succes!";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "No succes";
    }

    public String editProjectResponse(Project project){

        try {
            sql.editProjectDescription(project.getId(),project.getDescription());
            sql.editProjectName(project.getId(),project.getName());
            return "Succes!";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "no succes";
    }

    public Project getSpecificProjectResponse(String projectID){
        try {
            return sql.getSpecificProject(projectID);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Integer getUserAmountResponse(String projectID){
        try {
            return sql.getUserAmount(projectID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer getTaskAmountResponse(String projectID){
        try {
            return sql.getTaskAmount(projectID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public String deleteTaskResponse(String taskId){
        try {
            sql.deleteTask(taskId);
            return "Succes!";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "No succes";
    }


}
