package gen.java.api.factories;

import gen.java.api.ProjectApiService;
import main.java.clientCom.ProjectApiImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-13T12:54:45.303Z")
public class ProjectApiServiceFactory {
    private final static ProjectApiService service = new ProjectApiImpl();

    public static ProjectApiService getProjectApi() {
        return service;
    }
}
