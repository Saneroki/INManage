package main.java.domain.chat;

/*
 * a Comment.
 */

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ChatClient extends AbstractChatClient<IChatServer> {

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import main.java.domain.AbstractChatClient;

    /**
     * Client for the RMI-based local area network chat server.  As is the case
     * for the other client implementations, the client extends the AbstractChatClient
     * base class.  To interact with the server, the client must however provide a
     * remote object implementing the IChatClient interface, and making it a remote
     * object is most easily done by extending the UnicastRemoteObject class.  This
     * necessitates using two different objects, one extending AbstractChatClient and
     * one extending UnicastRemoteObject.  The solution is to add a small inner class
     * MessageReceiver that simply implements the IChatClient interface and directly
     * accesses the enclosing ChatClient object to deliver messages from the server
     * into a blocking queue.  This blocking queue is read by the client program to
     * provide new messages to the GUI.
     * @author ups
     *
     */

    /**
     * Remote object that is passed to the server and used to perform callbacks
     * that deliver messages into the queue object
     *
     * @author ups
     */
    @SuppressWarnings("serial")
    private class MessageReceiver implements IChatClient {

        protected MessageReceiver() {
            super();
        }

        @Override
        public void receiveMessage(String message) {
            queue.add(message);
        }

    }

    /**
     * Messages delivered from the server
     */
    private BlockingQueue<String> queue = new LinkedBlockingQueue<String>();

    /**
     * Remote object for delivering callbacks from the server
     */
    private MessageReceiver receiver;

    /**
     * Create the client, including creation of remote object for delivering callbacks
     */
    public ChatClient() {
        try {
            receiver = new MessageReceiver();
        } catch (RemoteException e) {
            throw new Error("Failed to create client");
        }
    }

    /**
     * Establish a connection to the given server, registering the callback object
     * and returning an IChatServer proxy
     * <p>
     * We have to revise this in order to match it to whatever server we'll be going with.
     * Make the name of the server interface IChatServer and implement the methods respectively.
     * <p>
     * /omhaw16
     */
    @Override
    protected IChatServer connectToServer(String serverName) {
        Registry registry;
        try {
            registry = LocateRegistry.getRegistry(serverName, RMI_Config.REGISTRY_PORT);
            IChatServer server = (IChatServer) registry.lookup(RMI_Config.OBJECT_NAME);
            server.registerClient(receiver);
            return server;
        } catch (RemoteException | NotBoundException e) {
            throw new Error("Error when connecting to server: " + e);
        }
    }

    /**
     * Send a single line of text to the server using the proxy
     * This should be revised to match the server.
     */
    @Override
    protected void sendText(IChatServer connection, String text) {
        try {
            connection.sendMessage(text);
        } catch (RemoteException e) {
            throw new Error("Error when sending text: " + e);
        }
    }

    /**
     * Receive text that has already been delivered into the queue (or wait
     * for text if there is none)
     */
    @Override
    protected String receiveText(IChatServer connection) {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            throw new Error("Interrupted while waiting for new message");
        }
    }

    /**
     * Start the client
     */
    public static void main(String argv[]) {
        new ChatClient().activate();
    }


}

    }
            }
