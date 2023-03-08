package huanxiang;

import arc.math.Mathf;
import arc.util.Nullable;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.graphics.Pal;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.ui.Bar;
import mindustry.world.blocks.heat.HeatBlock;
import mindustry.world.blocks.heat.HeatConsumer;
import mindustry.world.blocks.heat.HeatProducer;
import mindustry.world.blocks.production.*;
import mindustry.world.draw.DrawBlock;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawHeatOutput;
import mindustry.world.draw.DrawMulti;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;

public class 工厂 {

    public static class 基础工厂 extends GenericCrafter {
        public @Nullable ItemStack 输入物品;
        public @Nullable ItemStack[] 输入多物品;
        public @Nullable LiquidStack 输入流体;
        public @Nullable LiquidStack[] 输入多流体;
        public int[] 流体输出方向 = {-1};
        public boolean 删多余液体 = true;
        public boolean 忽略液体饱满 = false;

        public float 工艺时间 = 80;
        public Effect 工艺效果 = Fx.none;
        public Effect 更新效果 = Fx.none;
        public float 更新效果几率 = 0.04f;
        public float 预热速度 = 0.019f;
        public DrawBlock 材质 = new DrawDefault();


        public 基础工厂(String name) {
            super(name);
            super.outputItem = 输入物品;
            super.outputItems = 输入多物品;
            super.outputLiquid = 输入流体;
            super.outputLiquids = 输入多流体;
            super.liquidOutputDirections = 流体输出方向;
            super.dumpExtraLiquid = 删多余液体;
            super.ignoreLiquidFullness = 忽略液体饱满;
            super.craftTime = 工艺时间;
            super.craftEffect = 工艺效果;
            super.updateEffect = 更新效果;
            super.updateEffectChance = 更新效果几率;
            super.warmupSpeed = 预热速度;
            super.drawer = 材质;
        }
        public class 基础工厂Build extends GenericCrafterBuild {}
    }
    public static class 地形工厂 extends AttributeCrafter {
        public @Nullable ItemStack 输入物品;
        public @Nullable ItemStack[] 输入多物品;
        public @Nullable LiquidStack 输入流体;
        public @Nullable LiquidStack[] 输入多流体;
        public int[] 流体输出方向 = {-1};
        public boolean 删多余液体 = true;
        public boolean 忽略液体饱满 = false;

        public float 工艺时间 = 80;
        public Effect 工艺效果 = Fx.none;
        public Effect 更新效果 = Fx.none;
        public float 更新效果几率 = 0.04f;
        public float 预热速度 = 0.019f;
        public DrawBlock 材质 = new DrawDefault();



        public Attribute 地形 = Attribute.heat;
        public float 基本效率 = 1f;
        public float 提升效率倍率 = 1f;
        public float 最大效率 = 1f;
        public float 最小效率 = -1f;
        public float 显示效率倍率 = 1f;
        public boolean 显示效率 = true;





        public 地形工厂(String name) {
            super(name);
            super.outputItem = 输入物品;
            super.outputItems = 输入多物品;
            super.outputLiquid = 输入流体;
            super.outputLiquids = 输入多流体;
            super.liquidOutputDirections = 流体输出方向;
            super.dumpExtraLiquid = 删多余液体;
            super.ignoreLiquidFullness = 忽略液体饱满;
            super.craftTime = 工艺时间;
            super.craftEffect = 工艺效果;
            super.updateEffect = 更新效果;
            super.updateEffectChance = 更新效果几率;
            super.warmupSpeed = 预热速度;
            super.drawer = 材质;

            super.attribute = 地形;
            super.baseEfficiency = 基本效率;
            super.boostScale = 提升效率倍率;
            super.maxBoost = 最大效率;
            super.minEfficiency = 最小效率;
            super.displayEfficiencyScale = 显示效率倍率;
            super.displayEfficiency = 显示效率;
        }
        public class 地形工厂Build extends   AttributeCrafterBuild{}
    }

    public static class 输热工厂 extends HeatCrafter {
        public @Nullable ItemStack 输入物品;
        public @Nullable ItemStack[] 输入多物品;
        public @Nullable LiquidStack 输入流体;
        public @Nullable LiquidStack[] 输入多流体;
        public int[] 流体输出方向 = {-1};
        public boolean 删多余液体 = true;
        public boolean 忽略液体饱满 = false;

        public float 工艺时间 = 80;
        public Effect 工艺效果 = Fx.none;
        public Effect 更新效果 = Fx.none;
        public float 更新效果几率 = 0.04f;
        public float 预热速度 = 0.019f;
        public DrawBlock 材质 = new DrawDefault();

        public float 基本需求 = 10f;
        public float 过热缩减倍率 = 1f;
        public float 最大效率 = 4f;

