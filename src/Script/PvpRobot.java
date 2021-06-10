package Script;

import xobot.client.callback.listeners.MessageListener;
import xobot.client.callback.listeners.PaintListener;
import xobot.client.events.MessageEvent;
import xobot.script.ActiveScript;
import xobot.script.methods.tabs.Skills;
import xobot.script.util.Time;
import xobot.script.wrappers.interactive.Player;

import java.awt.*;

import static Banking.Bank.bankLogic;
import static Combat.Archer.*;
import static Combat.Combat.*;
import static Combat.Enemy.foundTarget;
import static Combat.Enemy.getEnemy;
import static Combat.Magic.*;
import static Equipment.Equip.*;
import static Equipment.EquipmentState.isInvSetup;
import static Heal.Healing.drinkStrPot;
import static Heal.HealthState.lowHealth;
import static Heal.HealthState.veryLowHealth;
import static Location.LocationState.*;
import static Loot.Looting.lootStuff;
import static Prayers.Activate.activatePrayerLogic;
import static Prayers.Prayers.*;
import static Prayers.Unactivate.unActivatePrayerLogic;
import static Teleports.Teleports.*;

/** Class used to handle script logic
 * @author Amaan V
 */
public final class PvpRobot extends ActiveScript implements PaintListener, MessageListener {


    public Player target;
    public boolean returnMode;
    public boolean spearMode;
    public boolean snipeMode;
    public boolean hasRigour;
    public boolean warMode;
    public int warLocation; // 0 = 50s, 1 = ng, 2 = gdz
    public boolean mager;
    public boolean ballista;


    public boolean onStart() {
        spearMode = true;
        returnMode = false;
        snipeMode = false;
        warMode = false;
        warLocation = -1;
        hasRigour = Skills.PRAYER.getRealLevel() >= 77;
        mager = isMager();
        ballista = isBallista();
        return running;

    }


    public void mageAttackLogic() {
        if (target != null && foundTarget(target)) {
            if (!lowHealth() && !veryLowHealth() && Skills.MAGIC.getCurrentLevel() >= 82) {
                wearMagicEquipment();
                wearGlory();
                prayAugury();
                if (canBarrage(target))
                    castBarrage(target);
                else
                    castBlitz(target);
            }
            if (canTitanSpec())
                titanSpec();
        } else if ((this.target == null || !foundTarget(target)) && (snipeMode == true)) {
            this.target = getEnemy();
        }
    }



    public void logic() {
        if ((atMarket() || atEdge()) && !isInvSetup()) {
            bankLogic();
            Time.sleep(() -> isInvSetup(), 1000);
        }
        if (inWild() && this.warMode == false && !mager && !ballista) {
            tankLogic();
            activatePrayerLogic(target, mager,hasRigour);
            attackLogic();
            unActivatePrayerLogic(target, mager,hasRigour);
            lootStuff();
        }
        if (inWild() && this.warMode == false && mager) {
            mageTankLogic();
            mageAttackLogic();
            activatePrayerLogic(target, mager,hasRigour);
            lootStuff();
            unActivatePrayerLogic(target, mager,hasRigour);
        }
        if (inWild() && this.warMode == false && ballista) {
            ballistaAttackLogic(target);
            tankLogic();
            activatePrayerLogic(target, mager,hasRigour);
            unActivatePrayerLogic(target, mager,hasRigour);
            lootStuff();
        }
        if (Player.getMyPlayer().isDead())
            Time.sleep(2500, 3500);
        returnLogic();
        Time.sleep(10, 20);
    }



    public void attackLogic() {
        if (target != null && foundTarget(target)) {
            rangeAttackLogic(target);
            if (!lowHealth() && !veryLowHealth() && (isPrayingRange(target))) {
                wearCls();
                prayPiety();
                drinkStrPot();
            }
            target.interact("Attack");
            if (canTitanSpec())
                titanSpec();
        } else if ((this.target == null || !foundTarget(target)) && (snipeMode == true)) {
            this.target = getEnemy();
        }
    }

    public void returnLogic() {
        if (warMode == false && returnMode == true && (atMarket() || atEdge()) && isInvSetup())
            packetTeleport();
        if (warMode == true && (atMarket() || atEdge()) && isInvSetup())
            warReturnLogic();
    }

    public void warReturnLogic() {
        if (atMarket() || atEdge())
            if ((returnMode == true) && isInvSetup()) {
                if (warLocation == 0)
                    packetTeleport();
                if (warLocation == 1)
                    ruinsTeleport();
                if (warLocation == 2)
                    gdzTeleport();
                if (warLocation == 3)
                    grifTeleport();
            }

    }

    @Override
    public int loop() {
        logic();
        return 0;
    }

    @Override
    public void MessageRecieved(MessageEvent messageEvent) {

    }

    @Override
    public void repaint(Graphics graphics) {

    }
}
