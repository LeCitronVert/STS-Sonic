package sonicthehedgemod.relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import sonicthehedgemod.powers.Invincible;
import sonicthehedgemod.sonic.Sonic;

import static sonicthehedgemod.SonicTheHedgemod.makeID;

public class InvincibleStart extends BaseRelic {
    private static final String NAME = "InvincibleStart";
    public static final String ID = makeID(NAME);
    private static final RelicTier RARITY = RelicTier.SHOP;
    private static final LandingSound SOUND = LandingSound.CLINK;

    public InvincibleStart () { super(ID, NAME, Sonic.Enums.CARD_COLOR, RARITY, SOUND); }

    @Override
    public void atBattleStart() {
        this.flash();
        addToTop(new ApplyPowerAction(
            AbstractDungeon.player,
            AbstractDungeon.player,
            new Invincible(AbstractDungeon.player, AbstractDungeon.player, 1)
        ));
    }

    @Override
    public String getUpdatedDescription() { return DESCRIPTIONS[0]; }
}
