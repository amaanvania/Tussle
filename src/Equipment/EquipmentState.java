package Equipment;

import xobot.script.methods.tabs.Inventory;
import xobot.script.wrappers.interactive.Player;


/** Class used to keep track of the equipment state of the player
 * @author Amaan V
 */

public class EquipmentState {


    public static boolean hasMageTop(Player p) {
        int[] equipment = p.getEquipment();
        if (equipment != null)
            for (int i : equipment)
                if (i == 4101 || i == 4091 || i == 4111 || i == 53050)
                    return true;
        return false;
    }

    public static boolean hasTitanScrolls() {
        return Inventory.Contains(12825);
    }

    public static boolean isInvSetup() {
        return Inventory.getCount(11090) >= 3 && Inventory.getCount(14128) >= 7 && Inventory.getCount(14415) >= 4;
    }
}
