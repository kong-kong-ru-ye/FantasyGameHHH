package huanxiang.core.HXConsume;

import mindustry.gen.*;
import mindustry.world.consumers.ConsumeLiquidFilter;

public class HXConsumeLiquid extends ConsumeLiquidFilter {
    public float minFlammability;

    public HXConsumeLiquid(float minFlammability, float amount) {
        this.amount = amount;
        this.minFlammability = minFlammability;
        this.filter = liquid -> liquid.flammability >= this.minFlammability;
    }

    public HXConsumeLiquid(float amount) {
        this(0.2f, amount);
    }

    public HXConsumeLiquid() {
        this(0.2f);
    }


    @Override
    public float efficiencyMultiplier(Building build) {
        var liq = getConsumed(build);
        return liq == null ? 0f : liq.flammability;
    }
}
