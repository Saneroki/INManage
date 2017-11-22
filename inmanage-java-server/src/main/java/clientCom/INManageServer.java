package main.java.clientCom;


import com.fasterxml.jackson.annotation.JsonCreator;
import gen.java.api.Bootstrap;
import gen.java.model.Project;
import io.swagger.models.Response;
import io.swagger.util.Json;
import main.java.databaseCom.SQLCommands;
import gen.java.model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class INManageServer {

    private static SQLCommands sql;

    public static INManageServer get(){

        if (sql== null) {
            try {
                sql = SQLCommands.getInstance();
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
            sql.registerUser(UUID.randomUUID(),user.getName(),user.getPassword(),"bob","Loblaw","user");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Succes";

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

    public List<Project> getProjectsResponse(String userID){

        List<Project> list = new ArrayList<>();

        //sql.getAllProjects

        //add projects to list

        return list;
    }

    public void addTaskResponse(AddTaskObject addTask){

        System.out.println("Adding new task: " + addTask.getTaskName());

        //Sql.addTask();

    }

    public List<Task> addTaskResponse(String projectId){
        List<Task> list = new ArrayList<>();

        //sql.getTasks()

        //add tasks to list

        return list;

    }

}
