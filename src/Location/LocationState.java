package Location;


import xobot.script.methods.Players;
import static Constants.Constants.*;

/** Class used to keep track of the location state of the player
 * @author Amaan V
 */

public class LocationState {

    public static boolean inWild() {
        return fifties2.contains(Players.getMyPlayer().getLocation());
    }


    public static boolean atEdge() {
        return edge.contains(Players.getMyPlayer().getLocation());
    }

    public static boolean atMarket() {
        return market.contains(Players.getMyPlayer().getLocation());
    }



}
