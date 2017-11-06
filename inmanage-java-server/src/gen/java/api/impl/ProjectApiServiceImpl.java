package gen.java.api.impl;

import gen.java.api.*;
import gen.java.model.*;

import gen.java.model.Project;

import java.util.List;
import gen.java.api.NotFoundException;

import java.io.InputStream;

import main.java.clientCom.ProjectTestServer;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-06T19:42:05.650Z")
public class ProjectApiServiceImpl extends ProjectApiService {
    @Override
    public Response addProject(Project project, SecurityContext securityContext) throws NotFoundException {
        // do some magic
        return Response.ok().entity(ProjectTestServer.get().addProjectResponse(project)).build();
    }
    @Override
    public Response getAllProjects(String userId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
