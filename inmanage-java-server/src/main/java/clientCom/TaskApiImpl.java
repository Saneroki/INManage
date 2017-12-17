package main.java.clientCom;

import gen.java.api.NotFoundException;
import gen.java.api.TaskApiService;
import gen.java.model.AddTaskObject;
import gen.java.model.Task;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Malte on 01-12-2017.
 */
public class TaskApiImpl extends TaskApiService{

    ExecutorService executor = Executors.newCachedThreadPool();

    @Override
    public Response addTask(AddTaskObject addTaskObject, SecurityContext securityContext) throws NotFoundException {

        Future<Response> resp = executor.submit(new RunResponse(Response.ok().entity(INManageServer.get().addTaskResponse(addTaskObject)).build()));

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
    public Response deleteTask(@NotNull UUID taskId, SecurityContext securityContext) throws NotFoundException {

        Future<Response> resp = executor.submit(new RunResponse(Response.ok().entity(INManageServer.get().deleteTaskResponse(taskId.toString())).build()));

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
    public Response editTask(Task taskObject, SecurityContext securityContext) throws NotFoundException {

        Future<Response> resp = executor.submit(new RunResponse(Response.ok().entity(INManageServer.get().editTaskResponse(taskObject)).build()));
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
    public Response getTask(@NotNull UUID projectID, SecurityContext securityContext) throws NotFoundException {

        Future<Response> resp = executor.submit(new RunResponse(Response.ok().entity(INManageServer.get().getTaskResponse(projectID.toString())).build()));

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
    public Response getTaskAmount(UUID taskId, SecurityContext securityContext) throws NotFoundException {

        Future<Response> resp = executor.submit(new RunResponse(Response.ok().entity(INManageServer.get().getTaskAmountResponse(taskId.toString())).build()));

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
