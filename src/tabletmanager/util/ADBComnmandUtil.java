package tabletmanager.util;

import java.io.IOException;

public  class ADBComnmandUtil {


    public  static void runCommand(String command) {

        runCommand(command, false);
    }

    public  static void runCommand(String command, boolean waitFor) {

        try {
            Process process = (new ProcessBuilder(command.split(" "))).start();
            if (waitFor)
                process.waitFor();
            process.getInputStream().transferTo(System.out);
            process.getErrorStream().transferTo(System.err);

        } catch (InterruptedException e) {

            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
