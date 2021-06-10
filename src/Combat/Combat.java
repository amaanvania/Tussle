package Combat;

import xobot.script.methods.GameTimers;
import xobot.script.methods.Packets;
import xobot.script.methods.Widgets;
import xobot.script.methods.tabs.Inventory;
import xobot.script.methods.tabs.Skills;
import xobot.script.wrappers.GameTimer;
import xobot.script.wrappers.Widget;
import xobot.script.wrappers.interactive.Item;

import static Equipment.Equip.wearTankLegs;
import static Heal.Healing.*;
import static Heal.Healing.drinkRestore;
import static Heal.HealthState.*;
import static Prayers.Prayers.prayAugury;

/** Class used to handle logic for combat
 * @author Amaan V
 */


public class Combat {


    public static int getSpecialAttack() {

        Widget root = Widgets.get(425);
        if (root != null && root.getChild(11) != null) {
            root.getChild(11).getChildren()[22].getColor();
            String special = root.getChild(11).getChildren()[22].getText();
            String[] x = special.split("Attack");
            String r = x[1].replace('(', ' ').replace(')', ' ');
            String res = r.replaceAll(" ", "").replaceAll("%", "");
            return Integer.parseInt(res);

        }

        return 0;

    }

    public static void titanSpec() {
        Packets.sendAction("Cast Special", null, 1801, 0, 0, 0);
    }


    public static boolean canTitanSpec() {
        GameTimer scroll = GameTimers.getTimer(12825);
        Item titanScroll = Inventory.getItem(12825);
        return titanScroll != null && scroll == null;
    }



    public static void tankLogic() {
        if (lowHealth()) {
            drinkBrew();
            wearPneck();
            wearTankLegs();
        }
        if (veryLowHealth()) {
            eatShark();
            drinkBrew();
            wearPneck();
            wearTankLegs();
            prayAugury();
        }
        if (Skills.STRENGTH.getCurrentLevel() < Skills.STRENGTH.getRealLevel() && (!lowHealth() || !veryLowHealth())) {
            drinkRestore();
        }
        if (lowPrayer() && (!lowHealth() || !veryLowHealth())) {
            drinkRestore();
        }

    }




}
