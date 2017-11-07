package main.java.domain.chat;

/**
 * Created by omnhaww on 07/11/2017.
 */

import java.util.Scanner;

public abstract class AbstractChatClient<Connection> {

    /**
     * The connection to the server, used in concrete subclasses
     */
    private Connection connection;

    /**
     * Activate the client: query for server name, connect, and then create the GUI.
     * The GUI calls back to the 'displayMessagesIn' method when it has been created.
     */
    public void activate() {
        Scanner sc = new Scanner(System.in);
        String serverName = sc.nextLine();
        connection = connectToServer(serverName);
    }

    /**
     * This will be implemented with the GUI. Maybe revise the concept of having a thread in here?
     * An idea would be to have a thread for every user, and I'm assuming that this is what
     * this does? /omhaw16
     */
    public void displayMessagesIn(ChatWindow display) {
        new Thread(() -> {
            while (true) display.addMessage(receiveText(connection));
        }).start();
    }

    /**
     * The action invoked from the GUI when the "send" button is pressed: send the
     * text on the connection
     *
     * @param text the text to send
     */
    public void sendAction(String text) {
        sendText(connection, text);
    }

    /**
     * Hook method: connect to server with the given hostname
     *
     * @param serverName the name of the server
     * @return the object representing the connection
     */
    protected abstract Connection connectToServer(String serverName);

    /**
     * Hook method: send a single piece of text to the server
     *
     * @param connection the connection to send the text on
     * @param text       the text to send
     */
    protected abstract void sendText(Connection connection, String text);

    /**
     * Hook method: receive a single piece of text from the server, blocking
     * until text is available
     *
     * @param connection the connection to get the text from
     * @return the text received from the server
     */
    protected abstract String receiveText(Connection connection);

}
}
