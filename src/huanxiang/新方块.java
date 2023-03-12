package huanxiang;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Lines;
import arc.math.Mathf;
import arc.util.Nullable;
import arc.util.Time;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.gen.Building;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;
import mindustry.type.Item;
import mindustry.type.ItemStack;
import mindustry.type.Liquid;
import mindustry.type.LiquidStack;
import mindustry.ui.Bar;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.distribution.ItemBridge;
import mindustry.world.blocks.heat.HeatBlock;
import mindustry.world.blocks.heat.HeatConsumer;
import mindustry.world.blocks.liquid.LiquidBridge;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.draw.DrawBlock;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawHeatOutput;
import mindustry.world.draw.DrawMulti;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;

public class 新方块 {


    public static class 超级源 extends Block {
        public 超级源(String name) {
            super(name);
            hasItems = true;
            update = true;
            solid = true;
            hasLiquids = true;
            liquidCapacity = 100f;
            outputsLiquid = true;
            noUpdateDisabled = true;
            displayFlow = false;
            clearOnDoubleTap = true;
        }
        @Override
        public void setBars(){
            super.setBars();
            removeBar("items");
            removeBar("liquid");
        }
        public class 外挂源Build extends Building {
            @Override
            public void updateTile() {
                super.updateTile();
                for (final Building building : this.proximity) {
                    for (final Item item : Vars.content.items()) {
                        if (building.acceptItem((Building)this, item) && building.items.get(item) < building.block.itemCapacity) {
                            building.items.add(item, 1);
                        }
                    }
                    for (final Liquid liquid : Vars.content.liquids()) {
                        if (building.acceptLiquid((Building)this, liquid) && building.liquids.get(liquid) < building.block.liquidCapacity) {
                            building.liquids.add(liquid, 1);
                        }
                    }
                }
            }
            public void draw() {
                Draw.rect(this.block.region, this.x, this.y, this.drawrot());
                final Color color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
                color.fromHsv(Time.globalTime * 3.0f % 360.0f, 1.0f, 1.0f);
                Draw.color(color);
                Draw.rect("center", this.x, this.y);
                Draw.color();
            }


        }


    }


    public static class 流体节点 extends LiquidBridge {
        public @Nullable String 材质名称;

        public 流体节点(String name) {
            super(name);
        }


        @Override
        public void drawPlace(int x, int y, int rotation, boolean valid) {
            Drawf.dashCircle(x * Vars.tilesize, y * Vars.tilesize, range * Vars.tilesize, Pal.accent);
        }

        @Override
        public boolean linkValid(Tile tile, Tile other, boolean checkDouble) {
            if (other == null || tile == null || other == tile) return false;
            if (Math.pow(other.x - tile.x, 2) + Math.pow(other.y - tile.y, 2) > Math.pow(range + 0.5, 2)) return false;
            return ((other.block() == tile.block() && tile.block() == this) || (!(tile.block() instanceof ItemBridge) && other.block() == this)) && (other.team() == tile.team() || tile.block() != this) && (!checkDouble || ((LiquidBridgeBuild) other.build).link != tile.pos());
        }

        public class HXLiquidBridgeBuild extends LiquidBridgeBuild {
            public float sin;

            @Override
            public void drawConfigure() {
                sin = Mathf.absin(Time.time, 6, 1);
                Draw.color(Pal.accent);
                Lines.stroke(1);
                Building other = Vars.world.build(this.link);
                if (other != null) {
                    HXEffect.魔法阵(other.x, other.y, (range / 4) * Vars.tilesize + sin - 2, Time.time, Pal.place);
                    Draw.alpha(0.5F);
                    HXEffect.魔法阵(this.x, this.y, range * Vars.tilesize + sin - 2, -Time.time, Pal.accent);
                } else {
                    Drawf.dashCircle(this.x, this.y, range * Vars.tilesize, Pal.accent);
                }

            }


