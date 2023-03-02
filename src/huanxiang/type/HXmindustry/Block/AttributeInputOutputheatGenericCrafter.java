package huanxiang.type.HXmindustry.Block;

import arc.Core;
import arc.math.Mathf;
import arc.util.io.Reads;
import arc.util.io.Writes;
import huanxiang.type.HXmindustry.HXGenericCrafter;
import mindustry.game.Team;
import mindustry.graphics.Pal;
import mindustry.ui.Bar;
import mindustry.world.Tile;
import mindustry.world.blocks.heat.HeatBlock;
import mindustry.world.blocks.heat.HeatConsumer;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawHeatOutput;
import mindustry.world.draw.DrawMulti;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;

public class AttributeInputOutputheatGenericCrafter extends HXGenericCrafter {
    public Attribute attribute = Attribute.heat;//地形标签
    public float baseEfficiency = 1f;//基础效率
    public float boostScale = 1f;//提升规模
    public float maxBoost = 1f;//最大效率
    public float minEfficiency = -1f;//最小效率
    public float displayEfficiencyScale = 1f;//效率倍率
    public boolean displayEfficiency = true;//开关
    //-------------------------//
    public float heatRequirement = 10f;//输入热量
    public float overheatScale = 1f;//过热刻度
    public float maxEfficiency = 4f;//最大效率
    //-------------------------//
    public float heatOutput = 10f;//输出热量
    public float warmupRate = 0.15f;//预热率


    public AttributeInputOutputheatGenericCrafter(String name) {
        super(name);

        drawer = new DrawMulti(new DrawDefault(), new DrawHeatOutput());
        rotateDraw = false;
        rotate = true;
        canOverdrive = false;
        drawArrow = true;
    }


    @Override
    public void drawPlace(int x, int y, int rotation, boolean valid) {
        super.drawPlace(x, y, rotation, valid);

        if (!displayEfficiency) return;

        drawPlaceText(Core.bundle.format("bar.efficiency",
                (int) ((baseEfficiency + Math.min(maxBoost, boostScale * sumAttribute(attribute, x, y))) * 100f)), x, y, valid);
    }

    @Override
    public void setBars() {
        super.setBars();

        if (!displayEfficiency) return;

        addBar("efficiency", (AttributeInputOutputheatGenericCrafter.AttributeInputOutputheatGenericCrafterBuild entity) ->
                new Bar(
                        () -> Core.bundle.format("bar.efficiency", (int) (entity.efficiencyMultiplier() * 100 * displayEfficiencyScale)),
                        () -> Pal.lightOrange,
                        entity::efficiencyMultiplier));
        addBar("heat", (AttributeInputOutputheatGenericCrafter.AttributeInputOutputheatGenericCrafterBuild entity) ->
                new Bar(() ->
                        Core.bundle.format("bar.heatpercent", (int) (entity.heat1 + 0.00001f), (int) (entity.efficiencyScale() * 100 + 0.0001f)),
                        () -> Pal.lightOrange,
                        () -> entity.heat1 / heatRequirement));
        addBar("heat1", (AttributeInputOutputheatGenericCrafter.AttributeInputOutputheatGenericCrafterBuild entity) -> new Bar("bar.heat", Pal.lightOrange, () -> entity.heat / heatOutput));
    }

    @Override
    public boolean canPlaceOn(Tile tile, Team team, int rotation) {
        //make sure there's enough efficiency at this location
        return baseEfficiency + tile.getLinkedTilesAs(this, tempTiles).sumf(other -> other.floor().attributes.get(attribute)) >= minEfficiency;
    }

    @Override
    public void setStats() {
        super.setStats();

        stats.add(baseEfficiency <= 0.0001f ? Stat.tiles : Stat.affinities, attribute, floating, boostScale * size * size, !displayEfficiency);
        stats.add(Stat.input, heatRequirement, StatUnit.heatUnits);
        stats.add(Stat.maxEfficiency, (int) (maxEfficiency * 100f), StatUnit.percent);
        stats.add(Stat.output, heatOutput, StatUnit.heatUnits);
    }

    public class AttributeInputOutputheatGenericCrafterBuild extends GenericCrafterBuild implements HeatBlock, HeatConsumer {
        public float attrsum;
        public float[] sideHeat = new float[4];
        public float heat1 = 0f;
        public float heat;

        @Override
        public void updateTile() {
            heat1 = calculateHeat(sideHeat);

            super.updateTile();
            heat = Mathf.approachDelta(heat, heatOutput * efficiency, warmupRate * delta()) * efficiencyMultiplier();
        }

        @Override
        public float heatFrac() {
            return heat / heatOutput;
        }

        @Override
        public float heat() {
            return heat;
        }

        @Override
        public void write(Writes write) {
            super.write(write);
            write.f(heat);
        }

        @Override
        public void read(Reads read, byte revision) {
            super.read(read, revision);
            heat = read.f();
        }

        @Override
        public float heatRequirement() {
            return heatRequirement;
        }

        @Override
        public float[] sideHeat() {
            return sideHeat;
        }

        @Override
        public float warmupTarget() {
            return Mathf.clamp(heat1 / heatRequirement);
        }

        @Override
        public float efficiencyScale() {
            float over = Math.max(heat1 - heatRequirement, 0f);
            return Math.min(Mathf.clamp(heat1 / heatRequirement) + over / heatRequirement * overheatScale, maxEfficiency);
        }


        @Override
        public float getProgressIncrease(float base) {
            return super.getProgressIncrease(base) * efficiencyMultiplier() * efficiencyScale();
        }

        public float efficiencyMultiplier() {
            return baseEfficiency + Math.min(maxBoost, boostScale * attrsum) + attribute.env();
        }

        @Override
        public void pickedUp() {
            attrsum = 0f;
            warmup = 0f;
        }

        @Override
        public void onProximityUpdate() {
            super.onProximityUpdate();

            attrsum = sumAttribute(attribute, tile.x, tile.y);
        }
    }
}