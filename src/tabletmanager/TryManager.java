package tabletmanager;

import tabletmanager.util.PopupMenuFactory;

import java.awt.*;

public class TryManager {

    public void start() throws AWTException {

        if (!SystemTray.isSupported()) return;

        PopupMenu popupMenu = PopupMenuFactory.createPopupMenu();

        Image image = Toolkit.getDefaultToolkit().getImage(TryManager.class.getResource("/icon.png"));

        TrayIcon trayIcon = new TrayIcon(image, "Tablet Manager", popupMenu);
        trayIcon.setImageAutoSize(true);
        trayIcon.displayMessage(
                "TabletManager",
                "Application started",
                TrayIcon.MessageType.INFO
        );

        SystemTray.getSystemTray().add(trayIcon);

    }

}
