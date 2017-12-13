package gen.java.api.factories;

import gen.java.api.TaskApiService;
import main.java.clientCom.TaskApiImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-13T12:54:45.303Z")
public class TaskApiServiceFactory {
    private final static TaskApiService service = new TaskApiImpl();

    public static TaskApiService getTaskApi() {
        return service;
    }
}
