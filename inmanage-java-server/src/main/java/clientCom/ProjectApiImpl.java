package main.java.clientCom;

import gen.java.api.NotFoundException;
import gen.java.api.ProjectApiService;
import gen.java.model.Project;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ProjectApiImpl extends ProjectApiService {

    ExecutorService executor = Executors.newCachedThreadPool();

    @Override
    public Response addProject(Project project, SecurityContext securityContext) throws NotFoundException {

        Future<Response> resp = executor.submit(new RunResponse(Response.ok().entity(INManageServer.get().addProjectResponse(project)).build()));

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
    public Response addUserToProject(String projectID, String theIDOfTheUserMakingTheOperation, SecurityContext securityContext) throws NotFoundException {

        Future<Response> resp = executor.submit(new RunResponse(Response.ok().entity(INManageServer.get().addUserToProjectResponse(projectID,theIDOfTheUserMakingTheOperation)).build()));

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
    public Response deleteProject(String projectId, String passWord, SecurityContext securityContext) throws NotFoundException {

        Future<Response> resp = executor.submit(new RunResponse(Response.ok().entity(INManageServer.get().deleteProjectResponse(projectId,passWord)).build()));
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
    public Response editProject(Project projectObject, SecurityContext securityContext) throws NotFoundException {

        Future<Response> resp = executor.submit(new RunResponse(Response.ok().entity(INManageServer.get().editProjectResponse(projectObject)).build()));
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
    public Response getAllProjects(String userId, SecurityContext securityContext) throws NotFoundException {

        Future<Response> resp = executor.submit(new RunResponse(Response.ok().entity(INManageServer.get().getProjectsResponse(userId)).build()));

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
    public Response getSpecificProject(String projectID, SecurityContext securityContext) throws NotFoundException {

        Future<Response> resp = executor.submit(new RunResponse(Response.ok().entity(INManageServer.get().getSpecificProjectResponse(projectID)).build()));

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
    public Response getUserAmount(String projectId, SecurityContext securityContext) throws NotFoundException {

        Future<Response> resp = executor.submit(new RunResponse(Response.ok().entity(INManageServer.get().getUserAmountResponse(projectId)).build()));

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
