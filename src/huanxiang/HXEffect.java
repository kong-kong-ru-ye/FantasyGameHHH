package huanxiang;

import arc.Core;
import arc.audio.Sound;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Mathf;
import arc.util.Time;
import mindustry.core.FileTree;
import mindustry.entities.Effect;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;

import huanxiang.HXlib;

public class HXEffect {
    private static final float stroke = 1f;
    public static void 多边形(float 百分比, float x, float y, int 边数, float 半径, float 角度) {
        var p = Mathf.clamp(百分比);
        float space = 360f / 边数;

        float hstep = stroke / 2f / Mathf.cosDeg(space / 2f);

        float r1 = 半径 - hstep, r2 = 半径 + hstep;
        for (int i = 0; i < 边数 * p; i++) {
            float a = space * i + 角度, cos = Mathf.cosDeg(a), sin = Mathf.sinDeg(a), cos2 = Mathf.cosDeg(a + space), sin2 = Mathf.sinDeg(a + space);
            Fill.quad(
                    x + r1 * cos, y + r1 * sin,
                    x + r1 * cos2, y + r1 * sin2,
                    x + r2 * cos2, y + r2 * sin2,
                    x + r2 * cos, y + r2 * sin
            );
        }
    }

    public static void 多边形(float 百分比, float x, float y, float 半径, float 角度) {
        多边形(百分比, x, y, 360, 半径, 角度);
    }

    public static void 加黑多边形(float x, float y, int 边数, float 半径, float 角度, Color 颜色) {
        Lines.stroke(3, Pal.gray);
        Lines.poly(x, y, 边数, 半径, 角度);
        Lines.stroke(3, 颜色);
        Lines.poly(x, y, 边数, 半径, 角度);
        Draw.reset();
    }

    public static void 魔法阵(float x, float y, float 半径, float 角度, Color 颜色) {
        Lines.stroke(1, 颜色);
        Lines.poly(x, y, 120, 半径, 0);
        Lines.poly(x, y, 3, 半径, 角度);
        Lines.poly(x, y, 3, 半径, 角度 + 60);
        Draw.reset();
    }
















    public static Effect 风暴声 = new Effect(35, e -> {
        Sound sound = HXlib.声音("风暴声");
        e.lifetime = 14 + Mathf.randomSeed(e.id, 8);
        float x = Core.camera.position.x;
        float y = Core.camera.position.y;

        if(e.time - Time.delta == 0 && Mathf.chanceDelta(e.lifetime / 24)){
            float mag = Mathf.randomSeed(e.id, 5);

            if(mag > 1) Effect.shake(mag, mag * 2, x, y);

            if(mag > 3.5) sound.play(mag/5);
        }

        Draw.z((float) (Layer.end + 0.01));
        Draw.color(Pal.lancerLaser, Pal.spore, e.fin());
        Draw.alpha(Mathf.randomSeed((long) e.id, (float) 0.8) * e.fout());
        Fill.square(x, y, Core.graphics.getWidth(), Core.graphics.getHeight());
    });


}
