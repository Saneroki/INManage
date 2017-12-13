package main.java.clientCom;

import gen.java.api.NotFoundException;
import gen.java.api.TaskApiService;
import gen.java.model.AddTaskObject;
import gen.java.model.Task;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.UUID;

/**
 * Created by Malte on 01-12-2017.
 */
public class TaskApiImpl extends TaskApiService{
    @Override
    public Response addTask(AddTaskObject addTaskObject, SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(INManageServer.get().addTaskResponse(addTaskObject)).build();
    }

    @Override
    public Response deleteTask(@NotNull UUID taskId, SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(INManageServer.get().deleteTaskResponse(taskId.toString())).build();
    }



    @Override
    public Response editTask(Task taskObject, SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(INManageServer.get().editTaskResponse(taskObject)).build();
    }

    @Override
    public Response getTask(@NotNull UUID projectID, SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(INManageServer.get().getTaskResponse(projectID.toString())).build();
    }

    @Override
    public Response getTaskAmount(UUID taskId, SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(INManageServer.get().getTaskAmountResponse(taskId.toString())).build();
    }


}
