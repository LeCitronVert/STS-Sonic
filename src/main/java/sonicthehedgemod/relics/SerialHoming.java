package sonicthehedgemod.relics;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import sonicthehedgemod.cards.QuickHomingAttack;
import sonicthehedgemod.sonic.Sonic;

import static sonicthehedgemod.SonicTheHedgemod.makeID;

public class SerialHoming extends BaseRelic implements CyloopFinisherRelic {
    private static final String NAME = "SerialHoming";
    public static final String ID = makeID(NAME);
    private static final RelicTier RARITY = RelicTier.COMMON;
    private static final LandingSound SOUND = LandingSound.CLINK;

    public SerialHoming () { super(ID, NAME, Sonic.Enums.CARD_COLOR, RARITY, SOUND); }

    @Override
    public void onCyloopFinisher() {
        this.flash();
        this.addToTop(new MakeTempCardInHandAction(new QuickHomingAttack()));
    }

    @Override
    public String getUpdatedDescription() { return DESCRIPTIONS[0]; }
}
