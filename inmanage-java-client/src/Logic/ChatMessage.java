package Logic;

import java.time.LocalTime;
import java.util.Date;

public class ChatMessage {
    //holds the message
    private String Message;

    //holds userID, to show who sent the message.
    private String userID;

    //Holds the id of the chat room which the message is sent to.
    private String ChatRoom;

    //the time and date when the message was sent.
    private String timeStamp;

    public ChatMessage(String Message, String userID, String ChatRoom){
        timeStamp = setTimeStamp();



    }

    private String setTimeStamp(){

        return LocalTime.now().toString();
    }
}
