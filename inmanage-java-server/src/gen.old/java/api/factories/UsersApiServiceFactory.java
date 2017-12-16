package gen.java.api.factories;

import gen.java.api.UsersApiService;
import gen.java.api.impl.UsersApiServiceImpl;

<<<<<<< HEAD
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-10T14:39:53.890Z")
=======
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-09T14:04:57.864Z")
>>>>>>> Malte
public class UsersApiServiceFactory {
    private final static UsersApiService service = new UsersApiServiceImpl();

    public static UsersApiService getUsersApi() {
        return service;
    }
}
