package tabletmanager;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new TryManager().start();
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }
        });
    }
}