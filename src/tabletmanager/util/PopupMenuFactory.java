package tabletmanager.util;

import tabletmanager.Constants;

import java.awt.*;

public class PopupMenuFactory {

    public static PopupMenu createPopupMenu() {
        PopupMenu popupMenu = new PopupMenu();

        add(popupMenu, "Restart Server", () -> ADBComnmandUtil.runCommand(Constants.ADB_USB,true));

        add(popupMenu, "connect", () -> {
            ADBComnmandUtil.runCommand(Constants.ENABLE_TETHERING, true);
            ADBComnmandUtil.runCommand(Constants.OPEN_SPACE_DESK, true);
            ADBComnmandUtil.runCommand(Constants.PRESS_POWER_BUTTON, true);
        });

        add(popupMenu, "Enable Tethering", () -> ADBComnmandUtil.runCommand(Constants.ENABLE_TETHERING,true));

        add(popupMenu, "Disable Tethering", () -> ADBComnmandUtil.runCommand(Constants.DISABLE_TETHERING,true));

        add(popupMenu, "open space desk", () -> ADBComnmandUtil.runCommand(Constants.OPEN_SPACE_DESK,true));

        add(popupMenu, "close space desk", () -> ADBComnmandUtil.runCommand(Constants.CLOSE_SPACE_DESK,true));

        add(popupMenu, "unlock screen", () -> ADBComnmandUtil.runCommand(Constants.PRESS_POWER_BUTTON, true));

        add(popupMenu, "Tap on IP", () -> ADBComnmandUtil.runCommand(Constants.TAP_IP,true));

        add(popupMenu, "SHOUTDOWN", () -> ADBComnmandUtil.runCommand(Constants.SHOUTDOWN,true));

        add(popupMenu, "REBOOT", () -> ADBComnmandUtil.runCommand(Constants.REBOOT,true));
        add(popupMenu, "quit", () -> System.exit(0));

        return popupMenu;
    }

    private static void add(PopupMenu popupMenu, String label, Runnable action) {
        MenuItem item = new MenuItem(label);
        item.addActionListener(e -> new Thread(action).start());
        popupMenu.add(item);

    }
}
