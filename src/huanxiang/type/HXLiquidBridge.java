package huanxiang.type;

import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Lines;
import arc.math.Mathf;
import arc.util.Time;
import huanxiang.core.HXEffect;
import huanxiang.core.HXlib;
import mindustry.Vars;
import mindustry.gen.Building;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;
import mindustry.world.Tile;
import mindustry.world.blocks.distribution.ItemBridge;
import mindustry.world.blocks.liquid.LiquidBridge;

import java.util.Objects;

public class HXLiquidBridge extends LiquidBridge {
    public String 材质名称 = "";

    public HXLiquidBridge(String name) {
        super(name);
    }


    @Override
    public void drawPlace(int x, int y, int rotation, boolean valid) {
        Drawf.dashCircle(x* Vars.tilesize,y* Vars.tilesize,range* Vars.tilesize, Pal.accent);
    }

    @Override
    public boolean linkValid(Tile tile, Tile other, boolean checkDouble) {
        if (other == null || tile == null || other == tile) return false;
        if (Math.pow(other.x - tile.x, 2) + Math.pow(other.y - tile.y, 2) > Math.pow(range + 0.5, 2)) return false;
        return ((other.block() == tile.block() && tile.block() == this) || (!(tile.block() instanceof ItemBridge) && other.block() == this)) && (other.team() == tile.team() || tile.block() != this) && (!checkDouble || ((LiquidBridgeBuild)other.build).link != tile.pos());
    }

    public class HXLiquidBridgeBuild extends LiquidBridgeBuild{
        public float sin;

        @Override
        public void drawConfigure() {
            sin = Mathf.absin(Time.time, 6, 1);
            Draw.color(Pal.accent);
            Lines.stroke(1);
            Building other = Vars.world.build(this.link);
            if (other != null) {
                HXEffect.魔法阵 (other.x, other.y, (range / 4) * Vars.tilesize + sin - 2, Time.time, Pal.place);
                Draw.alpha(0.5F);
                HXEffect.魔法阵 (this.x, this.y, range * Vars.tilesize + sin - 2, -Time.time, Pal.accent);
            } else {
                Drawf.dashCircle(this.x, this.y, range * Vars.tilesize, Pal.accent);
            };

        }


        public void  draw() {
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
