package gen.java.api;

import gen.java.model.*;
import gen.java.api.TaskApiService;
import gen.java.api.factories.TaskApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import gen.java.model.AddTaskObject;
import gen.java.model.Task;
import java.util.UUID;

import java.util.Map;
import java.util.List;
import gen.java.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/task")


@io.swagger.annotations.Api(description = "the task API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-17T13:13:34.302Z")
public class TaskApi  {
   private final TaskApiService delegate;

   public TaskApi(@Context ServletConfig servletContext) {
      TaskApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("TaskApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (TaskApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = TaskApiServiceFactory.getTaskApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Adds a new task to a project", notes = "Adds a new task to a project, whil adding the id's of the task and the user.", response = Void.class, tags={ "User", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Task created", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Task creation failed", response = Void.class) })
    public Response addTask(@ApiParam(value = "Adds a task to a project" ) AddTaskObject addTaskObject
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addTask(addTaskObject,securityContext);
    }
    @DELETE
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Deletes a given task", notes = "Deletes a given task, if the given id matches", response = Void.class, tags={ "Task", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Task was deleted", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Something went wrong", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Task ID not found", response = Void.class) })
    public Response deleteTask(@ApiParam(value = "The ID of the project you want to delete",required=true) @QueryParam("taskId") UUID taskId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteTask(taskId,securityContext);
    }
    @PUT
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Edit the values for a task", notes = "Edits the values for a task given the task ID", response = Void.class, tags={ "Task", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Values was EDITED", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Something went wrong", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "ID not found", response = Void.class) })
    public Response editTask(@ApiParam(value = "The task object with the updated values" ) Task taskObject
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.editTask(taskObject,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Gets the tasks based on project id", notes = "Retrevies a task based on the project the task is in with the project ID", response = Task.class, responseContainer = "List", tags={ "Task", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "The tasks was received!", response = Task.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "No task was received", response = Void.class) })
    public Response getTask(@ApiParam(value = "The id of the project",required=true) @QueryParam("projectID") UUID projectID
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getTask(projectID,securityContext);
    }
    @GET
    @Path("/getTaskAmount")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "get the amount of task for a project", notes = "Get the amount of tasks for a project given a project ID", response = Integer.class, tags={ "Task", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Here you go", response = Integer.class) })
    public Response getTaskAmount(@ApiParam(value = "") @QueryParam("taskId") UUID taskId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getTaskAmount(taskId,securityContext);
    }
}
