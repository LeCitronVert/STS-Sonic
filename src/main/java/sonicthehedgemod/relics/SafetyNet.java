package sonicthehedgemod.relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import sonicthehedgemod.powers.RingsRecovery;
import sonicthehedgemod.sonic.Sonic;

import static sonicthehedgemod.SonicTheHedgemod.makeID;

public class SafetyNet extends BaseRelic {
    private static final String NAME = "SafetyNet";
    public static final String ID = makeID(NAME);
    private static final RelicTier RARITY = RelicTier.UNCOMMON;
    private static final LandingSound SOUND = LandingSound.CLINK;

    public SafetyNet () { super(ID, NAME, Sonic.Enums.CARD_COLOR, RARITY, SOUND); }

    @Override
    public int onAttacked(DamageInfo info, int damageAmount) {
        if (damageAmount <= 0) {
            return damageAmount;
        }

        this.flash();
        addToBot(new ApplyPowerAction(
            AbstractDungeon.player,
            AbstractDungeon.player,
            new RingsRecovery(AbstractDungeon.player, AbstractDungeon.player, damageAmount)
        ));

        return damageAmount;
    }

    @Override
    public String getUpdatedDescription() { return DESCRIPTIONS[0]; }
}
