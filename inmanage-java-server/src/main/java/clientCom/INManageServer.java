package main.java.clientCom;


import gen.java.model.Project;
import gen.java.model.*;
import main.java.databaseCom.SQLCommands;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class INManageServer {

    private static SQLCommands sql;

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
            list = sql.getProjectByUser(projectID);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public String addTaskResponse(AddTaskObject addTask){

        System.out.println("Adding new task: " + addTask.getTaskName());

        try {
            sql.addTaskToProject(addTask.getTaskName(),addTask.getDescription(),addTask.getDueDate(),addTask.getProjectId());
        } catch (SQLException e) {
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

    public String addUserToProject(String projectId, String userID){

        try {
            //It says userid, but it is username
            sql.addUserToProject(userID,projectId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Succes!";
    }

    public String deleteUser (String userId, String password){
        //TODO: Sql delete user

        return null;
    }

    public String editUser (User user){
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

    public String getUser(String userID){
        //TODO: Add get user to sql

        return null;
    }

    public List<User> SearchUsers(String name, Integer limit){
        //TODO: add search user to API, should return list of users that have the string in their username
        return null;
    }

    public String editTask(Task task){
        //TODO: Implement edit task in sql
        return null;
    }

    public String deleteProject(String projectId, String password){
        //TODO: implement delete project in sql
        return null;
    }

    public String editProject(Project project){

        try {
            sql.editProjectDescription(project.getId(),project.getDescription());
            sql.editProjectName(project.getId(),project.getName());
            return "Succes!";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "no succes";
    }

    public Project getSpecificProject(String projectID){
        //TODO: Implement getSpecificProject in sql, get one project from one project ID
        return null;
    }

    public Integer getUserAmount(String projectID){
        //TODO: Implement get userAmount in sql
        return null;
    }

    public Integer getTaskAmount(String projectID){
        //TODO: Implement get taskAmount in SQL
        return null;
    }


}
