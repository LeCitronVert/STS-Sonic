package sonicthehedgemod.relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.GainStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import sonicthehedgemod.powers.Rings;
import sonicthehedgemod.sonic.Sonic;

import static sonicthehedgemod.SonicTheHedgemod.makeID;

public class TenSecondRing extends BaseRelic {
    private static final String NAME = "TenSecondRing";
    public static final String ID = makeID(NAME);
    private static final RelicTier RARITY = RelicTier.COMMON;
    private static final LandingSound SOUND = LandingSound.CLINK;
    private static final int STRENGTH_AMOUNT = 5;

    public TenSecondRing () { super(ID, NAME, Sonic.Enums.CARD_COLOR, RARITY, SOUND); }

    @Override
    public void atTurnStart() {
        if (!AbstractDungeon.player.hasPower(Rings.POWER_ID)) {
            return;
        }

        this.flash();

        addToBot(new ApplyPowerAction(
            AbstractDungeon.player,
            AbstractDungeon.player,
            new StrengthPower(AbstractDungeon.player, STRENGTH_AMOUNT)
        ));
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + STRENGTH_AMOUNT + DESCRIPTIONS[1];
    }
}
