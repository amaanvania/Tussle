package Prayers;

import xobot.script.methods.Players;
import xobot.script.wrappers.interactive.Player;

import static Combat.Enemy.foundTarget;
import static Combat.Enemy.isValidTarget;
import static Heal.HealthState.lowHealth;
import static Heal.HealthState.veryLowHealth;
import static Prayers.Prayers.*;

/** Class used to handle Prayer Activation
 * @author Amaan V
 */

public class Activate {

    public static void activatePrayers() {
        prayPiety();
        prayProtect();
        praySummoning();
        prayRange();
    }

    public static void activatePrayers2() {
        prayRigour();
        prayProtect();
        praySummoning();
        prayRange();
    }

    public static void activatePrayers3() {
        prayAugury();
        prayProtect();
        praySummoning();
        prayRange();
    }


    public static void activatePrayerLogic(Player target,boolean mager, boolean hasRigour) {
        if (Players.getAll() != null) {
            if ((Players.getAll(a -> isValidTarget(a)).length > 0 || (target != null && foundTarget(target)))
                    || (lowHealth() || veryLowHealth())) {
                if (!mager) {
                    if (hasRigour) {
                        activatePrayers2();
                    } else
                        activatePrayers();
                } else {
                    activatePrayers3();
                }
            }
        }
    }


    }




