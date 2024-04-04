package sonicthehedgemod.relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.StrengthPower;
import sonicthehedgemod.powers.Rings;
import sonicthehedgemod.sonic.Sonic;

import java.util.Random;

import static sonicthehedgemod.SonicTheHedgemod.makeID;

public class RingEnergy extends BaseRelic {
    private static final String NAME = "RingEnergy";
    public static final String ID = makeID(NAME);
    private static final RelicTier RARITY = RelicTier.RARE;

    private static final LandingSound SOUND = LandingSound.CLINK;

    private static final int PERCENT_CHANCE = 10;
    private static final int STRENGTH_RATIO = 1;

    public RingEnergy () { super(ID, NAME, Sonic.Enums.CARD_COLOR, RARITY, SOUND); }

    @Override
    public void onPlayerEndTurn() {
        if (!AbstractDungeon.player.hasPower(Rings.POWER_ID)) {
            return;
        }

        int ringsAmount = AbstractDungeon.player.getPower(Rings.POWER_ID).amount;

        if (ringsAmount == 1) {
            return;
        }

        int strengthAmount = 0;

        for (int i = 0;i < ringsAmount;i++) {
            int roll = new Random().nextInt(100);
            if (roll > PERCENT_CHANCE) {
                continue;
            }

            strengthAmount++;
        }

        if (strengthAmount == ringsAmount) {
            strengthAmount--;
        }

        if (0 >= strengthAmount) {
            return;
        }

        this.flash();
        addToBot(new ReducePowerAction(
            AbstractDungeon.player,
            AbstractDungeon.player,
            Rings.POWER_ID,
            strengthAmount
        ));
        addToBot(new ApplyPowerAction(
            AbstractDungeon.player,
            AbstractDungeon.player,
            new StrengthPower(AbstractDungeon.player, strengthAmount * STRENGTH_RATIO)
        ));
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + PERCENT_CHANCE + DESCRIPTIONS[1] + STRENGTH_RATIO + DESCRIPTIONS[2];
    }
}
