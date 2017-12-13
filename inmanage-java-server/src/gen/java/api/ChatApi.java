package gen.java.api;

import gen.java.model.*;
import gen.java.api.ChatApiService;
import gen.java.api.factories.ChatApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import gen.java.model.InlineResponse200;

import java.util.Map;
import java.util.List;
import gen.java.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/chat")


@io.swagger.annotations.Api(description = "the chat API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-13T12:54:45.303Z")
public class ChatApi  {
   private final ChatApiService delegate;

   public ChatApi(@Context ServletConfig servletContext) {
      ChatApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("ChatApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (ChatApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = ChatApiServiceFactory.getChatApi();
      }

      this.delegate = delegate;
   }

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
    @io.swagger.annotations.ApiOperation(value = "posts a chat message", notes = "Posts a messeage to a chat", response = Void.class, tags={ "Chat", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "The message was posted", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Something went wrong", response = Void.class) })
    public Response postChatMsg(@ApiParam(value = "The ID of the chat") @QueryParam("chatID") String chatID
,@ApiParam(value = "The message sent") @QueryParam("msg") String msg
,@ApiParam(value = "The time the message was sent") @QueryParam("timestamp") String timestamp
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.postChatMsg(chatID,msg,timestamp,securityContext);
    }
}
