package main.java;

import main.java.databaseCom.SQLCommands;
import main.java.databaseCom.SQLConnect;

import java.sql.SQLException;
import java.util.UUID;

        public class main {

            // Main method, mainly for testing purposes. /omhaw16,pepak16
            public static void main(String[] args) throws SQLException {
//                SQLCommands sql = new SQLCommands().getInstance();
                //System.out.println(sql.editProjectDescription(UUID.fromString("98117835-2803-4961-95e9-ba2ac0153644"),"The thing doesn't go skraa"));
                //System.out.println(sql.addUser("singh007","dingding","ding","ing","member"));
                //String userid = sql.loginUser("singh007","dingding");
                //System.out.println("The userid: "+userid);
                //System.out.println(sql.addUserToProject("persha95","a3bc9c0e-2d36-41ae-99b2-f932f472d520"));
                //System.out.println(sql.addProject(userid,"Mindstorm","Lego project"));
                //System.out.println(sql.addProject(UUID.fromString("01c285e8-c6fa-11e7-abc4-cec278b6b50a"),"pip pip","miav sagde katten"));
                //System.out.println(sql.addUserToProject("singh007","d61a9697-d261-4d94-9476-02b338768d2d"));
                //System.out.println(sql.checkIfUserProjectExist("0af0ebaf-9b29-425c-92c7-3056bb3ff762","105e4567-e89b-12d3-a456-426655440000"));
                //System.out.println(sql.checkIfUserProjectExist("5b37f0d4-aea6-4793-a309-2d71d23bea47","123e4567-e89b-12d3-a456-426655440000"));
                System.out.println("Welcome to the testing method of SQLCommands.java!");
                System.out.println("This test is set-up and being performed by: OMAR - omhaw16");
                System.out.println("Creating instance of the SQLConnection class.");
                SQLConnect sql = new SQLConnect();
                System.out.println("Instance created.");
                System.out.println("Attempting to connect to server.");
                System.out.println("");
                System.out.println("Connected.");
                System.out.println("Creating SQLCommands instance 'sqlc'");
                SQLCommands sqlc = SQLCommands.getInstance();
                System.out.println("Instance created.");
                System.out.println("Now testing method getSpecificProject with projectID");
//                sqlc.getUserAmount("d61a9697-d261-4d94-9476-02b338768d2d");
                sqlc.getSpecificProject("d61a9697-d261-4d94-9476-02b338768d2d");
//                sqlc.getUser("0216b09d-ceea-4743-add9-b3f67be20a77");
                System.out.println("Project returned.");
//                System.out.println("Now fetching all to-do task names, sorted by PROJECT '105e4567-e89b-12d3-a456-426655440000'");
//                sqlc.getTaskByStatus("105e4567-e89b-12d3-a456-426655440000", 1);
//                System.out.println("");
//                System.out.println("Testing done.");
//                System.out.println("Now exiting...");
//                System.exit(1);
                //System.out.println("\n");
                //sql.printUser("persha95");
                //System.out.println("\n");
                //sql.printUserWithoutPS("' or '1'='1");

            }
        }