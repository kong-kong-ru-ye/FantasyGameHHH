package huanxiang.type;

import arc.graphics.Color;

import static arc.graphics.Color.valueOf;

public class HXColor {
    public static String hxcolor(Color a){
        return "[#" + a + "]";
    }

    public static String DawnColorText(String name, Color Color){
        return hxcolor(Color) + name + "[]";
    }


    public static Color cyan = Color.valueOf("00FFFF");


}
