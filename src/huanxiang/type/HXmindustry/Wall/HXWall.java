package huanxiang.type.HXmindustry.Wall;

import huanxiang.type.HXmindustry.Block.HXBlock;
import mindustry.entities.TargetPriority;
import mindustry.world.meta.BlockGroup;
import mindustry.world.meta.Env;

public class HXWall extends HXBlock {


    public HXWall(String name) {
        super(name);
        solid = true;
        destructible = true;
        group = BlockGroup.walls;
        buildCostMultiplier = 6f;
        canOverdrive = false;
        drawDisabled = false;
        crushDamageMultiplier = 5f;
        priority = TargetPriority.wall;
        envEnabled = Env.any;
    }
}

