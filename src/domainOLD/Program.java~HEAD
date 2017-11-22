package domainOLD;

import sql.SQLCommands;

/**
 * Created by omnhaww on 23/10/2017.
 */
public class Program implements IProgram {

    private SQLCommands sql;

    private static Program instance = null;


    public Program() {

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
