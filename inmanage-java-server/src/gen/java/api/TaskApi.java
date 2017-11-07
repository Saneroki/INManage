package gen.java.api;

import gen.java.model.*;
import gen.java.api.TaskApiService;
import gen.java.api.factories.TaskApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import gen.java.model.AddTaskObject;
import gen.java.model.Task;

import java.util.List;
import gen.java.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/task")


@io.swagger.annotations.Api(description = "the task API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-07T10:56:57.897Z")
public class TaskApi  {
   private final TaskApiService delegate = TaskApiServiceFactory.getTaskApi();

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Adds a new task to a project", notes = "Adds a new task to a project, whil adding the id's of the task and the user.", response = void.class, tags={ "User", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Task created", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Task creation failed", response = void.class) })
    public Response addTask(@ApiParam(value = "Adds a task to a project" ) AddTaskObject addTaskObject
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addTask(addTaskObject,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Gets the tasks based on project id", notes = "Retrevies a task based on the project the task is in with the project ID", response = Task.class, responseContainer = "List", tags={ "User", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "The tasks was received!", response = Task.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "No task was received", response = Task.class, responseContainer = "List") })
    public Response getTask(@ApiParam(value = "The id of the project",required=true) @QueryParam("projectID") String projectID
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getTask(projectID,securityContext);
    }
}
