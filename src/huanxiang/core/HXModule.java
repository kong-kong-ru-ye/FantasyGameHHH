package huanxiang.core;


import mindustry.world.modules.BlockModule;

import static mindustry.Vars.content;

public abstract class HXModule extends BlockModule {
    private float[] Blocks = new float[content.blocks().size];
    private float[] UnitTypes = new float[content.units().size];


}
