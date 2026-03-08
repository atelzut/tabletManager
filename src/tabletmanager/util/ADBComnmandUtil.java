package tabletmanager.util;

import java.io.IOException;

public  class ADBComnmandUtil {

    public static void connect(){

        runCommand("adb shell su -c service call connectivity 30 i32 1", true);
        runCommand("adb shell monkey -p ph.spacedesk.beta 1", true);
        runCommand("adb shell input keyevent 26", true);
        runCommand("adb shell input touchscreen swipe 643 643 643 80", true);
    }

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
