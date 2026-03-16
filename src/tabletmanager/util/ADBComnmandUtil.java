package tabletmanager.util;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class ADBComnmandUtil {



    public static String runCommand(String command) {

        return runCommand(command, false);
    }

    public static String runCommand(String command, boolean waitFor) {
            System.out.println("Running: " + command);
        try {
            Process process = (new ProcessBuilder(command.split(" "))).start();
            
            if (waitFor &&  !process.waitFor(10, TimeUnit.SECONDS))
                throw new IOException("ADB command failed with exit code " + false);
            InputStream inputStream = process.getInputStream();

            ByteArrayOutputStream output = new ByteArrayOutputStream();
            inputStream.transferTo(System.out);
            inputStream.transferTo(System.err);
            return output.toString();

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt(); // ripristina l'interrupt
            throw new RuntimeException(e);

        } catch (IOException e1) {

            throw new RuntimeException(e1);

        }
    }
}
