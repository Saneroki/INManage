package gen.java.api;

import gen.java.model.*;
import gen.java.api.UsersApiService;
import gen.java.api.factories.UsersApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import gen.java.model.User;

import java.util.List;
import gen.java.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/users")


@io.swagger.annotations.Api(description = "the users API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-10T14:39:53.890Z")
public class UsersApi  {
   private final UsersApiService delegate = UsersApiServiceFactory.getUsersApi();

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "adds a user", notes = "Adds a User to the system", response = void.class, tags={ "Admins", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "User created", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "invalid input, object invalid", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "an existing item already exists", response = void.class) })
    public Response addUser(@ApiParam(value = "User to add" ) User user
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addUser(user,securityContext);
    }
    @GET
    @Path("/login")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Logs in the user", notes = "Logs in the user with username and password, returns ID to access the content", response = String.class, tags={ "User", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Logged in user succesfully", response = String.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Failed login", response = String.class) })
    public Response loginUser(@ApiParam(value = "The username of user logging in",required=true) @QueryParam("username") String username
,@ApiParam(value = "The password of the user logging in",required=true) @QueryParam("password") String password
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.loginUser(username,password,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "searches Users", notes = "By passing in the appropriate options, you can search for available User in the system ", response = Object.class, tags={ "Admins", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = Object.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Object.class) })
    public Response searchUser(@ApiParam(value = "pass a search string for looking up User",required=true) @QueryParam("searchUsername") String searchUsername
,@ApiParam(value = "number of records to skip for pagination") @QueryParam("skip") Integer skip
,@ApiParam(value = "maximum number of records to return") @QueryParam("limit") Integer limit
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.searchUser(searchUsername,skip,limit,securityContext);
    }
}
