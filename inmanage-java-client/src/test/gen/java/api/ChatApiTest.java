package gen.java.api;

import gen.java.invoker.ApiException;
import gen.java.model.InlineResponse200;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ChatApi
 */
public class ChatApiTest {

    private final ChatApi api = new ChatApi();

    
    /**
     * Gets a chat message
     *
     * Gets a chat message when something happends in the chat
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getChatMsgTest() throws ApiException {
        String chatID = null;
        // InlineResponse200 response = api.getChatMsg(chatID);

        // TODO: test validations
    }
    
    /**
     * posts a chat message
     *
     * Posts a messeage to a chat
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void postChatMsgTest() throws ApiException {
        String chatID = null;
        String msg = null;
        String timestamp = null;
        // api.postChatMsg(chatID, msg, timestamp);

        // TODO: test validations
    }
    
}
