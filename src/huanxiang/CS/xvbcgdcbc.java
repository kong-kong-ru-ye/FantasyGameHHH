package huanxiang.CS;

import arc.Core;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import huanxiang.type.HXmindustry.Wall.HXWall;
import mindustry.world.blocks.defense.Wall;


public class xvbcgdcbc extends Wall {
    public TextureRegion[] states;

    public int stateNumber;

    public xvbcgdcbc(String name) {
        super(name);
    }

    @Override
    public void load() {
        super.load();    //调用父类的load()方法
        states = new TextureRegion[stateNumber];
        for (int i = 0; i < stateNumber; i++) {
            // name 是 Block 的注册名
            states[i] = Core.atlas.find(name + "-" + i);
        }
    }

    public class xvbcgdcbcBuild extends WallBuild {
        @Override
        public void draw() {
            states = new TextureRegion[stateNumber];
            for (int i = 0; i < stateNumber; i++) {
                // name 是 Block 的注册名
                states[i] = Core.atlas.find(name + "-" + i);
            }
            // 将已损失生命值的百分比映射到 [0,stateNumber] 之间
            // 访问了外部类的 stateNumber 字段
            int curIndex = (int) (lostHealthPct() * stateNumber);
            // 加上这行代码，防止 curIndex 意外地超过数组的长度
            curIndex = Math.min(curIndex, stateNumber - 1);
            // 绘制一块矩形贴图，位于世界坐标的x y(这里用的是当前方块实体的xy)
            Draw.rect(states[curIndex], x, y);
            // 绘制队伍的角标
            this.drawTeamTop();
        }


        // 获取已损失生命值的百分比
        public float lostHealthPct() {
            return 1f - health / maxHealth;
        }


    }


}

