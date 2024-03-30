package sonicthehedgemod.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;

import static sonicthehedgemod.SonicTheHedgemod.makeID;

public class RingsRecovery extends BasePower {
    public static final String POWER_ID = makeID("RingsRecovery");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;

    public RingsRecovery (AbstractCreature owner, AbstractCreature source, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, source, amount);
    }

    @Override
    public void atStartOfTurn() {
        this.addToTop(new ApplyPowerAction(
            this.owner,
            this.owner,
            new Rings(this.owner, this.owner, this.amount)
        ));

        this.addToBot(new RemoveSpecificPowerAction(
            this.owner,
            this.owner,
            ID
        ));
    }

    @Override
    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }
}
