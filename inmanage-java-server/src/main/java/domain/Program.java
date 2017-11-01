package main.java.domain;

import main.java.databaseCom.SQLCommands;

import java.sql.SQLException;
import java.util.UUID;

/**
 * Created by omnhaww on 23/10/2017.
 */
public class Program implements IProgram {

    private SQLCommands sql;

    private static Program instance = null;

    private Program() throws SQLException {
        sql = SQLCommands.getInstance();
    }

    //Singleton
    public static Program getProgramInstance() throws SQLException {
        if (instance == null) {
            instance = new Program();
        }
        return instance;
    }

    @Override
    public boolean registerUser(UUID id, String username, String password, String firstname, String lastname, String type) throws SQLException {
        if (sql.isUserExisting(username)) {
            return false;
        } else {
            if (sql.registerUser(id,username,password,firstname,lastname,type)) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public boolean checkUserLogin(String username, String password) throws SQLException {
        if (sql.checkUserLogin(username,password)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getPassword(String username) throws SQLException {
        return sql.getPassword(username);
    }

    @Override
    public String getFirstname(String username) throws SQLException {
        return sql.getFirstname(username);
    }

    @Override
    public String getLastname(String username) throws SQLException {
        return sql.getLastname(username);
    }

    @Override
    public boolean changeUsername(String username) throws SQLException {
        if (sql.setUsername(username)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean changePassword(String username, String password) throws SQLException {
        if (sql.setPassword(username,password)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean changeFirstname(String username, String firstname) throws SQLException {
        if (sql.setFirstname(username,firstname)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean changeLastname(String username, String lastname) throws SQLException {
        if (sql.setLastname(username,lastname)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean changeUserType(String username, String type) throws SQLException {
        if (sql.setUserType(username,type)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isUserExisting(String username) throws SQLException {
        if (sql.isUserExisting(username)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isUserAdmin(String username) throws SQLException {
        if ( sql.isUserAdmin(username)) {
            return true;
        } else {
            return false;
        }
    }
}