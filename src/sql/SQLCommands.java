package sql;

import java.sql.Connection;

import inmanage.Program;
import inmanage.IProgram;

/**
 * Created by omnhaww on 23/10/2017.
 */
public class SQLCommands {
    IProgram pri;
    SQLConnect SQL_connect;
    Connection c;

    public SQLCommands() {
        c = SQL_connect.connect();
        SQL_connect = new SQLConnect();
    }

    private IProgram createProgInterface() {
        return Program.getProgramInstance();
    }
}