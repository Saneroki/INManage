package gen.java.api;

import gen.java.api.*;
import gen.java.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import gen.java.model.Project;

import java.util.List;
import gen.java.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-10T14:39:53.890Z")
public abstract class ProjectApiService {
    public abstract Response addProject(Project project,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addUserToProject(String projectID,String theIDOfTheUserMakingTheOperation,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getAllProjects(String userId,SecurityContext securityContext) throws NotFoundException;
}
