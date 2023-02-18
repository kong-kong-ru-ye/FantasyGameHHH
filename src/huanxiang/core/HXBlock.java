package huanxiang.core;


import huanxiang.core.HXPayloads.HXConsumePayloads;
import mindustry.type.Item;
import mindustry.type.PayloadStack;
import mindustry.world.Block;

public class HXBlock extends Block {

    public HXBlock(String name) {
        super(name);
    }

    public HXConsumePayloads huanxiangconsumepayloads(Item item, int amount) {
        return consume(new HXConsumePayloads(new PayloadStack[]{new PayloadStack(item, amount)}));
    }

    public HXConsumePayloads huanxiangconsumepayloads(PayloadStack... items) {
        return consume(new HXConsumePayloads(items));
    }


}