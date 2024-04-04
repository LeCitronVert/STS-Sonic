package sonicthehedgemod.powers;

import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import sonicthehedgemod.SonicTheHedgemod;
import sonicthehedgemod.relics.CyloopFinisherRelic;

public class Cylooped extends BasePower {
    public static final String POWER_ID = SonicTheHedgemod.makeID("Cylooped");
    private static final AbstractPower.PowerType TYPE = PowerType.DEBUFF;
    private static final boolean TURN_BASED = false;

    private static final double CURRENT_HP_DAMAGE = 0.25;
    private static final double MAX_HP_DAMAGE = 0.1;

    public Cylooped(AbstractCreature owner, AbstractCreature source, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, source, amount);
    }


    public void stackPower(int stackAmount) {
        if (this.amount >= 1) {
            this.flash();

            this.addToTop(new DamageAction(
                    this.owner,
                    new DamageInfo(
                            this.source,
                            Math.max(
                                    (int) Math.ceil(this.owner.maxHealth * 0.1),
                                    (int) Math.ceil(this.owner.currentHealth * 0.25)
                            ),
                            DamageInfo.DamageType.HP_LOSS
                    )
            ));

            this.addToBot(new RemoveSpecificPowerAction(
                    this.owner,
                    this.source,
                    this.ID
            ));
        } else {
            this.amount += 1;
        }
    }

    @Override
    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + displayPercentage(CURRENT_HP_DAMAGE) + DESCRIPTIONS[1] + displayPercentage(MAX_HP_DAMAGE) + DESCRIPTIONS[2];
    }

    private int displayPercentage(double decimal) {
        return (int) (decimal * 100);
    }
}
