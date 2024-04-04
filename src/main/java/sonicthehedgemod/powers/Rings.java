package sonicthehedgemod.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import java.util.Random;

import static sonicthehedgemod.SonicTheHedgemod.makeID;

public class Rings extends BasePower {
    public static final String POWER_ID = makeID("Rings");

    private static final AbstractPower.PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;
    public static final int GUARANTEED_RECOVERY_THRESHOLD = 50;


    public Rings (AbstractCreature owner, AbstractCreature source, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, source, amount);
    }

    @Override
    public int onAttacked(DamageInfo info, int damageAmount) {
        if (damageAmount <= 0) {
            return damageAmount;
        }

        this.flash();
        this.calculateRecoveredRings();
        this.addToTop(new RemoveSpecificPowerAction(
            this.owner,
            this.owner,
            this.ID
        ));

        return 0;
    }
    public void calculateRecoveredRings() {
        if (
            this.amount < GUARANTEED_RECOVERY_THRESHOLD
            && new Random().nextInt(GUARANTEED_RECOVERY_THRESHOLD) > this.amount
        ) {
            return;
        }

        int recoveredAmount = new Random().nextInt(this.amount);
        if (recoveredAmount == 0) {
            recoveredAmount++;
        }

        addToBot(new ApplyPowerAction(
            this.owner,
            this.owner,
            new RingsRecovery(this.owner, this.owner, recoveredAmount)
        ));
    }

    @Override
    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + GUARANTEED_RECOVERY_THRESHOLD + DESCRIPTIONS[1];
    }
}
