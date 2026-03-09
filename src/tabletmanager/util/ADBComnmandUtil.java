package tabletmanager.util;

import tabletmanager.Constants;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ADBComnmandUtil {

    public static void connect(){

        runCommand(Constants.ENABLE_TETHERING, true);
        runCommand(Constants.OPEN_SPACE_DESK, true);
        runCommand(Constants.PRESS_POWER_BUTTON, true);
    }

    public static void runCommand(String command) {

        runCommand(command, false);
    }

    public static void runCommand(String command, boolean waitFor) {

        try {
            Process process = (new ProcessBuilder(command.split(" "))).start();
            if (waitFor)
                process.waitFor(10, TimeUnit.SECONDS);
            process.getInputStream().transferTo(System.out);
            process.getErrorStream().transferTo(System.err);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt(); // ripristina l'interrupt
            throw new RuntimeException(e);

        } catch (IOException e1) {

            throw new RuntimeException(e1.getCause());

        }
    }
}
