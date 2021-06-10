package Heal;

import xobot.script.methods.tabs.Skills;


/** Class used to keep track of the health state of the player
 * @author Amaan V
 */
public class HealthState {

    public static boolean veryLowHealth() {
        return Skills.CONSTITUTION.getCurrentLevel() <= 80;
    }

    public static boolean extremelyLowHealth() {
        return Skills.CONSTITUTION.getCurrentLevel() <= 25;
    }

    public static boolean lowHealth() {
        return Skills.CONSTITUTION.getCurrentLevel() > 80 && Skills.CONSTITUTION.getCurrentLevel() <= 112;
    }

    public static boolean lowPrayer() {
        return Skills.PRAYER.getCurrentLevel() < 30;
    }


}
