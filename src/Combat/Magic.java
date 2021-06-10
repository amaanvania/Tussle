package Combat;


import xobot.script.methods.Bank;
import xobot.script.methods.Packets;
import xobot.script.methods.tabs.Equipment;
import xobot.script.methods.tabs.Inventory;
import xobot.script.methods.tabs.Skills;
import xobot.script.util.Time;
import xobot.script.wrappers.Area;
import xobot.script.wrappers.Tile;
import xobot.script.wrappers.interactive.Player;

import static Equipment.Equip.wearTankBody;
import static Equipment.Equip.wearTankLegs;
import static Heal.Healing.*;
import static Heal.HealthState.*;
import static Heal.HealthState.veryLowHealth;


/** Class used to handle logic for magicians
 * @author Amaan V
 */


public class Magic {

    public static void castBlitz(Player p) {
        Packets.sendAction("Cast", "<col=65280>Ice Blitz</col>", 626, 0, 0, 12871);
        Packets.sendAction("Cast Ice Blitz on", p.getName(), 365, p.getIndex(), 0, 0);
    }

    public static void castBarrage(Player p) {
        Packets.sendAction("Cast", "<col=65280>Ice Barrage</col>", 626, 0, 0, 12891);
        Packets.sendAction("Cast Ice Barrage on", p.getName(), 365, p.getIndex(), 0, 0);
    }

    public static boolean isMager() {
        if (Bank.isOpen())
            return Bank.getItem(51791) != null;

        return Equipment.containsOneOf(51791, 15486, 4675) || Inventory.Contains(51791, 15486, 4675);
    }


    public static void staffSpec() {
        Packets.sendAction("Use <col=65280>Special Attack</col>", null, 315, 0, 0, 22601);
    }


    public static boolean canBarrage(Player p) {
        Tile currTile = p.getLocation();
        Area curr= new Area(new Tile(currTile.getX() - 1, currTile.getY() - 1),
                new Tile(currTile.getX() + 1, currTile.getY() + 1));

        return true;
    }


    public static void mageTankLogic() {
        if (lowHealth()) {
            drinkBrew();
            wearPneck();
            wearTankLegs();
            wearTankBody();
        }
        if (veryLowHealth()) {
            eatShark();
            drinkBrew();
            wearPneck();
            wearTankLegs();
            wearTankBody();
        }
        if (extremelyLowHealth()) {
            staffSpec();
        }
        if (Skills.MAGIC.getCurrentLevel() < Skills.MAGIC.getRealLevel() && (!lowHealth() || !veryLowHealth())) {
            drinkRestore();
        }
        if (lowPrayer() && (!lowHealth() || !veryLowHealth())) {
            drinkRestore();
            drinkRenewal();
        }
        Time.sleep(100, 200);
    }


}
