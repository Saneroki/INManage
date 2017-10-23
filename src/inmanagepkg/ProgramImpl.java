package inmanagepkg;

import sql.SQLCommands;

/**
 * Created by omnhaww on 23/10/2017.
 */
public class ProgramImpl implements IProgram {

    private SQLCommands sql;

    private static ProgramImpl instance = null;


    public ProgramImpl() {

        sql = new SQLCommands();

    }

    //Singleton
    public static ProgramImpl getProgramInstance() {
        if (instance == null) {
            instance = new ProgramImpl();
        }
        return instance;
    }

}
