package gen.java.api;

import gen.java.model.*;
import gen.java.api.ChatApiService;
import gen.java.api.factories.ChatApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import gen.java.model.InlineResponse200;

import java.util.List;
import gen.java.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/chat")


@io.swagger.annotations.Api(description = "the chat API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-29T09:47:06.589Z")
public class ChatApi  {
   private final ChatApiService delegate = ChatApiServiceFactory.getChatApi();

    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Gets a chat message", notes = "Gets a chat message when something happends in the chat", response = InlineResponse200.class, tags={ "Chat", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Here you go", response = InlineResponse200.class) })
    public Response getChatMsg(@ApiParam(value = "The ID of the chat") @QueryParam("chatID") String chatID
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getChatMsg(chatID,securityContext);
    }
    @POST
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "posts a chat message", notes = "Posts a messeage to a chat", response = void.class, tags={ "Chat", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "The message was posted", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Something went wrong", response = void.class) })
    public Response postChatMsg(@ApiParam(value = "The ID of the chat") @QueryParam("chatID") String chatID
,@ApiParam(value = "The message sent") @QueryParam("msg") String msg
,@ApiParam(value = "The time the message was sent") @QueryParam("timestamp") String timestamp
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.postChatMsg(chatID,msg,timestamp,securityContext);
    }
}
