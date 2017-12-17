package Logic;

import java.util.ArrayList;

public class ChatMassMessages {
    //used to store one to many ChatMessages objects, which the "recieveMessage" method in the chatWindow controller class
    //can iterate through.
    //this could be useful if there's made a call to recieve new messages after the user have been logged out and other users
    //have kept the chat ongoing. instead of the system calling the recieve method multiple times to get all the messages,
    // it can be called once, and get all messages in one go.


    ArrayList<ChatMessage> messageArray = new ArrayList<>();

    public void put(ChatMessage message){
        messageArray.add(message);
    }
}
