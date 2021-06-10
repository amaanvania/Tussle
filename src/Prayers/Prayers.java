package Prayers;

import xobot.script.methods.Packets;
import xobot.script.methods.Settings;
import xobot.script.util.Time;
import xobot.script.wrappers.interactive.Player;


/** Class used to handle prayer switching
 * @author Amaan V
 */
public class Prayers {

    public static void prayMage() {
        if (Settings.get(95) == 0)
            Packets.sendAction("Activate <col=ff7000>Protect from Magic", "", 169, 0, 0, 5621);
    }

    public static void prayRange() {
        if (Settings.get(96) == 0) {
            Packets.sendAction("Activate <col=ff7000>Protect from Range", "", 169, 0, 0, 5622);
            Time.sleep(100, 200);
        }
    }

    public static void prayMelee() {
        if (Settings.get(97) == 0)
            Packets.sendAction("Activate <col=ff7000>Protect from Melee", "", 169, 0, 0, 5623);
    }

    public static void prayRigour() {
        if (Settings.get(610) == 0)
            Packets.sendAction("Activate <col=ff7000>Rigour", "", 169, 0, 0, 17018);
    }

    public static void praySummoning() {
        if (Settings.get(2843) == 0)
            Packets.sendAction("Activate <col=ff7000>Protect from Summoning", "", 169, 0, 0, 44650);
    }

    public static void prayAugury() {
        if (Settings.get(611) == 0)
            Packets.sendAction("Activate <col=ff7000>Augury", "", 169, 0, 0, 17020);
    }

    public static void prayProtect() {
        if (Settings.get(91) == 0)
            Packets.sendAction("Activate <col=ff7000>Protect Item", "", 169, 0, 0, 5617);
    }

    public static void prayPiety() {
        if (Settings.get(608) == 0)
            Packets.sendAction("Activate <col=ff7000>Piety", "", 169, 0, 0, 25050);
    }

    public static void unPrayMage() {
        if (Settings.get(95) == 1)
            Packets.sendAction("Activate <col=ff7000>Protect from Magic", "", 169, 0, 0, 5621);
    }

    public static void unPrayRange() {
        if (Settings.get(96) == 1) {
            Packets.sendAction("Activate <col=ff7000>Protect from Range", "", 169, 0, 0, 5622);
            Time.sleep(100, 200);
        }
    }

    public static void unPrayMelee() {
        if (Settings.get(97) == 1)
            Packets.sendAction("Activate <col=ff7000>Protect from Melee", "", 169, 0, 0, 5623);
    }

    public static void unPrayRigour() {
        if (Settings.get(610) == 1)
            Packets.sendAction("Activate <col=ff7000>Rigour", "", 169, 0, 0, 17018);
    }

    public static void unPraySummoning() {
        if (Settings.get(2843) == 1)
            Packets.sendAction("Activate <col=ff7000>Protect from Summoning", "", 169, 0, 0, 44650);
    }

    public static void unPrayAugury() {
        if (Settings.get(611) == 1)
            Packets.sendAction("Activate <col=ff7000>Augury", "", 169, 0, 0, 17020);
    }

    public static void unPrayProtect() {
        if (Settings.get(91) == 1)
            Packets.sendAction("Activate <col=ff7000>Protect Item", "", 169, 0, 0, 5617);
    }

    public static void unPrayPiety() {
        if (Settings.get(608) == 1)
            Packets.sendAction("Activate <col=ff7000>Piety", "", 169, 0, 0, 25050);
    }

    public static boolean isPrayingRange(Player p) {
        int prayer = p.getHeadIcon();
        return prayer == 22 || prayer == 19 || prayer == 1 || prayer == 29;
    }

    public static boolean isPrayingMage(Player p) {
        int prayer = p.getHeadIcon();
        return prayer == 23 || prayer == 18 || prayer == 2|| prayer == 27;
    }

    public static boolean isPrayingMelee(Player p) {
        int prayer = p.getHeadIcon();
        return prayer == 21 || prayer == 17 || prayer == 0 || prayer == 28;
    }






}
