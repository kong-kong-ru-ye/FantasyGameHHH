package huanxiang;

import arc.Core;
import arc.audio.Music;
import arc.audio.Sound;
import arc.graphics.Color;
import arc.graphics.g2d.TextureRegion;
import arc.util.Tmp;
import mindustry.Vars;
import mindustry.core.FileTree;
import mindustry.ctype.ContentType;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatCat;
import mindustry.world.meta.StatUnit;

import java.lang.reflect.Array;

public class HXlib {
    public static String mod = HXMOD.ModName + "-";

    public static void 方块(String a) {
        Vars.content.getByName(ContentType.block, mod + a);
    }


    public static void 单位(String a) {
        Vars.content.getByName(ContentType.unit, mod + a);
    }


    public static void 流体(String a) {
        Vars.content.getByName(ContentType.liquid, mod + a);
    }


    public static void 物品(String a) {
        Vars.content.getByName(ContentType.item, mod + a);
    }


    public static void 子弹(String a) {
        Vars.content.getByName(ContentType.bullet, mod + a);
    }


    public static void 状态(String a) {
        Vars.content.getByName(ContentType.status, mod + a);
    }

    public static void 天气(String a) {
        Vars.content.getByName(ContentType.weather, mod + a);
    }

    public static void 地图(String a) {
        Vars.content.getByName(ContentType.sector, mod + a);
    }

    public static void 星球(String a) {
        Vars.content.getByName(ContentType.planet, mod + a);
    }


    public static void 阵营(String a) {
        Vars.content.getByName(ContentType.team, mod + a);
    }


    public static TextureRegion 材质(String a) {
        Core.atlas.find(mod + a, Core.atlas.find("clear"));
        return null;
    }

    public static void 翻译(String a, String b) {
        Core.bundle.format(a + "." + mod + b + ".name");
    }

    public static void 翻译(String a, String b, Array c) {
        Core.bundle.format(a + "." + mod + b + ".name", c);
    }

    public static void 统计内容(String a) {
        new Stat(a);
    }

    public static void 统计内容(String a, StatCat b) {
        new Stat(a, b);
    }

    public static void 统计单位(String a) {
        new StatUnit(a);
    }

    public static void 统计单位(String a, boolean b) {
        new StatUnit(a, b);
    }

    public static void 统计单位(String a, String b) {
        new StatUnit(a, b);
    }


    public static void 统计类别(String a) {
        new StatCat(a);
    }

    public static void 设置属性(String a) {
        Attribute.add(a);
    }

    public static void 读取属性(String a) {
        Attribute.get(a);
    }

    public static void 属性数据(String a) {
        Attribute.get(a).env();
    }


    public static Color 颜色(String a) {
        return Color.valueOf(a);
    }

    public static Color 颜色2(String 默认, String 目标, final float 差值) {
        return Tmp.c1.set(颜色(默认)).lerp(颜色(目标), 差值);
    }

    public static Color 颜色22(String 默认, String 目标, final float r, final float g, final float b, final float a, final float 差值) {
        return Tmp.c1.set(颜色(默认)).lerp(r, g, b, a, 差值);
    }

    public static Color 颜色3(String 默认, String 目标, String 目标2, final float 差值, final float 差值2) {
        return Tmp.c1.set(颜色(默认)).lerp(颜色(目标), 差值).lerp(颜色(目标2), 差值2);
    }
    public static Sound 声音(String a) {
             FileTree aa = new FileTree();
        return aa.loadSound(a);
    }
    public static Music 音乐(String a) {
        FileTree aa = new FileTree();
        return aa.loadMusic(a);
    }



}
