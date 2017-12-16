package gen.java.api;

import gen.java.model.*;
import gen.java.api.ProjectApiService;
import gen.java.api.factories.ProjectApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import gen.java.model.Project;

import java.util.List;
import gen.java.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/project")


@io.swagger.annotations.Api(description = "the project API")
<<<<<<< HEAD
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-10T14:39:53.890Z")
=======
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-09T14:04:57.864Z")
>>>>>>> Malte
public class ProjectApi  {
   private final ProjectApiService delegate = ProjectApiServiceFactory.getProjectApi();

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Adds a project", notes = "A user creates a new project", response = void.class, tags={ "User", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Project created", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input", response = void.class) })
    public Response addProject(@ApiParam(value = "Name of the project" ) Project project
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addProject(project,securityContext);
    }
<<<<<<< HEAD
    @POST
    @Path("/adduser")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Adds a user to a project", notes = "Adds a user to a specific project", response = void.class, tags={ "User", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "User added", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "User adding failed", response = void.class) })
    public Response addUserToProject(@ApiParam(value = "The ID of the project getting added") @QueryParam("projectID") String projectID
,@ApiParam(value = "The id of the user getting added.") @QueryParam("The ID of the user making the operation") String theIDOfTheUserMakingTheOperation
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addUserToProject(projectID,theIDOfTheUserMakingTheOperation,securityContext);
    }
=======
>>>>>>> Malte
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get's all projects for a user", notes = "Get's all the projects a user participates in", response = Project.class, responseContainer = "List", tags={ "User", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Id found returning projects", response = Project.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "No projects for this id found", response = Project.class, responseContainer = "List") })
    public Response getAllProjects(@ApiParam(value = "The id of the user retriving his projects",required=true) @QueryParam("userId") String userId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getAllProjects(userId,securityContext);
    }
}
