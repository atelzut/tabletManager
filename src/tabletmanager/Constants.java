package tabletmanager;

public class Constants {

    public static String ENABLE_TETHERING ="adb shell su -c service call connectivity 30 i32 1";
    public static String DISABLE_TETHERING ="adb shell su -c service call connectivity 30 i32 0";
    public static String OPEN_SPACE_DESK="adb shell monkey -p ph.spacedesk.beta 1";
    public static String CLOSE_SPACE_DESK="adb shell am force-stop ph.spacedesk.beta";
    public static String PRESS_POWER_BUTTON="adb shell input keyevent 26";
    public static String SWIPE_LOCK_SEQUENCE="adb shell input touchscreen swipe 643 643 643 80";
    public static String TAP_IP="adb shell input tap 191 245";
    public static String SHOUTDOWN= "adb shell reboot -p";
    public static String REBOOT= "adb reboot";
}
