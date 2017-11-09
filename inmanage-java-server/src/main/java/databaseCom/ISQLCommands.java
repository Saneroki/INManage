package main.java.databaseCom;

import java.sql.SQLException;
import java.util.UUID;

public interface ISQLCommands {

    boolean addUser(UUID userid, String username, String password, String firstname, String lastname, String type) throws SQLException;

    boolean checkUserLogin(String username, String password) throws SQLException;

    String getPassword(String username) throws SQLException;

    String getFirstname(String username) throws SQLException;

    String getLastname(String username) throws SQLException;

    public boolean setUsername(String username) throws SQLException;

    boolean setPassword(String username, String password) throws SQLException;

    boolean setFirstname(String username, String firstname) throws SQLException;

    boolean setLastname(String username, String lastname) throws SQLException;

    boolean setUserType(String username, String type) throws SQLException;

    boolean isUserExisting(String username) throws SQLException;

    boolean isUserAdmin(String username) throws SQLException;

    boolean addProject(UUID projectid, String name,String description) throws SQLException;

    String getProjectName(UUID userid) throws SQLException;

    boolean setProjectName(UUID userid, String name) throws SQLException;

    String getProjectDescription(UUID userid) throws SQLException;
}
