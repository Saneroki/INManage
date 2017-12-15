package main.java.clientCom;

import gen.java.api.ApiResponseMessage;
import gen.java.api.NotFoundException;
import gen.java.api.UsersApiService;
import gen.java.model.User;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

public class UserApiImpl extends UsersApiService {
    @Override
    public Response addUser(User user, SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(INManageServer.get().addUserResponse(user)).build();
    }

    @Override
    public Response deleteUser(String userID, String password, SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(INManageServer.get().deleteUserResponse(userID,password)).build();
    }

    @Override
    public Response editUser(User userObject, SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(INManageServer.get().editUserResponse(userObject)).build();
    }

    @Override
    public Response getUser(String userId, SecurityContext securityContext) throws NotFoundException {
        System.out.println("Returning user from API");
        return Response.ok().entity(INManageServer.get().getUserResponse(userId)).build();
    }

    @Override
    public Response loginUser(String username, String password, SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(INManageServer.get().loginResponse(username,password)).build();
    }

    @Override
    public Response searchUser(String searchUsername, Integer limit, SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(INManageServer.get().searchUsersResponse(searchUsername,limit)).build();
    }
}
