import main.java.gui.ClientLauncher;
import org.apache.maven.shared.invoker.*;

import java.io.File;
import java.util.Arrays;


/**
 * This Class starts the whole Client.
 * It will clean and build maven every time it is executed.
 * It will then move to the class Client Launcher and start the Gui
 * @author Glenn
 */
public class INManage {

    /**
     * This will simply clean and build maven and start the Gui up
     * @param args Java standard
     */
    public static void main(String[] args) {
        mavenStartup();
        ClientLauncher.main(args);
    }

    /**
     * This will clean and install the maven parts
     * @author Glenn
     */
    private static void mavenStartup() {
        InvocationRequest request = new DefaultInvocationRequest();
        request.setPomFile(new File("inmanage-java-client/pom.xml"));
        request.setGoals(Arrays.asList("clean", "install"));

        Invoker invoker = new DefaultInvoker();
        try {
            invoker.execute(request);
        } catch (MavenInvocationException e) {
            throw new Error("Something went bad when cleaning and installing the Client");
        }
    }
}