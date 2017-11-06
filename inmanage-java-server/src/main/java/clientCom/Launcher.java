


package main.java.clientCom;


import gen.java.api.ApiResponseMessage;
import gen.java.api.NotFoundException;
import gen.java.api.UsersApiService;
import gen.java.model.User;
import main.java.databaseCom.SQLConnect;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.sql.SQLException;

public class Launcher  extends UsersApiService {
    User user1;

    @Override
    public Response addUser(User user, SecurityContext securityContext) throws NotFoundException {
        user1 = user;
        System.out.println(user);
        System.out.println(user1);
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response loginUser(String username, String password, SecurityContext securityContext) throws NotFoundException {
        return null;
    }

    @Override
    public Response searchUser(String searchUsername, Integer skip, Integer limit, SecurityContext securityContext) throws NotFoundException {
        // here should be a check if the searchUsername matches the one of user1 and only return .ok if it does.
        // If it does not then respond Response.noContent().entity(new ApiResponseMessage(ApiResponseMessage.noContent, "Nothing found")).build();
        System.out.println(user1.getTaskName());
        return Response.ok().entity(user1).build();

    }

    public static void main(String[] args) throws SQLException {
        //Starts the program
        //Command Line only
        SQLConnect sql = new SQLConnect();
        sql.connect();
    }

}
