package gen.java.api;

import gen.java.api.*;
import gen.java.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import gen.java.model.AddTaskObject;
import gen.java.model.Task;
import java.util.UUID;

import java.util.List;
import gen.java.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-13T12:54:45.303Z")
public abstract class TaskApiService {
    public abstract Response addTask(AddTaskObject addTaskObject,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteTask( @NotNull UUID taskId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response editTask(Task taskObject,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getTask( @NotNull UUID projectID,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getTaskAmount( UUID taskId,SecurityContext securityContext) throws NotFoundException;
}
