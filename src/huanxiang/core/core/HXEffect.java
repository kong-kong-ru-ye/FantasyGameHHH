package huanxiang.core;

import arc.graphics.g2d.Fill;
import arc.math.Mathf;

public class HXEffect {
    private static final float stroke = 1f;

    /*
    Draw.alpha(0～1); //透明度
    Draw.blend(Blending.additive); //混合
    Draw.z(Layer.effect); //涂层层数?
    Draw.rect(材质名称, this.x, this.y, 宽 ? , 高 ? , 角度);
    Draw.alpha();
    Draw.blend();
    Draw.reset();

    Lines.poly(X, Y, 边数, 半径 (8: 1), 角度); //多边形
    {
        {
            Lines.rect(x, y, width, height, xspace, yspace);
            Lines.rect(x, y, width, height);
            Lines.rect(rect);
            Lines.rect(x, y, width, height, space);
        }; {
            Lines.stroke(thick); //线条宽度
            Lines.stroke(thick, color); //线条宽度-颜色
        }
    }
    */
    public static void poly(float aa, float x, float y, int sides, float radius, float angle) {
        var p = Mathf.clamp(aa);
        float space = 360f / sides;

        float hstep = stroke / 2f / Mathf.cosDeg(space / 2f);
        float r1 = radius - hstep, r2 = radius + hstep;
        for (int i = 0; i < sides * p; i++) {
            float a = space * i + angle, cos = Mathf.cosDeg(a), sin = Mathf.sinDeg(a), cos2 = Mathf.cosDeg(a + space), sin2 = Mathf.sinDeg(a + space);
            Fill.quad(
                    x + r1 * cos, y + r1 * sin,
                    x + r1 * cos2, y + r1 * sin2,
                    x + r2 * cos2, y + r2 * sin2,
                    x + r2 * cos, y + r2 * sin
            );
        }
    }


}