        public 输热工厂(String name) {
            super(name);
            super.outputItem = 输入物品;
            super.outputItems = 输入多物品;
            super.outputLiquid = 输入流体;
            super.outputLiquids = 输入多流体;
            super.liquidOutputDirections = 流体输出方向;
            super.dumpExtraLiquid = 删多余液体;
            super.ignoreLiquidFullness = 忽略液体饱满;
            super.craftTime = 工艺时间;
            super.craftEffect = 工艺效果;
            super.updateEffect = 更新效果;
            super.updateEffectChance = 更新效果几率;
            super.warmupSpeed = 预热速度;
            super.drawer = 材质;

            super.heatRequirement = 基本需求;
            super.overheatScale = 过热缩减倍率;
            super.maxEfficiency = 最大效率;
        }
        public class 输热工厂Build extends HeatCrafterBuild {}
    }

    public static class 出热工厂 extends HeatProducer {
        public @Nullable ItemStack 输入物品;
        public @Nullable ItemStack[] 输入多物品;
        public @Nullable LiquidStack 输入流体;
        public @Nullable LiquidStack[] 输入多流体;
        public int[] 流体输出方向 = {-1};
        public boolean 删多余液体 = true;
        public boolean 忽略液体饱满 = false;

        public float 工艺时间 = 80;
        public Effect 工艺效果 = Fx.none;
        public Effect 更新效果 = Fx.none;
        public float 更新效果几率 = 0.04f;
        public float 预热速度 = 0.019f;
        public DrawBlock 材质 = new DrawDefault();

        public float 热输出 = 10f;
        public float 预热率 = 0.15f;

        public 出热工厂(String name) {
            super(name);
            super.outputItem = 输入物品;
            super.outputItems = 输入多物品;
            super.outputLiquid = 输入流体;
            super.outputLiquids = 输入多流体;
            super.liquidOutputDirections = 流体输出方向;
            super.dumpExtraLiquid = 删多余液体;
            super.ignoreLiquidFullness = 忽略液体饱满;
            super.craftTime = 工艺时间;
            super.craftEffect = 工艺效果;
            super.updateEffect = 更新效果;
            super.updateEffectChance = 更新效果几率;
            super.warmupSpeed = 预热速度;
            super.drawer = 材质;
            super.heatOutput = 热输出;
            super.warmupRate = 预热率;
        }
        public class 出热工厂Build extends  HeatProducerBuild{}
    }
    public static class 热工厂 extends GenericCrafter {
        public @Nullable ItemStack 输入物品;
        public @Nullable ItemStack[] 输入多物品;
        public @Nullable LiquidStack 输入流体;
        public @Nullable LiquidStack[] 输入多流体;
        public int[] 流体输出方向 = {-1};
        public boolean 删多余液体 = true;
        public boolean 忽略液体饱满 = false;

        public float 工艺时间 = 80;
        public Effect 工艺效果 = Fx.none;
        public Effect 更新效果 = Fx.none;
        public float 更新效果几率 = 0.04f;
        public float 预热速度 = 0.019f;
        public DrawBlock 材质 = new DrawMulti(new DrawDefault(), new DrawHeatOutput());

        public float 热输出 = 10f;
        public float 预热率 = 0.15f;
        public float 热输入 = 10f;
        public float 最大效率 = 4f;
        public 热工厂(String name) {
            super(name);
            super.outputItem = 输入物品;
            super.outputItems = 输入多物品;
            super.outputLiquid = 输入流体;
            super.outputLiquids = 输入多流体;
            super.liquidOutputDirections = 流体输出方向;
            super.dumpExtraLiquid = 删多余液体;
            super.ignoreLiquidFullness = 忽略液体饱满;
            super.craftTime = 工艺时间;
            super.craftEffect = 工艺效果;
            super.updateEffect = 更新效果;
            super.updateEffectChance = 更新效果几率;
            super.warmupSpeed = 预热速度;
            super.drawer = 材质;
            rotateDraw = false;
            rotate = true;
            canOverdrive = false;
            drawArrow = true;
        }
        @Override
        public void setStats(){
            super.setStats();

            stats.add(Stat.output, 热输出, StatUnit.heatUnits);
        }

        @Override
        public void setBars(){
            super.setBars();

            addBar("hedsxfgvat", (热工厂Build entity) -> new Bar("dcgbh", Pal.lightOrange, () -> entity.出热 / 热输出));
        }
        public class 热工厂Build extends  GenericCrafterBuild implements HeatBlock, HeatConsumer {

            public float 出热;
            public float[] 侧热 = new float[4];
            public float 入热 = 0f;
            @Override
            public void updateTile(){
                super.updateTile();
                热热();
            }
            public void 热热(){
                入热 = calculateHeat(侧热);
                出热 = Mathf.approachDelta(出热, 热输出 * efficiency, 预热率 * delta());
                if(出热>0 && 出热>热输入){
                    出热 = 出热 - 热输入;
                }else{
                    入热 = 入热 - 出热;
                    出热 =0;
                }
            }
            @Override
            public float[] sideHeat(){
                return 侧热;
            }
            @Override
            public float heatRequirement(){
                return 热输入;
            }

            @Override
            public float heatFrac(){
                return 出热 / 热输出;
            }
            @Override
            public float heat(){
                return 出热;
            }
            @Override
            public float warmupTarget(){
                return Mathf.clamp(入热 / 热输入);
            }
            @Override
            public float efficiencyScale(){
                return Math.min(Mathf.clamp(入热 / 热输入) , 最大效率);
            }

        }
    }




}
