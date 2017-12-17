package gen.java.api;

import gen.java.api.*;
import gen.java.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import gen.java.model.InlineResponse200;

import java.util.List;
import gen.java.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-17T13:13:34.302Z")
public abstract class ChatApiService {
    public abstract Response getChatMsg( String chatID,SecurityContext securityContext) throws NotFoundException;
    public abstract Response postChatMsg( String chatID, String msg, String timestamp,SecurityContext securityContext) throws NotFoundException;
}
