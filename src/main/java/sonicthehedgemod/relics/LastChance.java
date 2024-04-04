package sonicthehedgemod.relics;

import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import sonicthehedgemod.sonic.Sonic;

import static sonicthehedgemod.SonicTheHedgemod.makeID;

public class LastChance extends BaseRelic {
    private static final String NAME = "LastChance";
    public static final String ID = makeID(NAME);
    private static final RelicTier RARITY = RelicTier.SHOP;
    private static final LandingSound SOUND = LandingSound.CLINK;

    public LastChance () { super(ID, NAME, Sonic.Enums.CARD_COLOR, RARITY, SOUND); }

    @Override
    public int onAttacked(DamageInfo info, int damageAmount) {
        int playerHp = AbstractDungeon.player.currentHealth;
        if (playerHp == 1 || damageAmount < playerHp) {
            return damageAmount;
        }

        this.flash();
        return playerHp - 1;
    }

    @Override
    public String getUpdatedDescription() { return DESCRIPTIONS[0]; }
}
