package Banking;

import xobot.script.methods.GameObjects;
import xobot.script.methods.tabs.Equipment;
import xobot.script.methods.tabs.Inventory;
import xobot.script.util.Time;
import xobot.script.wrappers.interactive.GameObject;

/** Class used to handle logic for banking
 * @author Amaan V
 */

public class Bank {

    public static void bankLogic() {
        if (Inventory.getCount() <= 28 || Equipment.getEquipment().length <= 9) {
            loadLastPreset();
            Time.sleep(30500);
        }
    }


    public static void loadLastPreset() {
        if (GameObjects.getAll() != null) {
            GameObject booth = GameObjects.getNearest(2213);
            if (booth != null) {
                booth.interact("Load prev. preset");
                Time.sleep(() -> Inventory.getCount() >= 27, 5000);
                Time.sleep(300, 500);
            }
        }
    }


}
