package Loot;


import xobot.script.methods.GroundItems;
import xobot.script.methods.Players;
import xobot.script.methods.tabs.Inventory;
import xobot.script.wrappers.interactive.GroundItem;
import xobot.script.wrappers.interactive.Item;

/** Class used to handle looting objects
 * @author Amaan V
 */
public class Looting {

    public static void lootRestores() {
        if (GroundItems.getAll() != null) {
            if (Inventory.getCount(14415) + Inventory.getCount(14413) + Inventory.getCount(14411) <= 3) {
                GroundItem restore = GroundItems.getNearest(14415, 14413, 14411);
                if (restore != null && restore.getDistance() <= 10)
                    restore.interact("Take");

            }
        }
    }

    public static void lootPnecks() {
        if (GroundItems.getAll() != null) {
            if (Inventory.getCount(11090) <= 4) {
                GroundItem pneck = GroundItems.getNearest(11090);
                if (pneck != null && pneck.getDistance() <= 10) {
                    pneck.interact("Take");
                }
            }
        }
    }

    public static void lootBrew() {
        if (GroundItems.getAll() != null) {
            if (Inventory.getCount(14128) + Inventory.getCount(14126) + Inventory.getCount(14124) <= 3) {
                GroundItem brew = GroundItems.getNearest(14128, 14126, 14124);
                if (brew != null && brew.getDistance() <= 10) {
                    brew.interact("Take");
                }
            }
        }
    }

    public static void lootTitanScrolls() {
        if (GroundItems.getAll() != null && Inventory.getItems() != null) {
            Item scrolls = Inventory.getItem(12825);
            GroundItem pneck = GroundItems.getNearest(12825);
            if (scrolls == null) {
                if (pneck != null && pneck.getDistance() < 10) {
                    pneck.interact("Take");
                }
            }
        }
    }



    public static void lootStuff() {
        if (!Players.getMyPlayer().isInCombat() && Inventory.getFreeSlots() >= 1) {
            lootRestores();
            lootBrew();
            lootPnecks();
        }
        if (!Players.getMyPlayer().isInCombat())
            lootTitanScrolls();
    }


}
