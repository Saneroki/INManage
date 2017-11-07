package gen.java.api.factories;

import gen.java.api.UsersApiService;
import gen.java.api.impl.UsersApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-07T10:56:57.897Z")
public class UsersApiServiceFactory {
    private final static UsersApiService service = new UsersApiServiceImpl();

    public static UsersApiService getUsersApi() {
        return service;
    }
}
