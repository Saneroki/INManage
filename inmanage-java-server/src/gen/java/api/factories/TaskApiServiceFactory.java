package gen.java.api.factories;

import gen.java.api.TaskApiService;
import gen.java.api.impl.TaskApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-07T10:56:57.897Z")
public class TaskApiServiceFactory {
    private final static TaskApiService service = new TaskApiServiceImpl();

    public static TaskApiService getTaskApi() {
        return service;
    }
}
