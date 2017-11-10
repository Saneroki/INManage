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
    public void addProjectResponse(Project project){
        System.out.println("Adding new project: " + project.getName());
        //sql.addProject .....
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
            list = sql.getProject(UUID.fromString(projectID));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void addTaskResponse(AddTaskObject addTask){

        System.out.println("Adding new task: " + addTask.getTaskName());

        try {
            sql.addTaskToProject(UUID.randomUUID(),addTask.getTaskName(),addTask.getDescription(),addTask.getDueDate(),addTask.getProjectId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Task> getTaskResponse(String projectId){
        List<Task> list = new ArrayList<>();



        //add tasks to list

        return list;

    }

}
