package huanxiang.type.HXmindustry.Block;


import arc.audio.Sound;
import arc.graphics.Blending;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.math.Mathf;
import arc.util.Time;
import arc.util.io.Reads;
import arc.util.io.Writes;
import huanxiang.core.HXPayloads.HXConsumePayloads;
import mindustry.entities.Lightning;
import mindustry.gen.Building;
import mindustry.gen.Bullet;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.Item;
import mindustry.type.PayloadStack;
import mindustry.ui.Bar;
import mindustry.world.Block;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;

import static mindustry.Vars.state;
import static mindustry.Vars.tilesize;





public class HXBlock extends Block {


    public static boolean 无敌 = false;

    public static boolean 生命共享 = false;
    public static float 本身余量 = 1;
    public static float 转换加 = 1;
    public static float 转换减 = 1;


    public static boolean 次数盾吗 = false;
    public static boolean 可回复次数盾 = false;
    public static float 次数盾回复时间 = 16f * 10f;
    public static float 回复次数盾数 = 1;
    public static float 次数盾 = 100;


    public static boolean 护盾吗 = false;
    public static boolean 可回复护盾 = false;
    public static float 护盾回复时间 = 16f * 10f;
    public static float 回复护盾数 = 1;
    public static float 回复护盾强度 = 100;
    public static float 护盾数 = 100;
    public static float 护盾强度 = 1000;

    public static float 护甲= 0f;

    /**
     * -1 禁用
     */

    public static float 闪电几率 = -1f;
    public static float 闪电伤害 = 20f;
    public static int 闪电长度 = 17;
    public static Color 闪电颜色 = Pal.surge;
    public static Sound 闪电声音 = Sounds.spark;

    /**
     * -1 禁用
     */
    public static float 反射概率 = -1f;
    public static boolean 反射命中;
    public static Color 反射颜色 = Color.white;
    public static Sound 反射声音 = Sounds.none;


    public boolean 绝缘 = true;
    public boolean 吸收激光 = false;



    public HXBlock(String name) {
        super(name);
        insulated = 绝缘;
        absorbLasers = 吸收激光;
    }

    public HXConsumePayloads huanxiangconsumepayloads(Item item, int amount) {
        return consume(new HXConsumePayloads(new PayloadStack[]{new PayloadStack(item, amount)}));
    }

    public HXConsumePayloads huanxiangconsumepayloads(PayloadStack... items) {
        return consume(new HXConsumePayloads(items));
    }

    @Override
    public void setBars() {
        super.setBars();
        if (无敌) {
            addBar("aaa", (BlockBuild e) -> new Bar("当前已开启无敌", Pal.lightOrange, () -> 1));
        } else {
            if (次数盾吗 && !护盾吗) {
                addBar("aa", (BlockBuild e) -> new Bar("次数盾", Pal.lightOrange, () -> e.aaa / 次数盾));
            }
            if (护盾吗 && !次数盾吗) {
                addBar("ab", (BlockBuild e) -> new Bar("护盾数", Pal.lightOrange, () -> e.aba / 护盾数));
                addBar("ac", (BlockBuild e) -> new Bar("护盾强度", Pal.lightOrange, () -> e.abb / 护盾强度));
            }
        }
//        addBar("dhfgcxvbcxbdcb", (HXCiShuWall.HXCiShuWallBuild cbv) -> new Bar("次数盾极限" + cbv.a, Pal.lightOrange, () -> cbv.a / 次数盾强度));
//        /*
//        addBar("heat", (HeatCrafterBuild entity) ->
//            new Bar(() ->
//            Core.bundle.format("bar.heatpercent", (int)(entity.heat + 0.00001f), (int)(entity.efficiencyScale() * 100 + 0.0001f)),
//            () -> Pal.lightOrange,
//            () -> entity.heat / heatRequirement));
//        */

    }
    @Override
    public void setStats() {
        super.setStats();

        if (反射概率 > 0f) stats.add(Stat.baseDeflectChance, 反射概率, StatUnit.none);
        if (闪电几率 > 0f) {
            stats.add(Stat.lightningChance, 闪电几率 * 100f, StatUnit.percent);
            stats.add(Stat.lightningDamage, 闪电伤害, StatUnit.none);
        }
    }

