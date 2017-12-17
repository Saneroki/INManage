package gen.java.api.factories;

import gen.java.api.UsersApiService;
import main.java.clientCom.UserApiImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-17T13:13:34.302Z")
public class UsersApiServiceFactory {
    private final static UsersApiService service = new UserApiImpl();

    public static UsersApiService getUsersApi() {
        return service;
    }
}
