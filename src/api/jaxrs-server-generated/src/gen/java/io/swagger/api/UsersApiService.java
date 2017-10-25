package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.User;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-25T08:37:56.114Z")
public abstract class UsersApiService {
    public abstract Response addUser(User user,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchUser(String searchUsername,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
}
