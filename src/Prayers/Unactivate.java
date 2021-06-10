package Prayers;

import xobot.script.methods.Players;
import xobot.script.wrappers.interactive.Player;

import static Combat.Enemy.isValidTarget;
import static Heal.HealthState.lowHealth;
import static Heal.HealthState.veryLowHealth;
import static Prayers.Prayers.*;

/** Class used to handle un-activating prayers
 * @author Amaan V
 */
public class Unactivate {

    public static void unActivatePrayers() {
        unPrayPiety();
        unPrayProtect();
        unPraySummoning();
        unPrayRange();
        unPrayMelee();
    }

    public static void unActivatePrayers2() {

        unPrayRigour();
        unPrayProtect();
        unPraySummoning();
        unPrayRange();
        unPrayMelee();

    }

    public static void unActivatePrayers3() {

        unPrayAugury();
        unPrayProtect();
        unPraySummoning();
        unPrayRange();
        unPrayMelee();
    }


    public static void unActivatePrayerLogic(Player target, boolean mager, boolean hasRigour) {
        if (Players.getAll(a -> isValidTarget(a)).length < 1 && !lowHealth() && !veryLowHealth() && target == null) {
            if (!mager) {
                if (hasRigour) {
                    unActivatePrayers2();
                } else {
                    unActivatePrayers();
                }
            } else {
                unActivatePrayers3();
            }
        }


    }
}
