package main.java.clientCom.factories;

import gen.java.api.UsersApiService;
import main.java.clientCom.Launcher;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-01T20:29:26.283Z")
public class UsersApiServiceFactory {
    private final static UsersApiService service = new Launcher();

    public static UsersApiService getUsersApi() {
        return service;
    }
}
