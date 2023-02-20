package huanxiang.type;

import arc.graphics.Color;
import mindustry.type.Item;

/*隐藏的物品*/
public class HiddenItem extends Item {
    public static boolean 解锁 = false;
    public static boolean 真锁 = false;
    public static boolean 属性 = true;

    public HiddenItem(String name, Color color) {
        super(name, color);
    }

    public HiddenItem(String name) {
        super(name);
    }

    //真锁--> isHidden() { return 真锁 }
    public HiddenItem(String name, Color color, boolean 真锁) {
        super(name, color);
        this.hidden = 真锁;
    }

    public HiddenItem(String name, boolean 真锁) {
        super(name);
        this.hidden = 真锁;
    }

    @Override
    public boolean unlockedNow() {
        return 解锁;
    }

    @Override
    public boolean unlockedNowHost() {
        return 解锁;
    }

    @Override
    public boolean isHidden() {
        return 真锁;
    }

    @Override
    public void setStats() {
        if (属性) {
            super.setStats();
        }

    }
}