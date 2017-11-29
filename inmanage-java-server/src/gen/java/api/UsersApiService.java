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

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-29T09:47:06.589Z")
public abstract class UsersApiService {
    public abstract Response addUser(User user,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteUser(String userID,String password,SecurityContext securityContext) throws NotFoundException;
    public abstract Response editUser(User userObject,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getUser(String userId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response loginUser(String username,String password,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchUser(String searchUsername,Integer limit,SecurityContext securityContext) throws NotFoundException;
}
