package huanxiang;

import arc.struct.ObjectMap;
import mindustry.mod.Mod;

public class HXMOD extends Mod {
    public static final ObjectMap<String, Class<?>> classes = new ObjectMap<>();

    public HXMOD() {
    }
    
    @Override
    public void loadContent() {
    }

    static {
        classes.put("YinYong", huanxiang.YinYong.class);
    }
}
