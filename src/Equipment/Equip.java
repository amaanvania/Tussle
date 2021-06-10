package Equipment;

import xobot.script.methods.tabs.Inventory;
import xobot.script.wrappers.interactive.Item;


/** Class used to equip weapons and armour
 * @author Amaan V
 */

public class Equip {

    public static void wearRCB() {
        if (Inventory.getItems() != null)
            if (Inventory.Contains(9185)) {
                Item spear = Inventory.getItem(9185);
                if (spear != null) {
                    spear.interact("Wield");
                }
            }
        if (Inventory.Contains(1201, 13736)) {
            Item shield = Inventory.getItem(1201, 13736);
            if (shield != null) {
                shield.interact("Wield");
            }
        }
    }

    public static void wearMagicEquipment() {
        if (Inventory.getAll() != null) {
            Item mageLegs = Inventory.getItem(4103);
            if (mageLegs != null)
                mageLegs.interact("Wear");
            Item mageBody = Inventory.getItem(4101);
            if (mageBody != null)
                mageBody.interact("Wear");
        }

    }

    public static void wearTankLegs() {
        if (Inventory.getAll() != null) {
            Item tankLegs = Inventory.getItem(1079, 4585, 4087);
            if (tankLegs != null)
                tankLegs.interact("Wear");
        }
    }

    public static void wearTankBody() {
        if (Inventory.getAll() != null) {
            Item tankLegs = Inventory.getItem(2503);
            if (tankLegs != null)
                tankLegs.interact("Wear");
        }
    }

    public static void wearGlory() {
        if (Inventory.getAll() != null) {
            Item glory = Inventory.getItem(1712);
            if (glory != null)
                glory.interact("Wear");
        }
    }

    public static void wearCls() {
        if (Inventory.getAll() != null) {
            Item cls = Inventory.getItem(18351, 18353);
            if (cls != null)
                cls.interact("Wield");
        }
    }
}
