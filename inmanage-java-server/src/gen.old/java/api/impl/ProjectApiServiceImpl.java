package gen.java.api.impl;

import gen.java.api.*;
import gen.java.model.*;

import gen.java.model.Project;

import java.util.List;
import gen.java.api.NotFoundException;

import java.io.InputStream;

<<<<<<< HEAD
import io.swagger.models.auth.In;
=======
>>>>>>> Malte
import main.java.clientCom.INManageServer;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-09T14:04:57.864Z")
public class ProjectApiServiceImpl extends ProjectApiService {
    @Override
    public Response addProject(Project project, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
<<<<<<< HEAD
        return Response.ok().entity(INManageServer.get().addProjectResponse(project)).build();
=======
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
>>>>>>> Malte
    }
    @Override
    public Response getAllProjects(String userId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!

        /*
        It says userID but we use project ID, needs to be changed in next version of the API
         */
        return Response.ok().entity(INManageServer.get().getProjectsResponse(userId)).build();
    }
<<<<<<< HEAD

    @Override
    public Response addUserToProject(String projectID, String theIDOfTheUserMakingTheOperation, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        //It says user id but it is username NEEDS TO BE CHANGED IN NEXT API VERSION!
        return Response.ok().entity(INManageServer.get().addUserToProject(projectID,theIDOfTheUserMakingTheOperation)).build();
    }
=======
>>>>>>> Malte
}
