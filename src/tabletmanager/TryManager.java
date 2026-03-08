package tabletmanager;

import java.awt.*;
import java.io.IOException;

public class TryManager {

    public void start() throws AWTException {

        if (!SystemTray.isSupported()) return;

        PopupMenu popupMenu = new PopupMenu();

        MenuItem connect = new MenuItem("connect");
        connect.addActionListener(e -> connectSteps());

        MenuItem enableTethering = new MenuItem("Enable Tethering");
        enableTethering.addActionListener(e -> {
            runCommand("adb shell su -c service call connectivity 30 i32 1");
        });

        MenuItem disableTethering = new MenuItem("Disable Tethering");
        disableTethering.addActionListener(e -> {
            runCommand("adb shell su -c service call connectivity 30 i32 0");
        });

        MenuItem openSpaceDesk = new MenuItem("open space desk");
        openSpaceDesk.addActionListener(e -> {
            runCommand("adb shell monkey -p ph.spacedesk.beta 1");
        });
        MenuItem closeSpaceDesk = new MenuItem("close space desk");
        closeSpaceDesk.addActionListener(e -> {
            runCommand("adb shell am force-stop ph.spacedesk.beta");
        });
        MenuItem unlockScreen = new MenuItem("unlock screen");
        unlockScreen.addActionListener(e -> {
            runCommand("adb shell input keyevent 26", true);
            runCommand("adb shell input touchscreen swipe 643 643 643 80", true);
        });

        MenuItem tapIp = new MenuItem("Tap on IP");
        tapIp.addActionListener(e -> {
            runCommand("adb shell input tap 191 245");
        });
        MenuItem shoutDown = new MenuItem("SHOUTDOWN");
        shoutDown.addActionListener(e -> {
            runCommand("adb shell reboot -p");

        });

        MenuItem reboot = new MenuItem("REBOOT");
        reboot.addActionListener(e -> {
            runCommand("adb reboot");

        });

        popupMenu.add(connect);
        popupMenu.add(enableTethering);
        popupMenu.add(disableTethering);
        popupMenu.add(openSpaceDesk);
        popupMenu.add(closeSpaceDesk);
        popupMenu.add(unlockScreen);
        popupMenu.add(unlockScreen);
        popupMenu.add(tapIp);
        popupMenu.add(shoutDown);
        popupMenu.add(reboot);
        Image image = Toolkit.getDefaultToolkit()
                .getImage(TryManager.class.getResource("/icon.png"));
        TrayIcon trayIcon = new TrayIcon(image, "Tablet Manager", popupMenu);
        trayIcon.setImageAutoSize(true);
        SystemTray.getSystemTray().add(trayIcon);
    }

    private void connectSteps() {
        runCommand("adb shell su -c service call connectivity 30 i32 1", true);
        runCommand("adb shell input keyevent 26", true);
        runCommand("adb shell input touchscreen swipe 643 643 643 80", true);
        runCommand("adb shell monkey -p ph.spacedesk.beta 1", true);

    }

    public void runCommand(String command) {

        runCommand(command, false);
    }

    public void runCommand(String command, boolean waitFor) {

        try {
            Process process = (new ProcessBuilder(command.split(" "))).start();
            if (waitFor)
                process.waitFor();
            process.getInputStream().transferTo(System.out);
            process.getErrorStream().transferTo(System.err);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
