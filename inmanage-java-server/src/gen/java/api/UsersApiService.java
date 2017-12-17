package gen.java.api;

import gen.java.api.*;
import gen.java.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import gen.java.model.User;

import java.util.List;
import gen.java.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-17T13:13:34.302Z")
public abstract class UsersApiService {
    public abstract Response addUser(User user,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteUser( @NotNull String userID, @NotNull String password,SecurityContext securityContext) throws NotFoundException;
    public abstract Response editUser(User userObject,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getUser( @NotNull String userId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response loginUser( @NotNull String username, @NotNull String password,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchUser( @NotNull String searchUsername, @Min(0) @Max(50) Integer limit,SecurityContext securityContext) throws NotFoundException;
}
