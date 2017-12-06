package main.java.clientCom;

import gen.java.api.NotFoundException;
import gen.java.api.TaskApiService;
import gen.java.model.AddTaskObject;
import gen.java.model.Task;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

/**
 * Created by Malte on 01-12-2017.
 */
public class TaskApiImpl extends TaskApiService{
    @Override
    public Response addTask(AddTaskObject addTaskObject, SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(INManageServer.get().addTaskResponse(addTaskObject)).build();
    }

    @Override
    public Response deleteTask(String projectId, SecurityContext securityContext) throws NotFoundException {

        //TODO: Immplement when sql is done
        return Response.ok().entity(INManageServer.get()).build();
    }

    @Override
    public Response editTask(Task taskObject, SecurityContext securityContext) throws NotFoundException {
        //TODO: Immplement when sql is done
        return Response.ok().entity(INManageServer.get()).build();
    }

    @Override
    public Response getTask(String projectID, SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(INManageServer.get().getTaskResponse(projectID)).build();
    }

    @Override
    public Response getTaskAmount(String projectId, SecurityContext securityContext) throws NotFoundException {
        //TODO: Immplement when sql is done
        return Response.ok().entity(INManageServer.get()).build();
    }
}
