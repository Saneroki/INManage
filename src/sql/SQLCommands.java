package sql;

import java.sql.Connection;
import java.sql.SQLException;

import domain.Program;
import domain.IProgram;

/**
 * Created by omnhaww on 23/10/2017.
 */
public class SQLCommands {
    IProgram pri;
    SQLConnect SQL_connect;
    Connection c;

    public SQLCommands() {
        try {
            c = SQL_connect.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SQL_connect = new SQLConnect();
    }

    private IProgram createProgInterface() {
        return Program.getProgramInstance();
    }
}