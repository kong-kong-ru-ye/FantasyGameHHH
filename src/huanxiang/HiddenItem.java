package huanxiang.type;


import arc.graphics.Color;
import mindustry.type.Item;

public class HiddenItem extends Item {
    public HiddenItem(String name, Color color){
        super(name, color);
    }
    public HiddenItem(String name) {
        super(name);
    }

    @Override
    public boolean unlockedNow(){
        return false;
    }

    @Override
    public boolean unlockedNowHost(){
        return false;
    }
}
