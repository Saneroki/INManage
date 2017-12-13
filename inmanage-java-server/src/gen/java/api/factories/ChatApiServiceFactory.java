package gen.java.api.factories;

import gen.java.api.ChatApiService;
import gen.java.api.impl.ChatApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-13T12:54:45.303Z")
public class ChatApiServiceFactory {
    private final static ChatApiService service = new ChatApiServiceImpl();

    public static ChatApiService getChatApi() {
        return service;
    }
}
