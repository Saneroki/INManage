package gen.java.api;

import gen.java.model.*;
import gen.java.api.UsersApiService;
import gen.java.api.factories.UsersApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import gen.java.model.User;

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

@Path("/users")


@io.swagger.annotations.Api(description = "the users API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-17T13:13:34.302Z")
public class UsersApi  {
   private final UsersApiService delegate;

   public UsersApi(@Context ServletConfig servletContext) {
      UsersApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("UsersApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (UsersApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = UsersApiServiceFactory.getUsersApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "adds a user", notes = "Adds a User to the system", response = Void.class, tags={ "User", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "User created", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "invalid input, object invalid", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "an existing item already exists", response = Void.class) })
    public Response addUser(@ApiParam(value = "User to add" ) User user
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addUser(user,securityContext);
    }
    @DELETE
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Deletes the chosen user", notes = "Deletes the given user based on the userID", response = Void.class, tags={ "User", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "User deleted succefully", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Something went wrong", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Wrong password", response = Void.class) })
    public Response deleteUser(@ApiParam(value = "The ID of the user to delete",required=true) @QueryParam("userID") String userID
,@ApiParam(value = "The password of the user",required=true) @QueryParam("password") String password
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteUser(userID,password,securityContext);
    }
    @PUT
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Edit the user", notes = "Edit the user, changing the information.", response = Void.class, tags={ "User", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Void.class) })
    public Response editUser(@ApiParam(value = "The user object" ) User userObject
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.editUser(userObject,securityContext);
    }
    @GET
    @Path("/details")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get the details of a user", notes = "Gets the details of a user based on the ID provided", response = User.class, tags={ "User", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "You get the details", response = User.class) })
    public Response getUser(@ApiParam(value = "The id of the user you want",required=true) @QueryParam("userId") String userId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getUser(userId,securityContext);
    }
    @GET
    @Path("/login")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Logs in the user", notes = "Logs in the user with username and password, returns ID to access the content", response = String.class, tags={ "User", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Logged in user succesfully", response = String.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Failed login", response = Void.class) })
    public Response loginUser(@ApiParam(value = "The username of user logging in",required=true) @QueryParam("username") String username
,@ApiParam(value = "The password of the user logging in",required=true) @QueryParam("password") String password
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.loginUser(username,password,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "searches Users", notes = "By passing in the appropriate options, you can search for available User in the system ", response = User.class, responseContainer = "List", tags={ "User", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = User.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Void.class) })
    public Response searchUser(@ApiParam(value = "pass a search string for looking up User",required=true) @QueryParam("searchUsername") String searchUsername
,@ApiParam(value = "maximum number of records to return") @QueryParam("limit") Integer limit
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.searchUser(searchUsername,limit,securityContext);
    }
}
