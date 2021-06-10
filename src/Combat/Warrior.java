package Combat;

import xobot.script.wrappers.interactive.Player;

import static Equipment.Equip.wearCls;
import static Heal.Healing.drinkStrPot;
import static Heal.HealthState.lowHealth;
import static Heal.HealthState.veryLowHealth;
import static Prayers.Prayers.isPrayingRange;
import static Prayers.Prayers.prayPiety;


/** Class used to handle logic for warriors
 * @author Amaan V
 */


public class Warrior {

    public static void meleeAttackLogic(Player target) {
        if (!lowHealth() && !veryLowHealth() && (isPrayingRange(target)) && !target.isMoving()) {
            wearCls();
            prayPiety();
            drinkStrPot();
        }
    }


}
