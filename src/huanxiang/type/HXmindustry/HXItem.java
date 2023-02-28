package huanxiang.type.HXmindustry;

import arc.graphics.Color;
import arc.util.Nullable;
import mindustry.type.Item;
import mindustry.type.Planet;

public class HXItem extends Item {
    public Color 颜色;
    public float 爆炸性 = 0f;
    public float 燃烧性 = 0f;
    public float 放射性;
    public float 放电性 = 0f;
    public int 表层挖掘等级 = 0;
    public float 建筑时间成本 = 1f;

    public float 建筑生命倍率 = 0f;

    public boolean 优先级;
    /**
     * 如果为 true，则此项目的优先级最低
     **/


    public int 材质数量 = 0;
    public int 过渡帧 = 0;

    public float 材质帧 = 5f;
    /**
     * 如果为真，则建筑物使用此材料。如果假，该材料将在某些岩心中被焚烧.
     */
    public boolean 建筑 = true;
    public boolean 隐藏 = false;
    /**
     * 将此物品添加到列出的行星的隐藏物品序列中
     */
    public @Nullable Planet[] 行星隐藏;





    public static boolean 解锁 = false;
    public static boolean 真锁 = false;
    public static boolean 属性 = true;



    public boolean 浅层 = false;
    public int 浅层挖掘 = 2;
    public int 浅层挖掘等级 = 表层挖掘等级*浅层挖掘;
    public boolean 深层 = false;
    public int 深层挖掘 = 2;
    public int 深层挖掘等级 = 表层挖掘等级*深层挖掘;

    


    public HXItem(String name) {
        super(name);
        super.color = 颜色;
        super.explosiveness = 爆炸性;
        super.flammability = 燃烧性;
        super.radioactivity = 放射性;
        super.charge = 放电性;
        super.hardness = 表层挖掘等级;
        super.cost = 建筑时间成本;
        super.healthScaling = 建筑生命倍率;
        super.lowPriority = 优先级;
        super.frames = 材质数量;
        super.transitionFrames = 过渡帧;
        super.frameTime = 材质帧;
        super.buildable = 建筑;
        super.hidden = 隐藏;
        super.hiddenOnPlanets = 行星隐藏;
    }

    public HXItem(String name, Color color) {
        super(name, color);
        super.color = 颜色;
        super.explosiveness = 爆炸性;
        super.flammability = 燃烧性;
        super.radioactivity = 放射性;
        super.charge = 放电性;
        super.hardness = 表层挖掘等级;
        super.cost = 建筑时间成本;
        super.healthScaling = 建筑生命倍率;
        super.lowPriority = 优先级;
        super.frames = 材质数量;
        super.transitionFrames = 过渡帧;
        super.frameTime = 材质帧;
        super.buildable = 建筑;
        super.hidden = 隐藏;
        super.hiddenOnPlanets = 行星隐藏;
    }
    @Override
    public boolean unlockedNow() {
        return 解锁;
    }

    @Override
    public boolean unlockedNowHost() {
        return 解锁;
    }

    @Override
    public void setStats() {
        if (属性) {
            super.setStats();
        }

    }
}
