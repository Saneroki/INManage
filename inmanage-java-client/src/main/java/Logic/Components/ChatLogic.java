package main.java.Logic.Components;

public class ChatLogic {
    public void sendMessage(String text) {
        //make connection to server
        //send message to appropiate chatroom
        System.out.println("message sent");
    }


    /**
     * this method fetches messages from a specific time and onwards.
     * @param chatRoom
     * @param lastUpdated
     * @return
     */
    public String[] fetchMessage(String chatRoom, int lastUpdated){
        //make connection to server

        String[] result = {"not implemented"};//implement method
        return result;
    }
}
