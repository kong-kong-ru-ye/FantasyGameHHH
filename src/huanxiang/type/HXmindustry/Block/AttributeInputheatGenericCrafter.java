package huanxiang.type.HXmindustry.Block;

import arc.Core;
import arc.math.Mathf;
import huanxiang.type.HXmindustry.HXGenericCrafter;
import mindustry.game.Team;
import mindustry.graphics.Pal;
import mindustry.ui.Bar;
import mindustry.world.Tile;
import mindustry.world.blocks.heat.HeatConsumer;
import mindustry.world.meta.*;

public class AttributeInputheatGenericCrafter extends HXGenericCrafter {
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

    public AttributeInputheatGenericCrafter(String name) {
        super(name);
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

        if (!displayEfficiency)
            return;
        addBar("efficiency", (AttributeInputheatGenericCrafter.AttributeInputheatGenericCrafterBuild entity) ->
                new Bar(
                        () -> Core.bundle.format("bar.efficiency", (int) (entity.efficiencyMultiplier() * 100 * displayEfficiencyScale)),
                        () -> Pal.lightOrange,
                        entity::efficiencyMultiplier));

        addBar("heat", (AttributeInputheatGenericCrafter.AttributeInputheatGenericCrafterBuild entity) ->
                new Bar(() ->
                        Core.bundle.format("bar.heatpercent", (int) (entity.heat + 0.00001f), (int) (entity.efficiencyScale() * 100 + 0.0001f)),
                        () -> Pal.lightOrange,
                        () -> entity.heat / heatRequirement));
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
    }

    public class AttributeInputheatGenericCrafterBuild extends GenericCrafterBuild implements HeatConsumer {
        public float attrsum;
        public float[] sideHeat = new float[4];
        public float heat = 0f;


        @Override
        public void updateTile() {
            heat = calculateHeat(sideHeat);
            super.updateTile();
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
            return Mathf.clamp(heat / heatRequirement);
        }

        @Override
        public float efficiencyScale() {
            float over = Math.max(heat - heatRequirement, 0f);
            return Math.min(Mathf.clamp(heat / heatRequirement) + over / heatRequirement * overheatScale, maxEfficiency);
        }
    }
}

