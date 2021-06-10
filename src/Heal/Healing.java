package Heal;

import xobot.script.methods.tabs.Equipment;
import xobot.script.methods.tabs.Inventory;
import xobot.script.methods.tabs.Skills;
import xobot.script.util.Time;
import xobot.script.wrappers.interactive.Item;


/** Class used to handle healing
 * @author Amaan V
 */


public class Healing {

    public static void wearPneck() {
        if (Equipment.getEquipment() != null) {
            if (!Equipment.containsOneOf(11090)) {
                if (Inventory.getItems() != null) {
                    Item pneck = Inventory.getItem(11090);
                    if (pneck != null) {
                        pneck.interact("Wear");
                    }
                }
            }
        }
    }

    public static void eatShark() {
        if (Inventory.getItems() != null) {
            Item shark = Inventory.getItem(385);
            if (shark != null) {
                shark.interact("Eat");
            }
        }
    }

    public static void drinkBrew() {
        Item brew = Inventory.getItem(14128, 14126, 14124, 14122, 14419, 14417);
        if (brew != null) {
            brew.interact("Drink");
            Time.sleep(200);
        }
    }

    public static void drinkRenewal() {
        Item brew = Inventory.getItem(21630, 21632, 21634, 21636, 15119, 15121, 14289, 14287, 15123, 15117);
        if (brew != null) {
            brew.interact("Drink");
            Time.sleep(200);
        }
    }

    public static void drinkRestore() {
        Item brew = Inventory.getItem(14415, 14413, 14411, 14409, 14407, 14405);
        if (brew != null) {
            brew.interact("Drink");
            Time.sleep(200);
        }
    }

    public static void drinkRangedPot() {
        if (Skills.RANGE.getCurrentLevel() <= 105 && Inventory.getAll() != null) {
            Item rangePot = Inventory.getItem(14152, 14150, 14148, 14146, 14144, 14142);
            if (rangePot != null) {
                rangePot.interact("Drink");
                Time.sleep(() -> Skills.RANGE.getCurrentLevel() >= 106, 600);
            }
        }
    }

    public static void drinkStrPot() {
        if (Skills.STRENGTH.getCurrentLevel() <= 105 && Inventory.getAll() != null) {
            Item rangePot = Inventory.getItem(14176, 14174, 14172, 14170, 14168, 14166);
            if (rangePot != null) {
                rangePot.interact("Drink");
                Time.sleep(() -> Skills.STRENGTH.getCurrentLevel() >= 106, 600);
            }
        }
    }



}
