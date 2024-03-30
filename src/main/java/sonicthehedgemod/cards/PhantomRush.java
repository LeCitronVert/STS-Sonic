package sonicthehedgemod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import sonicthehedgemod.sonic.Sonic;
import sonicthehedgemod.util.CardStats;

public class PhantomRush extends BaseCard
{
    public static final String ID = makeID(PhantomRush.class.getSimpleName());

    private static final CardStats info = new CardStats(
        Sonic.Enums.CARD_COLOR,
        CardType.POWER,
        CardRarity.UNCOMMON,
        CardTarget.SELF,
        1
    );

    public PhantomRush() {
        super(ID, info);

        setCostUpgrade(0);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToBot(new ApplyPowerAction(
            abstractPlayer,
            abstractPlayer,
            new sonicthehedgemod.powers.PhantomRush(abstractPlayer, abstractPlayer, 1)
        ));
    }
}
