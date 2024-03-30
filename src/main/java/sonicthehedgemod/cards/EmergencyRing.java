package sonicthehedgemod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import sonicthehedgemod.powers.Rings;
import sonicthehedgemod.powers.RingsRecovery;
import sonicthehedgemod.sonic.Sonic;
import sonicthehedgemod.util.CardStats;

public class EmergencyRing extends BaseCard {
    public static final String ID = makeID(EmergencyRing.class.getSimpleName());

    private static final CardStats info = new CardStats(
        Sonic.Enums.CARD_COLOR,
        CardType.POWER,
        CardRarity.BASIC,
        CardTarget.SELF,
        0
    );

    private static final int AMOUNT = 1;

    public EmergencyRing () {
        super(ID, info);
        setMagic(AMOUNT);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToBot(new ApplyPowerAction(
            abstractPlayer,
            abstractPlayer,
            new Rings(abstractPlayer, abstractPlayer, this.magicNumber)
        ));

        if (this.upgraded) {
            addToBot(new ApplyPowerAction(
                abstractPlayer,
                abstractPlayer,
                new RingsRecovery(abstractPlayer, abstractPlayer, this.magicNumber)
            ));
        }
    }
}
