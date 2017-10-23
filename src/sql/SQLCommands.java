package sql;

import java.sql.Connection;

import inmanagepkg.Program;
import inmanagepkg.ProgramI;

/**
 * Created by omnhaww on 23/10/2017.
 */
public class SQLCommands {
    ProgramI pri;

    SQLConnect SQL_connect = new SQLConnect();
    Connection s = SQL_connect.connect();


    private ProgramI createProgInterface() {
        return Program.getProgramInstance();
    }
}
