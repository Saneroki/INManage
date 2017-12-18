package main.java.clientCom;

import gen.java.api.ApiResponseMessage;
import gen.java.api.NotFoundException;
import gen.java.api.UsersApiService;
import gen.java.model.User;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UserApiImpl extends UsersApiService {

    ExecutorService executor = Executors.newCachedThreadPool();

    @Override
    public Response addUser(User user, SecurityContext securityContext) throws NotFoundException {

        Future<Response> resp= executor.submit(new RunResponse(Response.ok().entity(INManageServer.get().addUserResponse(user)).build()));

        try {
            return resp.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return Response.serverError().build();
    }

    @Override
    public Response deleteUser(String userID, String password, SecurityContext securityContext) throws NotFoundException {

        Future<Response> resp = executor.submit(new RunResponse(Response.ok().entity(INManageServer.get().deleteUserResponse(userID,password)).build()));

        try {
            return resp.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return Response.serverError().build();
    }

    @Override
    public Response editUser(User userObject, SecurityContext securityContext) throws NotFoundException {

        Future<Response> resp = executor.submit(new RunResponse(Response.ok().entity(INManageServer.get().editUserResponse(userObject)).build()));

        try {
            return resp.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return Response.serverError().build();
    }

    @Override
    public Response getUser(String userId, SecurityContext securityContext) throws NotFoundException {

        Future<Response> resp = executor.submit(new RunResponse(Response.ok().entity(INManageServer.get().getUserResponse(userId)).build()));

        try {
            return resp.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return Response.serverError().build();
    }

    @Override
    public Response loginUser(String username, String password, SecurityContext securityContext) throws NotFoundException {

        Future<Response> resp = executor.submit(new RunResponse(Response.ok().entity(INManageServer.get().loginResponse(username,password)).build()));

        try {
            return resp.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return Response.serverError().build();
    }

    @Override
    public Response searchUser(String searchUsername, Integer limit, SecurityContext securityContext) throws NotFoundException {

        Future<Response> resp = executor.submit(new RunResponse(Response.ok().entity(INManageServer.get().searchUsersResponse(searchUsername,limit)).build()));

        try {
            return resp.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return Response.serverError().build();
    }
}
