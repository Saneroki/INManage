package domain;

import sql.SQLCommands;

/**
 * Created by omnhaww on 23/10/2017.
 */
public class ProgramImpl implements IProgram {

    private SQLCommands sql;

    private static Program instance = null;


    public ProgramImpl() {

        sql = new SQLCommands();

    }

    //Singleton
    public static Program getProgramInstance() {
        if (instance == null) {
            instance = new Program();
        }
        return instance;
    }

}
