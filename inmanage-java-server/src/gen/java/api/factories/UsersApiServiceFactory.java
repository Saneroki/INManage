package gen.java.api.factories;

import gen.java.api.UsersApiService;
import main.java.clientCom.UserApiImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-29T09:47:06.589Z")
public class UsersApiServiceFactory {
    private final static UsersApiService service = new UserApiImpl();

    public static UsersApiService getUsersApi() {
        return service;
    }
}
