package huanxiang.core;

import mindustry.gen.Building;
import mindustry.type.Item;
import mindustry.type.ItemStack;
import mindustry.type.Liquid;
import mindustry.type.LiquidStack;
import mindustry.world.blocks.payloads.Payload;

import static mindustry.Vars.content;

public class HuanXiangBuilding {
    public static Building building;
// Building 中这个 → nearby

    public int 物品数量(Item a) {
        return building.items.get(a);
    }

    public boolean 判断物品数量(Item a, int b, int c) {
        if (c == 0) return building.items.get(a) >= b;
        if (c == 1) return building.items.get(a) == b;
        if (c == 2) return building.items.get(a) <= b;
        return false;
    }

    public boolean 判断物品数量(ItemStack[] stacks) {
        for (ItemStack stack : stacks) {
            if (!building.items.has(stack.item, stack.amount)) return false;
        }
        return true;
    }

    public void 生成物品(Item a, int b) {
        building.items.add(a, b);
    }

    public void 生成物品(ItemStack[] a) {
        for (ItemStack stack : a) {
            building.items.add(stack.item, stack.amount);
        }
    }

    public void 清除物品(Item a, int b) {
        building.items.remove(a, b);
    }

    public void 清除物品(ItemStack[] stacks) {
        for (ItemStack stack : stacks)
            building.items.remove(stack.item, stack.amount);
    }


// this.dump(); //导出
// this.dump(物品); //导出物品
// this.dumpLiquid(流体); //导出流体
// this.dumpPayload(载荷); //导出载荷

    public float 流体数量(Liquid a) {
        return building.liquids.get(a);
    }

    public boolean 判断流体数量(Liquid a, float b, int c) {
        if (c == 0) return building.liquids.get(a) >= b;
        if (c == 1) return building.liquids.get(a) == b;
        if (c == 2) return building.liquids.get(a) <= b;
        return false;
    }

    public boolean 判断流体数量(LiquidStack[] stacks) {
        for (LiquidStack stack : stacks) {
            if (!判断流体数量(stack.liquid, stack.amount, 0)) return false;
        }
        return true;
    }

    public void 生成流体(Liquid a, float b) {
        building.liquids.add(a, b);
    }

    public void 生成流体(LiquidStack[] a) {
        for (LiquidStack stack : a) {
            building.liquids.add(stack.liquid, stack.amount);
        }
    }

    public void 清除流体(Liquid a, float b) {
        building.liquids.remove(a, b);
    }

    public void 清除流体(LiquidStack[] a) {
        for (LiquidStack stack : a) {
            building.liquids.remove(stack.liquid, stack.amount);
        }
    }


    public void 导出() {
        building.dump();
    }

    public void 导出(Item a) {
        building.dump(a);
    }

    public void 导出(Liquid a) {
        building.dumpLiquid(a);
    }

    public void 导出(Payload a) {
        building.dumpPayload(a);
    }

}
