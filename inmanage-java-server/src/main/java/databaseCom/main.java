package main.java.databaseCom;

import gen.java.model.Project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class main {

    // Main method, mainly for testing purposes. /omhaw16,pepak16
    public static void main(String[] args) throws SQLException {
//        SQLConnect sql = new SQLConnect();
//        sql.connect();
        SQLCommands sql = SQLCommands.getInstance();
//        System.out.println(sql.$$$$$registerUser(UUID.randomUUID(),"alex33","123123p","alex","hansen","admin"));
//        System.out.println(sql.checkUserLogin("persha95","123123p"));
//        System.out.println(sql.isUserAdmin("alex33"));
//        System.out.println(sql.isUserExisting("persha955"));
//        System.out.println();
        //UUID projectid = UUID.fromString("0af0ebaf-9b29-425c-92c7-3056bb3ff762");
        //System.out.println(sql.getProjectName(uuid));
        //System.out.println(sql.addUser("Ulrik95","123123p","Ulrik","Schultz","member"));
        //System.out.println(sql.addUserToProject(UUID.randomUUID(),UUID.randomUUID(),""));
            //System.out.println(sql.addProject(UUID.fromString("0af0ebaf-9b29-425c-92c7-3056bb3ff762"),"Hammerhaj","The thing goes skrrraaaa"));
        //System.out.println(sql.addUserToProject("hans95",UUID.fromString("105e4567-e89b-12d3-a456-426655440000")));
        //System.out.println(sql.deleteUserFromProject(UUID.fromString("0af0ebaf-9b29-425c-92c7-3056bb3ff762"),UUID.fromString("74d788c4-7b4e-40f1-8b27-c16eb47cb8cc")));
        System.out.println(sql.deleteProject(UUID.fromString("a5c3bfe3-2401-47ae-b197-00dcd1a8b376")));

        //System.out.println(sql.getProject(UUID.fromString("0af0ebaf-9b29-425c-92c7-3056bb3ff762")).toString());

    }
}