            public void draw() {
                Draw.rect(HXlib.材质(材质名称), this.x, this.y);
            }

            public boolean acceptItem() {
                return this.items.total() < this.block.itemCapacity;
            }

            public boolean checkDump() {
                return true;
            }


        }


        public static class 物品节点 extends ItemBridge {
            public @Nullable String 材质名称;

            public 物品节点(String name) {
                super(name);
            }

            @Override
            public void drawPlace(int x, int y, int rotation, boolean valid) {
                Drawf.dashCircle(x * Vars.tilesize, y * Vars.tilesize, range * Vars.tilesize, Pal.accent);
            }

            @Override
            public boolean linkValid(Tile tile, Tile other, boolean checkDouble) {
                if (other == null || tile == null || other == tile) return false;
                if (Math.pow(other.x - tile.x, 2) + Math.pow(other.y - tile.y, 2) > Math.pow(range + 0.5, 2))
                    return false;
                return ((other.block() == tile.block() && tile.block() == this) || (!(tile.block() instanceof ItemBridge) && other.block() == this)) && (other.team() == tile.team() || tile.block() != this) && (!checkDouble || ((ItemBridgeBuild) other.build).link != tile.pos());
            }

            public class 热工厂 extends GenericCrafter {
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
                public void setStats() {
                    super.setStats();

                    stats.add(Stat.output, 热输出, StatUnit.heatUnits);
                }

                @Override
                public void setBars() {
                    super.setBars();

                    addBar("hedsxfgvat", (热工厂Build entity) -> new Bar("dcgbh", Pal.lightOrange, () -> entity.出热 / 热输出));
                }

                public class 热工厂Build extends GenericCrafterBuild implements HeatBlock, HeatConsumer {

                    public float 出热;
                    public float[] 侧热 = new float[4];
                    public float 入热 = 0f;

                    @Override
                    public void updateTile() {
                        super.updateTile();
                        热热();
                    }

                    public void 热热() {
                        入热 = calculateHeat(侧热);
                        出热 = Mathf.approachDelta(出热, 热输出 * efficiency, 预热率 * delta());
                        if (出热 > 0 && 出热 > 热输入) {
                            出热 = 出热 - 热输入;
                        } else {
                            入热 = 入热 - 出热;
                            出热 = 0;
                        }
                    }

                    @Override
                    public float[] sideHeat() {
                        return 侧热;
                    }

                    @Override
                    public float heatRequirement() {
                        return 热输入;
                    }

                    @Override
                    public float heatFrac() {
                        return 出热 / 热输出;
                    }

                    @Override
                    public float heat() {
                        return 出热;
                    }

                    @Override
                    public float warmupTarget() {
                        return Mathf.clamp(入热 / 热输入);
                    }

                    @Override
                    public float efficiencyScale() {
                        return Math.min(Mathf.clamp(入热 / 热输入), 最大效率);
                    }

                }
            }

            public class HXItemBridgeBuild extends ItemBridgeBuild {
                public float sin;

                @Override
                public void drawConfigure() {
                    sin = Mathf.absin(Time.time, 6, 1);
                    Draw.color(Pal.accent);
                    Lines.stroke(1);
                    Building other = Vars.world.build(this.link);
                    if (other != null) {
                        HXEffect.魔法阵(other.x, other.y, (range / 4) * Vars.tilesize + sin - 2, Time.time, Pal.place);
                        Draw.alpha(0.5F);
                        HXEffect.魔法阵(this.x, this.y, range * Vars.tilesize + sin - 2, -Time.time, Pal.accent);
                    } else {
                        Drawf.dashCircle(this.x, this.y, range * Vars.tilesize, Pal.accent);
                    }

                }


                public void draw() {
                    Draw.rect(HXlib.材质(材质名称), this.x, this.y);
                }

                public boolean acceptItem() {
                    return this.items.total() < this.block.itemCapacity;
                }

                public boolean checkDump() {
                    return true;
                }


            }
        }
    }
}