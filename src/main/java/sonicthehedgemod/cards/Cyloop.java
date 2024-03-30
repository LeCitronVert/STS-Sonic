package sonicthehedgemod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import sonicthehedgemod.powers.Cylooped;
import sonicthehedgemod.sonic.Sonic;
import sonicthehedgemod.util.CardStats;

public class Cyloop extends BaseCard
{
    public static final String ID = makeID(Cyloop.class.getSimpleName());
    private static final CardStats info = new CardStats(
            Sonic.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.BASIC,
            CardTarget.ENEMY,
            1
    );

    public Cyloop() {
        super(ID, info);
        setInnate(true);
        setSelfRetain(true);

        setCostUpgrade(1);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToBot(new ApplyPowerAction(abstractMonster, abstractPlayer, new Cylooped(abstractMonster, abstractPlayer, 1)));
    }
}
