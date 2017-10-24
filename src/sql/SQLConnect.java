package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by omhaw16 on 23/10/2017.
 */
public class SQLConnect {

    // Main method, mainly for testing purposes. /omhaw16

    public static void main(String[] args) throws SQLException {

        SQLConnect sql = new SQLConnect();
        sql.connect();

    }

    /* The method used to connect. This will replace the main method, once sufficient testing
    * has been done. /omhaw16
    */
        public Connection connect() throws SQLException {
            String url = "jdbc:postgresql://tek-mmmi-db0a.tek.c.sdu.dk/si3_2017_group_1_db";
            String user = "si3_2017_group_1";
            String password = "Mach901&blow";
            Connection db = DriverManager.getConnection(url, user, password);
            try {
                db = DriverManager.getConnection(url, user, password);
                System.out.println("Connection to database successful!");
                System.out.println("Welcome!");

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(SQLConnect.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
            return db;
        }
    }
