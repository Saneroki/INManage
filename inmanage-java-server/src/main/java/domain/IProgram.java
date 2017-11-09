package main.java.domain;

import java.sql.SQLException;
import java.util.UUID;

/**
 * Created by omnhaww on 23/10/2017.
 */
public interface IProgram {
    boolean addUser(String username, String password, String firstname, String lastname, String type) throws SQLException;

    boolean checkUserLogin(String username, String password) throws SQLException;

    String getPassword(String username) throws SQLException;

    String getFirstname(String username) throws SQLException;

    String getLastname(String username) throws SQLException;

    boolean changeUsername(String username) throws SQLException;

    boolean changePassword(String username, String password) throws SQLException;

    boolean changeFirstname(String username, String firstname) throws SQLException;

    boolean changeLastname(String username, String lastname) throws SQLException;

    boolean changeUserType(String username, String type) throws SQLException;

    boolean isUserExisting(String username) throws SQLException;

    boolean isUserAdmin(String username) throws SQLException;
}
