package gen.java.api.factories;

import gen.java.api.ChatApiService;
import gen.java.api.impl.ChatApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-29T09:47:06.589Z")
public class ChatApiServiceFactory {
    private final static ChatApiService service = new ChatApiServiceImpl();

    public static ChatApiService getChatApi() {
        return service;
    }
}
