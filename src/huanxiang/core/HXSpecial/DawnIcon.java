package huanxiang.core.HXSpecial;

import arc.Core;
import arc.graphics.g2d.TextureRegion;
import arc.util.Time;

import java.util.Objects;

/*
public class DawnIcon {
    public String name;
    public int IA;
    public float timer;
    public DawnIcon(String modname){
        name = modname;

        String ModIconS = Core.bundle.format(modname + "-ModIconS");
        if(���Լ��(ModIconS, modname + "-ModIconS")){
            ModIconS = Core.bundle.format(DawnName("ModIconS"));
            name = XVXModName;
        }

        String ModIconT = Core.bundle.format(modname + "-ModIconT");
        if(���Լ��(ModIconT, modname + "-ModIconT")){
            ModIconT = Core.bundle.format(DawnName("ModIconT"));
            name = XVXModName;
        }

        IA = Integer.parseInt(ModIconS);
        timer = Float.parseFloat(ModIconT);
    }

    public static boolean ���Լ��(String ����, String ��ȷ){
        return Objects.equals(����, "???" + ��ȷ + "???");
    }

    int IA2 = 0;
    float T = 0.0f;
    public TextureRegion Icon() {
        TextureRegion[] MyModIcon = new TextureRegion[IA];
        for (int i = 0; i < IA; i++) {
            MyModIcon[i] = Core.atlas.find(name + "-icon" + i);
        }
        T += Time.delta;
        if (T >= timer) {
            T = 0.0f;
            IA2 += 1;
        }
        if (IA2 == IA) {
            IA2 = 0;
        }
        return MyModIcon[IA2];
    }
}
*/