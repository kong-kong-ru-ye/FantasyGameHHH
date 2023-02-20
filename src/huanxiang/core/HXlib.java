package huanxiang.core;

import arc.Core;
import arc.graphics.g2d.TextureRegion;
import arc.util.Nullable;
import huanxiang.HXMOD;
import mindustry.Vars;
import mindustry.ctype.ContentType;
import mindustry.gen.Building;
import mindustry.type.Item;
import mindustry.type.ItemStack;
import mindustry.type.Liquid;
import mindustry.type.LiquidStack;
import mindustry.world.blocks.payloads.Payload;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatCat;
import mindustry.world.meta.StatUnit;

import java.lang.reflect.Array;

public class HXlib {
    public static Building building;
    public static String mod = HXMOD.ModName + "-";


    public void 方块(String a) {
        Vars.content.getByName(ContentType.block, mod + a);
    }


    public void 单位(String a) {
        Vars.content.getByName(ContentType.unit, mod + a);
    }


    public void 流体(String a) {
        Vars.content.getByName(ContentType.liquid, mod + a);
    }


    public void 物品(String a) {
        Vars.content.getByName(ContentType.item, mod + a);
    }


    public void 子弹(String a) {
        Vars.content.getByName(ContentType.bullet, mod + a);
    }


    public void 状态(String a) {
        Vars.content.getByName(ContentType.status, mod + a);
    }

    public void 天气(String a) {
        Vars.content.getByName(ContentType.weather, mod + a);
    }

    public void 地图(String a) {
        Vars.content.getByName(ContentType.sector, mod + a);
    }

    public void 星球(String a) {
        Vars.content.getByName(ContentType.planet, mod + a);
    }


    public void 阵营(String a) {
        Vars.content.getByName(ContentType.team, mod + a);
    }


    public static TextureRegion 材质(String a) {
        Core.atlas.find(mod + a, Core.atlas.find("clear"));
        return null;
    }

    public void 翻译(String a, String b) {
        Core.bundle.format(a + "." + mod + b + ".name");
    }

    public void 翻译(String a, String b, Array c) {
        Core.bundle.format(a + "." + mod + b + ".name", c);
    }

    public void 统计内容(String a) {
        new Stat(a);
    }

    public void 统计内容(String a, StatCat b) {
        new Stat(a, b);
    }

    public void 统计单位(String a) {
        new StatUnit(a);
    }

    public void 统计单位(String a, boolean b) {
        new StatUnit(a, b);
    }

    public void 统计单位(String a, String b) {
        new StatUnit(a, b);
    }


    public void 统计类别(String a) {
        new StatCat(a);
    }

    public void 设置属性(String a) {
        Attribute.add(a);
    }

    public void 读取属性(String a) {
        Attribute.get(a);
    }

    public void 属性数据(String a) {
        Attribute.get(a).env();
    }


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
