import main.java.gui.ClientLauncher;
import org.apache.maven.shared.invoker.*;

import java.io.File;
import java.util.Arrays;

public class INManage {
    public static void main(String[] args) {
        mavenStartup();
        ClientLauncher.main(args);
    }


    public static void mavenStartup() {
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