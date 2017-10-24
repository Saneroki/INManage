package inmanagepkg;

import sql.SQLCommands;

import java.sql.SQLException;

/**
 * Created by omnhaww on 23/10/2017.
 */
public class ProgramImpl implements IProgram {

    private SQLCommands sql;

    private static ProgramImpl instance = null;


    public ProgramImpl() throws SQLException {

        sql = new SQLCommands();

    }

    //Singleton
    public static ProgramImpl getProgramInstance() throws SQLException {
        if (instance == null) {
            instance = new ProgramImpl();
        }
        return instance;
    }

}
