package huanxiang;

import arc.util.io.Reads;
import arc.util.io.Writes;

public class 全局量 {
    public float aaa = 0f;
    public float aab = 0f;
    public float aac = 0f;
    public float aad = 0f;
    public float sdaf = 0f;


    public void write(Writes write) {
        write.f(aaa);

    }

    public void read(Reads read) {
        aaa = read.f();
    }


}
