package sonicthehedgemod.cards;

import basemod.helpers.BaseModCardTags;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import sonicthehedgemod.powers.Cylooped;
import sonicthehedgemod.sonic.Sonic;
import sonicthehedgemod.util.CardStats;

public class SonicStrike extends BaseCard {
    public static final String ID = makeID(SonicStrike.class.getSimpleName());

    private static final CardStats info = new CardStats(
        Sonic.Enums.CARD_COLOR,
        CardType.ATTACK,
        CardRarity.BASIC,
        CardTarget.ENEMY,
        1
    );

    private static final int DAMAGE = 6;
    private static final int PLUS_UPGRADED_DAMAGE = 3;
    private static final int PLUS_CYLOOPED_DAMAGE = 5;
    private static final int PLUS_UPGRADED_CYLOOPED_DAMAGE = 5;

    public SonicStrike() {
        super(ID, info);
        setDamage(DAMAGE, PLUS_UPGRADED_DAMAGE);
        setMagic(PLUS_CYLOOPED_DAMAGE, PLUS_UPGRADED_CYLOOPED_DAMAGE);

        tags.add(CardTags.STRIKE);
        tags.add(CardTags.STARTER_STRIKE);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        int currentDamage = this.damage;

        if (abstractMonster.hasPower(Cylooped.POWER_ID)) {
            currentDamage += this.magicNumber;
            addToBot(new RemoveSpecificPowerAction(
                abstractMonster,
                abstractPlayer,
                Cylooped.POWER_ID
            ));
        }

        addToTop(new DamageAction(
            abstractMonster,
            new DamageInfo(abstractPlayer, currentDamage)
        ));
    }
}
