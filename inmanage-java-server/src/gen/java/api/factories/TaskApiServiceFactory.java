package gen.java.api.factories;

import gen.java.api.TaskApiService;
import main.java.clientCom.TaskApiImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-29T09:47:06.589Z")
public class TaskApiServiceFactory {
    private final static TaskApiService service = new TaskApiImpl();

    public static TaskApiService getTaskApi() {
        return service;
    }
}
