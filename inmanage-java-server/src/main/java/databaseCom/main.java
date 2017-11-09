package main.java.databaseCom;

import java.sql.SQLException;
import java.util.UUID;

public class main {

    // Main method, mainly for testing purposes. /omhaw16,pepak16
    public static void main(String[] args) throws SQLException {
        System.out.println("Welcome to the testing method of SQLCommands.java!");
        System.out.println("Creating instance of the SQLConnection class.");
        SQLConnect sql = new SQLConnect();
        System.out.println("Instance created.");
        System.out.println("Attempting to connect to server.");
        sql.connect();
        System.out.println("\n + --- \n");
        System.out.println("Creating SQLCommands instance 'sqlc'");
        SQLCommands sqlc = SQLCommands.getInstance();
        System.out.println("Instance created.");
        System.out.println("Now fetching all tasks sorted by project '105e4567-e89b-12d3-a456-426655440000'");
        sqlc.getAllTaskByProject("105e4567-e89b-12d3-a456-426655440000");
        System.out.println("Testing done.");
        System.out.println("Now exiting...");
        System.exit(1);
    }
}