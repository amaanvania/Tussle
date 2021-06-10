package Constants;

import xobot.script.wrappers.Area;
import xobot.script.wrappers.Tile;



/** Class used to store constants
 * @author Amaan V
 */


public class Constants {

    public static Area edge = new Area(3000, 3400, 3120, 3520);
    public static Area fifties = new Area(3260, 3904, 3319, 3980);
    public static Area newGate = new Area(3320, 3850, 3350, 3913);
    public static Area gdz = new Area(3150, 3800, 3319, 3910);
    public static Area grif = new Area(3150, 3800, 3319, 3910);

    public static Tile fiftyToNgTile = new Tile(3330, 3893);
    public static Tile ngToGdzTile = new Tile(3311, 3887);
    public static Tile ngToFiftyTile = new Tile(3310, 3906);
    public static int[] mageEquipment = { 10828, 1712, 51791, 15486, 4101, 13736, 4103, 3105, 2550, 7462, 12790 };
    public static int[] rangeEquipment = { 1712, 3105, 2503, 1079, 10828, 9185, 7462, 12790, 13736, 19111, 2550, 9244,
            2825 };
    public static int[] rangeInventory = { 14128, 18353, 18351, 385, 11090, 14415, 21630, 14152, 12825, 14176 };
    public static int[] mageInventory = { 14128, 385, 11090, 14415, 21630, 12825, 14176, 2503, 1079, 560, 565, 555 };
    public static Area market = new Area(3150, 3410, 3225, 3445);
    public static Area fifties2 = new Area(3200, 3550, 3400, 3960);




}
