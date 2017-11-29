package gen.java.api.factories;

import gen.java.api.ProjectApiService;
import gen.java.api.impl.ProjectApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-29T09:47:06.589Z")
public class ProjectApiServiceFactory {
    private final static ProjectApiService service = new ProjectApiServiceImpl();

    public static ProjectApiService getProjectApi() {
        return service;
    }
}
