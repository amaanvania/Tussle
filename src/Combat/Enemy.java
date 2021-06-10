package Combat;

import xobot.script.methods.Players;
import xobot.script.wrappers.Area;
import xobot.script.wrappers.interactive.Player;


import static Equipment.EquipmentState.hasMageTop;

/** Class used to handle logic for enemies
 * @author Amaan V
 */

public class Enemy {

    public static Player getEnemy() {
        Player bestTarget = getBestEnemy();
        if (bestTarget != null)
            return bestTarget;
        else {
            Player[] allPlayers = Players.getAll(a -> isValidTarget(a));
            if (allPlayers.length > 0)
                return allPlayers[0];
        }
        return null;
    }


    public static Player getBestEnemy() {
        Player[] enemies = Players.getAll(a -> isValidTarget(a));
        if (enemies != null) {
            for (Player p : enemies) {
                if (hasMageTop(p))
                    return p;
            }
        }
        return null;
    }

    public static boolean isValidTarget(Player p) {
        return p != null && (p.getCombatLevel() >= 90) && p.isReachable() && p.isValid() && !p.isDead();
    }

    public static boolean foundTarget(Player target) {
        Player[] allPlayers = Players.getAll();
        if (allPlayers != null && target != null) {
            for (Player p : allPlayers) {
                if (p.getName().equals(target.getName()) && p.isValid())
                    return true;
            }
        }
        return false;
    }


    public static Player getWarEnemy(Area a) {

        for (Player p : Players.getAll(e -> e.getDistance() < 30)) {
            if ((p.getCombatLevel() >= 90)) {
                return p;
            }
        }

        return null;
    }




}
