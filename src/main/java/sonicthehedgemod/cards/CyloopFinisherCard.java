package sonicthehedgemod.cards;

import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import sonicthehedgemod.relics.CyloopFinisherRelic;

public interface CyloopFinisherCard {
    default void dispatchCyloopFinisher() {
        for (AbstractRelic relic : AbstractDungeon.player.relics) {
            if (relic instanceof CyloopFinisherRelic) {
                ((CyloopFinisherRelic) relic).onCyloopFinisher();
            }
        }
    };
}
