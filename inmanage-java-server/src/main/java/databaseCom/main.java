package main.java.databaseCom;

import java.sql.SQLException;
import java.util.UUID;

        public class main {

            // Main method, mainly for testing purposes. /omhaw16,pepak16
            public void main(String[] args) throws SQLException {

                System.out.println("Welcome to the testing method of SQLCommands.java!");
                System.out.println("Creating instance of the SQLConnection class.");
                SQLConnect sql = new SQLConnect();
                System.out.println("Instance created.");
                System.out.println("Attempting to connect to server.");
                System.out.println("");
                System.out.println("Creating SQLCommands instance 'sqlc'");
                SQLCommands sqlc = SQLCommands.getInstance();
                System.out.println("Instance created.");
                System.out.println("Now fetching all to-do task names, sorted by PROJECT '105e4567-e89b-12d3-a456-426655440000'");
                sqlc.getTaskByStatus("105e4567-e89b-12d3-a456-426655440000", 1);
                System.out.println("");
                System.out.println("Testing done.");
                System.out.println("Now exiting...");
                System.exit(1);
            }
        }

