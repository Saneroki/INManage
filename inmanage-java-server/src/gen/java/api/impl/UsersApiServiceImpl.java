package gen.java.api.impl;

import gen.java.api.*;
import gen.java.model.*;

import gen.java.model.User;

import java.util.List;
import gen.java.api.NotFoundException;

import java.io.InputStream;

import main.java.clientCom.INManageServer;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-07T10:56:57.897Z")
public class UsersApiServiceImpl extends UsersApiService {
    @Override
    public Response addUser(User user, SecurityContext securityContext) throws NotFoundException {
        INManageServer.get().addUserResponse(user);
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response loginUser(String username, String password, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response searchUser(String searchUsername, Integer skip, Integer limit, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
