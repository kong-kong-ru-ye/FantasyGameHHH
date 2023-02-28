package huanxiang.core.HXConsume;

import mindustry.gen.*;
import mindustry.type.Item;
import mindustry.world.consumers.ConsumeItemFilter;

/////
public class HXConsumeItem extends ConsumeItemFilter {
    public float 最小;

    public HXConsumeItem(float 最小) {
        this.最小 = 最小;
        filter = item -> item.flammability >= this.最小;
    }

    public HXConsumeItem() {
        this(0.2f);
    }
    @Override
    public float efficiencyMultiplier(Building build) {
        var item = getConsumed(build);
        return item == null ? 0f : item.flammability;
    }
}
