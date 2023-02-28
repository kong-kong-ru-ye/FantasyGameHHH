package huanxiang.core;

import mindustry.world.Block;
import mindustry.world.Tile;

public class HXTile extends Tile {

    public HXTile(int x, int y) {
        super(x, y);
    }

    public HXTile(int x, int y, Block floor, Block overlay, Block wall) {
        super(x, y, floor, overlay, wall);
    }

    /**
     * 将此磁贴的位置作为压缩点返回
     */
    public int hxpos() {
        return pos();
    }


}
