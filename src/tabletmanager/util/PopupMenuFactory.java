package tabletmanager.util;

import java.awt.*;

public class PopupMenuFactory {

    public static PopupMenu createPopupMenu() {
        PopupMenu popupMenu = new PopupMenu();

        MenuItem connect = new MenuItem("connect");
        connect.addActionListener(e -> {
            ADBComnmandUtil.runCommand("adb shell su -c service call connectivity 30 i32 1", true);
            ADBComnmandUtil.runCommand("adb shell monkey -p ph.spacedesk.beta 1", true);
            ADBComnmandUtil.runCommand("adb shell input keyevent 26", true);
            ADBComnmandUtil.runCommand("adb shell input touchscreen swipe 643 643 643 80", true);
        });

        MenuItem enableTethering = new MenuItem("Enable Tethering");
        enableTethering.addActionListener(e -> ADBComnmandUtil.runCommand("adb shell su -c service call connectivity 30 i32 1") );

        MenuItem disableTethering = new MenuItem("Disable Tethering");
        disableTethering.addActionListener(e ->  ADBComnmandUtil.runCommand("adb shell su -c service call connectivity 30 i32 0"));

        MenuItem openSpaceDesk = new MenuItem("open space desk");
        openSpaceDesk.addActionListener(e ->  ADBComnmandUtil.runCommand("adb shell monkey -p ph.spacedesk.beta 1"));

        MenuItem closeSpaceDesk = new MenuItem("close space desk");
        closeSpaceDesk.addActionListener(e ->  ADBComnmandUtil.runCommand("adb shell am force-stop ph.spacedesk.beta"));

        MenuItem unlockScreen = new MenuItem("unlock screen");
        unlockScreen.addActionListener(e -> {
            ADBComnmandUtil.runCommand("adb shell input keyevent 26", true);
            ADBComnmandUtil.runCommand("adb shell input touchscreen swipe 643 643 643 80", true);
        });

        MenuItem tapIp = new MenuItem("Tap on IP");
        tapIp.addActionListener(e ->  ADBComnmandUtil.runCommand("adb shell input tap 191 245"));

        MenuItem shoutDown = new MenuItem("SHOUTDOWN");
        shoutDown.addActionListener(e -> ADBComnmandUtil.runCommand("adb shell reboot -p"));

        MenuItem reboot = new MenuItem("REBOOT");
        reboot.addActionListener(e -> ADBComnmandUtil.runCommand("adb reboot"));

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

        return popupMenu;
    }
}
