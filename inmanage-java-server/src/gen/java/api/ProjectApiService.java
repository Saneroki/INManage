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
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-17T13:13:34.302Z")
public abstract class ProjectApiService {
    public abstract Response addProject(Project project,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addUserToProject( String projectID, String theIDOfTheUserMakingTheOperation,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteProject( @NotNull String projectId, @NotNull String passWord,SecurityContext securityContext) throws NotFoundException;
    public abstract Response editProject(Project projectObject,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getAllProjects( @NotNull String userId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getSpecificProject( String projectID,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getUserAmount( @NotNull String projectId,SecurityContext securityContext) throws NotFoundException;
}
