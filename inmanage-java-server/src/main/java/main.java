package main.java;

import main.java.databaseCom.SQLCommands;

import java.sql.SQLException;
import java.util.UUID;

        public class main {

            // Main method, mainly for testing purposes. /omhaw16,pepak16
            public static void main(String[] args) throws SQLException {
                SQLCommands sql = new SQLCommands().getInstance();
                //System.out.println(sql.addProject(UUID.fromString("01c285e8-c6fa-11e7-abc4-cec278b6b50a"),"pip pip","miav sagde katten"));
                //System.out.println(sql.addUserToProject("persha95","105e4567-e89b-12d3-a456-426655440000"));
                //System.out.println(sql.checkIfUserProjectExist("0af0ebaf-9b29-425c-92c7-3056bb3ff762","105e4567-e89b-12d3-a456-426655440000"));
                //System.out.println(sql.checkIfUserProjectExist("5b37f0d4-aea6-4793-a309-2d71d23bea47","123e4567-e89b-12d3-a456-426655440000"));
//                System.out.println("Welcome to the testing method of SQLCommands.java!");
//                System.out.println("Creating instance of the SQLConnection class.");
//                SQLConnect sql = new SQLConnect();
//                System.out.println("Instance created.");
//                System.out.println("Attempting to connect to server.");
//                System.out.println("");
//                System.out.println("Creating SQLCommands instance 'sqlc'");
//                SQLCommands sqlc = SQLCommands.getInstance();
//                System.out.println("Instance created.");
//                System.out.println("Now fetching all to-do task names, sorted by PROJECT '105e4567-e89b-12d3-a456-426655440000'");
//                sqlc.getTaskByStatus("105e4567-e89b-12d3-a456-426655440000", 1);
//                System.out.println("");
//                System.out.println("Testing done.");
//                System.out.println("Now exiting...");
//                System.exit(1);

            }
        }

