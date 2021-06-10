package Combat;


import xobot.script.methods.Bank;
import xobot.script.methods.tabs.Equipment;
import xobot.script.methods.tabs.Inventory;
import xobot.script.wrappers.interactive.Player;

import static Combat.Combat.canTitanSpec;
import static Combat.Combat.titanSpec;
import static Combat.Enemy.foundTarget;
import static Equipment.Equip.wearGlory;
import static Equipment.Equip.wearRCB;
import static Heal.Healing.drinkRangedPot;
import static Heal.HealthState.lowHealth;
import static Heal.HealthState.veryLowHealth;
import static Prayers.Prayers.*;

/** Class used to handle logic for archers
 * @author Amaan V
 */


public class Archer {

    public static boolean isBallista() {
        if (Bank.isOpen()) {
            return Bank.getItem(a -> a.getDefinition().getName().contains("Ballista")) != null;
        }
        return Equipment.containsOneOf(49481) || Inventory.Contains(49481);
    }
    public static void rangeAttackLogic(Player target) {
        if (!lowHealth() && !veryLowHealth() && (isPrayingMelee(target) || isPrayingMage(target))) {
            wearRCB();
            wearGlory();
            drinkRangedPot();
            prayRigour();
        }
    }

    public static void ballistaAttackLogic(Player target) {
        if (target != null && foundTarget(target)) {
            drinkRangedPot();
            target.interact("Attack");
            if (canTitanSpec())
                titanSpec();
        }
    }



}
