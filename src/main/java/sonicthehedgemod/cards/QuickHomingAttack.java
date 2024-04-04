package sonicthehedgemod.cards;

import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import sonicthehedgemod.enums.SonicTags;
import sonicthehedgemod.sonic.Sonic;
import sonicthehedgemod.util.CardStats;

public class QuickHomingAttack extends BaseCard {
    public static final String ID = makeID(QuickHomingAttack.class.getSimpleName());

    private static final CardStats info = new CardStats(
        Sonic.Enums.CARD_COLOR,
        CardType.ATTACK,
        CardRarity.SPECIAL,
        CardTarget.ENEMY,
        0
    );

    private static final int DAMAGE = 3;
    private static final int PLUS_UPGRADED_DAMAGE = 2;

    public QuickHomingAttack () {
        super(ID, info);

        setDamage(DAMAGE, PLUS_UPGRADED_DAMAGE);
        setEthereal(true);
        tags.add(SonicTags.HOMING_ATTACK);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToTop(new DamageAction(
            abstractMonster,
            new DamageInfo(abstractPlayer, this.damage)
        ));
    }
}
