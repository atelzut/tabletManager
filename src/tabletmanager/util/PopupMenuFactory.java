package tabletmanager.util;

import tabletmanager.Constants;

import java.awt.*;

public class PopupMenuFactory {

    public static PopupMenu createPopupMenu() {
        PopupMenu popupMenu = new PopupMenu();

        MenuItem connect = new MenuItem("connect");
        connect.addActionListener(e -> ADBComnmandUtil.connect());

        MenuItem enableTethering = new MenuItem("Enable Tethering");
        enableTethering.addActionListener(e -> ADBComnmandUtil.runCommand(Constants.ENABLE_TETHERING) );

        MenuItem disableTethering = new MenuItem("Disable Tethering");
        disableTethering.addActionListener(e ->  ADBComnmandUtil.runCommand(Constants.DISABLE_TETHERING));

        MenuItem openSpaceDesk = new MenuItem("open space desk");
        openSpaceDesk.addActionListener(e ->  ADBComnmandUtil.runCommand(Constants.OPEN_SPACE_DESK));

        MenuItem closeSpaceDesk = new MenuItem("close space desk");
        closeSpaceDesk.addActionListener(e ->  ADBComnmandUtil.runCommand(Constants.CLOSE_SPACE_DESK));

        MenuItem unlockScreen = new MenuItem("unlock screen");
        unlockScreen.addActionListener(e -> {
            ADBComnmandUtil.runCommand(Constants.PRESS_POWER_BUTTON, true);
            ADBComnmandUtil.runCommand(Constants.SWIPE_LOCK_SEQUENCE, true);
        });

        MenuItem tapIp = new MenuItem("Tap on IP");
        tapIp.addActionListener(e ->  ADBComnmandUtil.runCommand(Constants.TAP_IP));

        MenuItem shoutDown = new MenuItem("SHOUTDOWN");
        shoutDown.addActionListener(e -> ADBComnmandUtil.runCommand(Constants.SHOUTDOWN));

        MenuItem reboot = new MenuItem("REBOOT");
        reboot.addActionListener(e -> ADBComnmandUtil.runCommand(Constants.REBOOT));

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
