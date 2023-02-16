package huanxiang.core;

import arc.Core;
import arc.graphics.g2d.TextureRegion;
import mindustry.Vars;
import mindustry.ctype.ContentType;
import java.lang.reflect.Array;

public class HXlib {

    public static String modName = "hx";

    public void 方块(String a) {
        Vars.content.getByName(ContentType.block, modName + "-" + a);
    }

    public void 单位(String a) {
        Vars.content.getByName(ContentType.unit, modName + "-" + a);
    }

    public void 流体(String a) {
        Vars.content.getByName(ContentType.liquid, modName + "-" + a);
    }

    public void 物品(String a) {
        Vars.content.getByName(ContentType.item, modName + "-" + a);
    }

    public static TextureRegion 材质(String a) {
        Core.atlas.find(modName + "-" + a, Core.atlas.find("clear"));
        return null;
    }

    public void 翻译(String a, String b) {
        Core.bundle.format(a + "." + modName + "-" + b + ".name");
    }

    public void 翻译(String a, String b, Array c) {
        Core.bundle.format(a + "." + modName + "-" + b + ".name", c);
    }


}
