import main.java.databaseCom.SQLCommands;
import org.apache.maven.shared.invoker.*;

import java.io.File;
import java.sql.SQLException;
import java.util.Arrays;

public class StartServer {

    public static void main(String[] args) {
        mavenStartup();
        //connectDB();
    }

    private static void connectDB(){
        try {
            SQLCommands sql = new SQLCommands().getInstance();
        } catch (SQLException e) {
            throw new Error("Connection to the Database failed");
        }
    }

    private static void mavenStartup() {
        InvocationRequest request = new DefaultInvocationRequest();
        request.setPomFile(new File("inmanage-java-server/pom.xml"));
        request.setGoals(Arrays.asList("clean", "package", "jetty:run"));

        Invoker invoker = new DefaultInvoker();
        try {
            invoker.execute(request);
        } catch (MavenInvocationException e) {
            throw new Error("Something went bad when cleaning, building and starting the Server");
        }
    }

}
