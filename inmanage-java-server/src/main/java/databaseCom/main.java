package main.java.databaseCom;

import java.sql.SQLException;
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
        UUID userid = UUID.fromString("0af0ebaf-9b29-425c-92c7-3056bb3ff762");
        UUID projectid = UUID.fromString("105e4567-e89b-12d3-a456-426655440000");
        //System.out.println(sql.setProjectName(projectid,"Cloud drive project"));
        System.out.println(sql.getProjectName(userid));
        //System.out.println(sql.setProjectDescription(projectid,"Sikke noget vrøvl..."));
        System.out.println(sql.getProjectDescription(userid));
    }
}