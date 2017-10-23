package sql;

import java.sql.Connection;

import inmanagepkg.ProgramImpl;
import inmanagepkg.IProgram;

/**
 * Created by omnhaww on 23/10/2017.
 */
public class SQLCommands {
    IProgram pri;

    SQLConnect SQL_connect = new SQLConnect();
    Connection s = SQL_connect.connect();


    private IProgram createProgInterface() {
        return ProgramImpl.getProgramInstance();
    }
}
