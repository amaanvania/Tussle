package Teleports;

import xobot.script.methods.Packets;
import xobot.script.methods.Walking;
import xobot.script.util.Time;
import xobot.script.wrappers.Tile;

import static Heal.Healing.drinkRenewal;
import static Location.LocationState.inWild;

/** Class used to handle Teleportation
 * @author Amaan V
 */
public class Teleports {

    public static void packetTeleport() {
        Packets.sendAction("Cast <col=65280>", null, 315, 0, 0, 13053);
        Time.sleep(10);
        Packets.sendAction("Ok", null, 315, 0, 0, 2495);
        Time.sleep(5);
        Packets.sendAction("Ok", null, 315, 0, 0, 2498);
        Time.sleep(5);
        Packets.sendAction("Ok", null, 315, 0, 0, 2494);
        Time.sleep(5);
        Packets.sendAction("Continue", " ", 679, 0, 0, 367);
        Time.sleep(5);
        Packets.sendAction("Ok", null, 315, 0, 0, 2471);
        Time.sleep(() -> inWild(), 2000);
        drinkRenewal();
    }

    public static void gdzTeleport() {
        Packets.sendAction("Cast <col=65280>", null, 315, 0, 0, 13053);
        Time.sleep(10);
        Packets.sendAction("Ok", null, 315, 0, 0, 2495);
        Time.sleep(5);
        Packets.sendAction("Ok", null, 315, 0, 0, 2497);
        Time.sleep(5);
        Packets.sendAction("Continue", " ", 679, 0, 0, 367);
        Time.sleep(5);
        Packets.sendAction("Ok", null, 315, 0, 0, 2471);
        Time.sleep(() -> inWild(), 2000);
        drinkRenewal();
    }

    public static void ruinsTeleport() {
        Packets.sendAction("Cast <col=65280>", null, 315, 0, 0, 13053);
        Time.sleep(1000);
        Packets.sendAction("Ok", null, 315, 0, 0, 2495);
        Time.sleep(500);
        Packets.sendAction("Ok", null, 315, 0, 0, 2498);
        Time.sleep(100);
        Packets.sendAction("Ok", null, 315, 0, 0, 2495);
        Time.sleep(500);
        Packets.sendAction("Continue", " ", 679, 0, 0, 367);
        Time.sleep(500);
        Packets.sendAction("Ok", null, 315, 0, 0, 2471);
        Time.sleep(() -> inWild(), 2000);
        Time.sleep(2000);
        Tile buffer = new Tile(3354, 3878);
        Walking.walkTo(buffer);
        Time.sleep(() -> buffer.getDistance() < 3, 7000);
        drinkRenewal();
    }

    public static void grifTeleport() {
        Packets.sendAction("Cast <col=65280>Boss teleports", null, 315, 0, 0, 13087);
        Time.sleep(100);
        Packets.sendAction("Ok", null, 315, 0, 0, 2498);
        Time.sleep(100);
        Packets.sendAction("Ok", null, 315, 0, 0, 2498);
        Time.sleep(100);
        Packets.sendAction("Ok", null, 315, 0, 0, 2498);
        Time.sleep(100);
        Packets.sendAction("Ok", null, 315, 0, 0, 2498);
        Time.sleep(100);
        Packets.sendAction("Ok", null, 315, 0, 0, 2498);
        Time.sleep(100);
        Packets.sendAction("Ok", null, 315, 0, 0, 2498);
        Time.sleep(100);
        Packets.sendAction("Ok", null, 315, 0, 0, 2498);
        Time.sleep(100);
        Packets.sendAction("Ok", null, 315, 0, 0, 2494);
        Time.sleep(100);
        Packets.sendAction("Continue", " ", 679, 0, 0, 367);
        Time.sleep(100);
        Packets.sendAction("Ok", null, 315, 0, 0, 2471);
        Time.sleep(() -> inWild(), 3000);
        Time.sleep(1000);
    }
}
