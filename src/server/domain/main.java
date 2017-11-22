package server.domain;

import java.sql.SQLException;
import java.util.UUID;

public class main {
    public static void main(String[] args) throws SQLException {
        Program program = Program.getProgramInstance();
        System.out.println("Registering user:");
        System.out.println(program.addUser("hans95","123123p","hans","hansen","member"));
        System.out.println("\nChecking ");
        if (program.checkUserLogin("hans95","123123p")) {
            System.out.println("Login is successful!");
        } else {
            System.out.println("Login failed...");
        }
    }

}
