package gen.java.api;

import gen.java.model.*;
import gen.java.api.ProjectApiService;
import gen.java.api.factories.ProjectApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import gen.java.model.Project;

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

@Path("/project")


@io.swagger.annotations.Api(description = "the project API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-17T13:13:34.302Z")
public class ProjectApi  {
   private final ProjectApiService delegate;

   public ProjectApi(@Context ServletConfig servletContext) {
      ProjectApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("ProjectApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (ProjectApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = ProjectApiServiceFactory.getProjectApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Adds a project", notes = "A user creates a new project", response = Void.class, tags={ "Project", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Project created", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input", response = Void.class) })
    public Response addProject(@ApiParam(value = "Name of the project" ) Project project
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addProject(project,securityContext);
    }
    @POST
    @Path("/adduser")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Adds a user to a project", notes = "Adds a user to a specific project", response = Void.class, tags={ "Project", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "User added", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "User adding failed", response = Void.class) })
    public Response addUserToProject(@ApiParam(value = "The ID of the project getting added") @QueryParam("projectID") String projectID
,@ApiParam(value = "The id of the user getting added.") @QueryParam("The ID of the user making the operation") String theIDOfTheUserMakingTheOperation
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addUserToProject(projectID,theIDOfTheUserMakingTheOperation,securityContext);
    }
    @DELETE
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Deletes a given project", notes = "Deletes a given project using the project ID", response = Void.class, tags={ "Project", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "It was deleted", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Something went wrong", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "wrong password", response = Void.class) })
    public Response deleteProject(@ApiParam(value = "The ID of the project to be deleted",required=true) @QueryParam("projectId") String projectId
,@ApiParam(value = "The password of the user",required=true) @QueryParam("passWord") String passWord
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteProject(projectId,passWord,securityContext);
    }
    @PUT
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Edits a project", notes = "Edits the values of a project", response = Void.class, tags={ "Project", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "The values was updated!", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Something went wrong", response = Void.class) })
    public Response editProject(@ApiParam(value = "The project object with updated values" ) Project projectObject
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.editProject(projectObject,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get's all projects for a user", notes = "Get's all the projects a user participates in", response = Project.class, responseContainer = "List", tags={ "Project", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Id found returning projects", response = Project.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "No projects for this id found", response = Void.class) })
    public Response getAllProjects(@ApiParam(value = "The id of the user retriving his projects",required=true) @QueryParam("userId") String userId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getAllProjects(userId,securityContext);
    }
    @GET
    @Path("/specific")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Gets information about a specific project", notes = "Gets information about a specific project given a project ID", response = Project.class, tags={ "Project", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Here you go", response = Project.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Something went wrong", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "ID not found", response = Void.class) })
    public Response getSpecificProject(@ApiParam(value = "The ID of the project") @QueryParam("ProjectID") String projectID
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getSpecificProject(projectID,securityContext);
    }
    @GET
    @Path("/getUserAmount")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get the amount of user tagged on a project", notes = "Get the amount of user tagged on a project based on projectID", response = Integer.class, tags={ "Project", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Here is the amount of users", response = Integer.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Get users unsuccesful.", response = Void.class) })
    public Response getUserAmount(@ApiParam(value = "The ID of the project you want to get the amount of user from.",required=true) @QueryParam("projectId") String projectId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getUserAmount(projectId,securityContext);
    }
}
