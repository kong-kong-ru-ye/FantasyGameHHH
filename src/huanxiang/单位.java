package huanxiang;

import arc.scene.ui.layout.Table;
import mindustry.gen.Building;
import mindustry.type.UnitType;
import mindustry.world.blocks.liquid.LiquidBridge;

public class 单位 extends UnitType {
    public 单位(String name) {
        super(name);
    }



    public class 单位Build extends Building {
        @Override
        public void buildConfiguration(Table table) {
        }
        @Override
        public boolean onConfigureBuildTapped(Building other) {
            if (this.block.clearOnDoubleTap) {
                if (this == other) {
                    this.deselect();
                    this.configure((Object)null);
                    return false;
                } else {
                    return true;
                }
            } else {
                return this != other;
            }
        }








    }

}