    public class BlockBuild extends Building {
        public float aaa = 次数盾;
        public float aab = 次数盾回复时间;
        public float aba = 护盾数;
        public float abb = 护盾强度;
        public float abc = 护盾回复时间;
        public float hit;
        @Override
        public void updateTile() {
            super.updateTile();
            if (生命共享) {
                生命共享();
            }
        }
        @Override
        public void draw() {
            super.draw();

            //draw flashing white overlay if enabled
            if (反射命中) {
                if (hit < 0.0001f) return;

                Draw.color(反射颜色);
                Draw.alpha(hit * 0.5f);
                Draw.blend(Blending.additive);
                Fill.rect(x, y, tilesize * size, tilesize * size);
                Draw.blend();
                Draw.reset();

                if (!state.isPaused()) {
                    hit = Mathf.clamp(hit - Time.delta / 10f);
                }
            }
        }
        @Override
        public void damage(float damage) {
            if (无敌) {
            } else {
                if (次数盾吗 && !护盾吗) {
                    if (次数盾(aaa, damage)) {
                        super.damage(damage*护甲());
                    }
                }else {
                    super.damage(damage*护甲());
                }
                if (护盾吗 && !次数盾吗) {
                    if (护盾(aba, abb, damage)) {
                        super.damage(damage*护甲());
                    }
                }else {
                    super.damage(damage*护甲());
                }
            }

        }
        @Override
        public boolean collision(Bullet bullet) {
            super.collision(bullet);

            hit = 1f;

            //create lightning if necessary
            if (闪电几率 > 0f) {
                if (Mathf.chance(闪电几率)) {
                    Lightning.create(team, 闪电颜色, 闪电伤害, x, y, bullet.rotation() + 180f, 闪电长度);
                    闪电声音.at(tile, Mathf.random(0.9f, 1.1f));
                }
            }

            //deflect bullets if necessary
            if (反射概率 > 0f) {
                //slow bullets are not deflected
                if (bullet.vel.len() <= 0.1f || !bullet.type.reflectable) return true;

                //bullet reflection chance depends on bullet damage
                if (!Mathf.chance(反射概率 / bullet.damage())) return true;

                //make sound
                反射声音.at(tile, Mathf.random(0.9f, 1.1f));

                //translate bullet back to where it was upon collision
                bullet.trns(-bullet.vel.x, -bullet.vel.y);

                float penX = Math.abs(x - bullet.x), penY = Math.abs(y - bullet.y);

                if (penX > penY) {
                    bullet.vel.x *= -1;
                } else {
                    bullet.vel.y *= -1;
                }

                bullet.owner = this;
                bullet.team = team;
                bullet.time += 1f;

                //disable bullet collision by returning false
                return false;
            }

            return true;
        }

        @Override
        public void write(Writes write) {
            super.write(write);
            write.f(aaa);
            write.f(aab);
            write.f(aba);
            write.f(abb);
            write.f(abc);
        }

        @Override
        public void read(Reads read, byte revision) {
            super.read(read, revision);
            aaa = read.f();
            aab = read.f();
            aba = read.f();
            abb = read.f();
            abc = read.f();

        }




        public float 护甲() {
            if(护甲>0){
                if(护甲>1000) {return 0f;}
                    if(护甲>500){return (0.3f-(护甲-500f)*(0.2f/500f));}
                        if(护甲>100){return (0.6f-(护甲-100f)*(0.3f/100f));}
                          return 1-护甲*0.004f;
            }
            return 1f;
        }


        public boolean 次数盾(float a, float b) {
            if (b > 0) a -= 1;
            if (可回复次数盾) {
                final boolean b1 = this.health == this.maxHealth;
                if (b1) {
                    if (aab > 0) {
                        aab -= Time.delta;
                    } else {
                        aaaaa(a, 次数盾, 回复次数盾数);
                        aab = 次数盾回复时间;
                    }
                }
            }
            final boolean b1 = a < 1;
            return b1;
        }

        public boolean 护盾(float a, float b, float c) {
            if (c > 0) b -= c;
            if (b < 0) {
                b = 护盾强度;
                a -= 1;
            }
            if (可回复护盾) {
                final boolean b1 = this.health == this.maxHealth;
                if (b1) {
                    if (abc > 0) {
                        abc -= Time.delta;
                    } else {
                        aaaaa(a, 护盾数, 回复护盾数);
                        aaaaa(b, 护盾强度, 回复护盾强度);
                        abc = 护盾回复时间;
                    }
                }
            }
            final boolean b1 = a < 1;

            return b1;
        }

        public void aaaaa(float a, float b, float c) {
            if (a < b) {
                a += c;
                if (a > b) {
                    a = b;
                }
            }
        }

        public void 生命共享() {
            for (Building 附近的方块 : this.proximity) {
                if (附近的方块.block != this.block)
                    continue;
                float 本身的血量 = this.health;
                float 附近方块的血量 = 附近的方块.health;
                if (本身余量 < this.maxHealth && 本身的血量 > 附近方块的血量 && 本身的血量 > 本身余量 + 转换减 && 附近方块的血量 < 附近的方块.maxHealth) {
                    附近的方块.health += 转换加;
                    this.health -= 转换减;
                }
            }

        }
    }


}

