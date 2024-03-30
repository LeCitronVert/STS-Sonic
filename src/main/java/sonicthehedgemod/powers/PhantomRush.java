package sonicthehedgemod.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import sonicthehedgemod.SonicTheHedgemod;

public class PhantomRush extends BasePower
{
    public static final String POWER_ID = SonicTheHedgemod.makeID("PhantomRush");
    private static final AbstractPower.PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;

    public PhantomRush (AbstractCreature owner, AbstractCreature source, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, source, amount);
    }

    @Override
    public void onUseCard(AbstractCard card, UseCardAction action) {
        addToTop(new ApplyPowerAction(
            owner,
            owner,
            new StrengthPower(owner, 1),
            1
        ));
    }

    @Override
    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }
}
