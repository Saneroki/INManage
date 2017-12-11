package main.java.Chat;


import main.java.databaseCom.SQLCommands;

import java.sql.SQLException;

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
    public String[] fetchMessage(String chatRoom, int lastUpdated) throws SQLException {
        //make connection to server
        SQLCommands sql = new SQLCommands();

        String[] result = {"not implemented"};//implement method
        return result;
    }
}
