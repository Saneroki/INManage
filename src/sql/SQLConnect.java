package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by omnhaww on 23/10/2017.
 */
public class SQLConnect {

    public static void main(String[] args) throws SQLException {

        SQLConnect sql = new SQLConnect();
        sql.connect();

    }
        public Connection connect() throws SQLException {
            String url = "jdbc:postgresql://tek-mmmi-db0a.tek.c.sdu.dk/si3_2017_group_1_db";
            String user = "si3_2017_group_1";
            String password = "Mach901&blow";
            Class.forName("org.postgresql.Driver");
            Connection db = DriverManager.getConnection(url, user, password);
            try {
                db = DriverManager.getConnection(url, user, password);

                System.out.println("Connection to database successful!");

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(SQLConnect.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
            return db;
        }
    }
