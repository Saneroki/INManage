package main.java.clientCom;


import gen.java.api.Bootstrap;
import gen.java.model.Project;
import io.swagger.models.Response;
import main.java.databaseCom.SQLCommands;
import gen.java.model.*;

import java.sql.SQLException;
import java.util.UUID;

public class INManageServer {

    private static SQLCommands sql;

    public static INManageServer get(){
        if(sql == null){
            try {
                sql = SQLCommands.getInstance();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return singleton;
    }

    public static final INManageServer singleton = new INManageServer();

    public String addProjectResponse(Project project){
        System.out.println(project.getId() + project.getDescription() + project.getName());

        String resp = "Succes!";

        return resp;
    }

    public void addUserResponse(User user){

        try {
            sql = new SQLCommands();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Adding new user: " + user.getName());

        try {
            if(sql == null){
                System.out.println("SQL ER NULL!!!!!");
            }
            sql.registerUser(UUID.randomUUID(),user.getName(),user.getPassword(),"bob","Loblaw","user");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
