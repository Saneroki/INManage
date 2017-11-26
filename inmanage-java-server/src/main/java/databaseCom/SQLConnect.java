package main.java.databaseCom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLConnect {

    /**
     * Made by omhaw16.
     * The method used to connect.
     * @return Connection
     * @throws SQLException
     */
    public Connection connect() throws SQLException {
        String url = "jdbc:postgresql://tek-mmmi-db0a.tek.c.sdu.dk/si3_2017_group_1_db";
        String user = "si3_2017_group_1";
        String password = "Mach901&blow";
        Connection db = DriverManager.getConnection(url, user, password);
        try {
            db = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(SQLConnect.class.getName());
            lgr.log(Level.WARNING, ex.getMessage(), ex);
        }
        return db;
    }
}
