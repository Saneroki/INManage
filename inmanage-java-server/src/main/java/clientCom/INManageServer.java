package main.java.clientCom;


import gen.java.api.Bootstrap;
import gen.java.model.Project;
import io.swagger.models.Response;
import main.java.databaseCom.SQLCommands;
import gen.java.model.*;

import java.sql.SQLException;
import java.util.UUID;

public class INManageServer {

    private static SQLCommands sql = Bootstrap.getSql();

    public static INManageServer get(){
        return singleton;
    }

    public static final INManageServer singleton = new INManageServer();



    public void addUserResponse(User user){

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
    public void addProjectResponse(Project project){
        System.out.println("Adding new project: " + project.getName());

        //sql.addProject .....

    }

}
