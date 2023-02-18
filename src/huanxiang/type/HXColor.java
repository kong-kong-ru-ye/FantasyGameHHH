package huanxiang.type;

import arc.graphics.Color;

import static arc.graphics.Color.valueOf;

public class HXColor {
    public static String HXColor(Color Color){
        return "[#" + Color + "]";
    }

    public static String DawnColorText(String name, Color Color){
        return HXColor(Color) + name + "[]";
    }


    public static Color cyan = Color.valueOf("00FFFF");


}
