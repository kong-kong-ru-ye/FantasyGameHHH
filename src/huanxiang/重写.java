package huanxiang;

import arc.graphics.Color;
import arc.struct.ObjectSet;
import arc.util.Nullable;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.Effect;
import mindustry.entities.abilities.*;
import mindustry.type.*;

public class 重写 {


    //物品
    public static class 物品 extends Item {
        public static boolean 解锁 = false;
        public static boolean 属性 = true;
        public Color 颜色;
        public float 爆炸性 = 0f;
        public float 燃烧性 = 0f;
        public float 放射性;
        public float 放电性 = 0f;
        public int 挖掘等级 = 0;
        public float 建筑时间成本 = 1f;
        public float 建筑生命倍率 = 0f;
        public boolean 优先级;
        /**
         * 如果为 true，则此项目的优先级最低
         **/
        public int 材质数量 = 0;
        public int 过渡帧 = 0;
        public float 材质帧 = 5f;
        /**
         * 如果为真，则建筑物使用此材料。如果假，该材料将在某些岩心中被焚烧.
         */
        public boolean 建筑 = true;
        public boolean 隐藏 = false;
        /**
         * 将此物品添加到列出的行星的隐藏物品序列中
         */
        public @Nullable Planet[] 行星隐藏;

        public 物品(String name) {
            super(name);
            super.color = 颜色;
            super.explosiveness = 爆炸性;
            super.flammability = 燃烧性;
            super.radioactivity = 放射性;
            super.charge = 放电性;
            super.hardness = 挖掘等级;
            super.cost = 建筑时间成本;
            super.healthScaling = 建筑生命倍率;
            super.lowPriority = 优先级;
            super.frames = 材质数量;
            super.transitionFrames = 过渡帧;
            super.frameTime = 材质帧;
            super.buildable = 建筑;
            super.hidden = 隐藏;
            super.hiddenOnPlanets = 行星隐藏;
        }

        public 物品(String name, Color color) {
            super(name, color);
            super.color = 颜色;
            super.explosiveness = 爆炸性;
            super.flammability = 燃烧性;
            super.radioactivity = 放射性;
            super.charge = 放电性;
            super.hardness = 挖掘等级;
            super.cost = 建筑时间成本;
            super.healthScaling = 建筑生命倍率;
            super.lowPriority = 优先级;
            super.frames = 材质数量;
            super.transitionFrames = 过渡帧;
            super.frameTime = 材质帧;
            super.buildable = 建筑;
            super.hidden = 隐藏;
            super.hiddenOnPlanets = 行星隐藏;
        }

        @Override
        public boolean unlockedNow() {
            return 解锁;
        }

        @Override
        public boolean unlockedNowHost() {
            return 解锁;
        }

        @Override
        public void setStats() {
            if (属性) {
                super.setStats();
            }

        }
    }

    //流体
    public static class 流体 extends Liquid {
        public static boolean 解锁 = false;
        public static boolean 属性 = true;
        public boolean 气体 = false;
        public Color 基础颜色;
        public Color 气体颜色 = Color.lightGray.cpy();
        public @Nullable Color bar颜色;
        public Color 发光颜色 = Color.clear.cpy();
        public float 燃烧性;
        public float 温度 = 0.5f;
        public float 热容量 = 0.5f;
        public float 粘度 = 0.5f;
        public float 爆炸性;
        public boolean 块反应 = true;
        public boolean 冷却液 = true;
        public boolean 方块中移动 = false;
        public boolean 可焚烧 = true;
        public StatusEffect 状态 = StatusEffects.none;
        public Effect 流水效果 = Fx.none;
        public float 粒子效应速率间距 = 60f;
        public float 蒸发温度 = 2f;
        public boolean 流水上限 = true;
        public Effect 液体蒸发效果 = Fx.vapor;
        public boolean 隐藏;
        public ObjectSet<Liquid> 可停留液体 = new ObjectSet<>();


        public 流体(String name) {
            super(name);
            super.gas = 气体;
            super.color = 基础颜色;
            super.gasColor = 气体颜色;
            super.barColor = bar颜色;
            super.lightColor = 发光颜色;
            super.flammability = 燃烧性;
            super.temperature = 温度;
            super.heatCapacity = 热容量;
            super.viscosity = 粘度;
            super.explosiveness = 爆炸性;
            super.blockReactive = 块反应;
            super.coolant = 冷却液;
            super.moveThroughBlocks = 方块中移动;
            super.incinerable = 可焚烧;
            super.effect = 状态;
            super.particleEffect = 流水效果;
            super.particleSpacing = 粒子效应速率间距;
            super.boilPoint = 蒸发温度;
            super.capPuddles = 流水上限;
            super.vaporEffect = 液体蒸发效果;
            super.hidden = 隐藏;
            super.canStayOn = 可停留液体;
        }

        public 流体(String name, Color color) {
            super(name, color);
            super.gas = 气体;
            super.color = 基础颜色;
            super.gasColor = 气体颜色;
            super.barColor = bar颜色;
            super.lightColor = 发光颜色;
            super.flammability = 燃烧性;
            super.temperature = 温度;
            super.heatCapacity = 热容量;
            super.viscosity = 粘度;
            super.explosiveness = 爆炸性;
            super.blockReactive = 块反应;
            super.coolant = 冷却液;
            super.moveThroughBlocks = 方块中移动;
            super.incinerable = 可焚烧;
            super.effect = 状态;
            super.particleEffect = 流水效果;
            super.particleSpacing = 粒子效应速率间距;
            super.boilPoint = 蒸发温度;
            super.capPuddles = 流水上限;
            super.vaporEffect = 液体蒸发效果;
            super.hidden = 隐藏;
            super.canStayOn = 可停留液体;
        }

        @Override
        public boolean unlockedNow() {
            return 解锁;
        }

        @Override
        public boolean unlockedNowHost() {
            return 解锁;
        }

        @Override
        public void setStats() {
            if (属性) {
                super.setStats();
            }

        }
    }

    //能力
    public static class 能力 {
        public static class 单位生成 extends UnitSpawnAbility {
            public 单位生成(UnitType 单位, float 冷却时间, float x, float y) {
                super(单位, 冷却时间, x, y);
            }

        }

        public static class 修复抑制场 extends SuppressionFieldAbility {
            public float 重新加载 = 60f * 1.5f;
            public float 半径 = 200f;
            public float x = 0f, y = 0f;

            public 修复抑制场() {
                super();
            }

            public 修复抑制场(float 冷却时间, float 半径) {
                super();
                super.reload = 冷却时间;
                super.range = 半径;
                super.x = x;
                super.y = y;
            }
        }

        public static class 状态场 extends StatusFieldAbility {
            public StatusEffect 状态;
            public float 状态持续时间 = 60, 冷却时间 = 100, 范围 = 20;
            public boolean 攻击中使用 = false;
            public Effect 应用效果 = Fx.none;
            public Effect 主动效果 = Fx.overdriveWave;
            public float 效果X, 效果Y;
            public boolean 产兵效果, 效果大小参数 = true;

            public 状态场(StatusEffect 状态, float 状态持续时间, float 冷却时间, float 范围) {
                super(状态, 状态持续时间, 冷却时间, 范围);
                super.onShoot = 攻击中使用;
                super.applyEffect = 应用效果;
                super.activeEffect = 主动效果;
                super.effectX = 效果X;
                super.effectY = 效果Y;
                super.parentizeEffects = 产兵效果;
                super.effectSizeParam = 效果大小参数;
            }
        }

        public static class 死亡单位生成 extends SpawnDeathAbility {
            public 死亡单位生成(UnitType 单位, int 数量, float 生成范围) {
                super(单位, 数量, 生成范围);
            }

            public 死亡单位生成(UnitType 单位, int 数量, int 边缘数量, float 生成范围) {
                super(单位, 数量, 生成范围);
                super.randAmount = 边缘数量;

            }

        }

        public static class 护盾再生场 extends ShieldRegenFieldAbility {
            public 护盾再生场(float 回复量, float max, float 冷却时间, float 范围) {
                super(回复量, max, 冷却时间, 范围);
            }

        }

        public static class 弧形护盾 extends ShieldArcAbility {
            public float 半径 = 60f;
            public float 再生 = 0.1f;
            public float 最大 = 200f;
            public float 冷却时间 = 60f * 5;
            public float 角度 = 80f;
            public float 角度偏移 = 0f, x = 0f, y = 0f;
            public boolean 攻击激活 = true;
            public float 宽 = 6f;
            public boolean 绘制弧形 = true;
            public @Nullable String 贴图;
            public boolean 贴图跟随xy = false;
            protected float 宽度缩放, 透明度;

            public 弧形护盾() {
                super.radius = 半径;
                super.regen = 再生;
                super.max = 最大;
                super.cooldown = 冷却时间;
                super.angle = 角度;
                super.angleOffset = 角度偏移;
                super.x = x;
                super.y = y;
                super.whenShooting = 攻击激活;
                super.width = 宽;
                super.drawArc = 绘制弧形;
                super.region = 贴图;
                super.offsetRegion = 贴图跟随xy;
                super.widthScale = 宽度缩放;
                super.alpha = 透明度;
            }

        }

        public static class 修复场 extends RepairFieldAbility {
            public 修复场(float 数量, float 冷却时间, float 范围) {
                super(数量, 冷却时间, 范围);
            }
        }

        public static class 再生 extends RegenAbility {
            public float 每帧百分比 = 0f;
            public float 每帧固定量 = 0f;

            public 再生(float 每帧百分比, float 每帧固定量) {
                super.percentAmount = 每帧百分比;
                super.amount = 每帧固定量;
            }

            public 再生() {
                super.percentAmount = 每帧百分比;
                super.amount = 每帧固定量;
            }
        }

        public static class 移动闪电 extends MoveLightningAbility {
            public 移动闪电(float 伤害, int 长度, float 概率, float x, float y, float 最小速度, float 最大速度, Color 颜色, String 发热区域) {
                super(伤害, 长度, 概率, y, 最小速度, 最大速度, 颜色, 发热区域);
                super.x = x;
            }

            public 移动闪电(float 伤害, int 长度, float 概率, float x, float y, float 最小速度, float 最大速度, Color 颜色) {
                super(伤害, 长度, 概率, y, 最小速度, 最大速度, 颜色);
                super.x = x;
            }
        }

        public static class 移动效果 extends MoveEffectAbility {
            public boolean 显示 = false;

            public 移动效果(float x, float y, Color 颜色, Effect 效果, float 间隔) {
                super(x, y, 颜色, 效果, 间隔);
                display = 显示;
            }
        }

        public static class 液体再生 extends LiquidRegenAbility {
            /*？？？？？？？？？？？？？*/
            public 液体再生(Liquid 流体, float 吸收速度, float 每次量, float 效果几率, Effect 效果) {
                super.liquid = 流体;
                super.slurpSpeed = 吸收速度;
                super.regenPerSlurp = 每次量;
                super.slurpEffectChance = 效果几率;
                super.slurpEffect = 效果;
            }
        }

        public static class 液体爆炸 extends LiquidExplodeAbility {
            public 液体爆炸(Liquid 流体, float 数量, float 辐射量刻度, float 辐射标度) {
                super.liquid = 流体;
                super.amount = 数量;
                super.radAmountScale = 辐射量刻度;
                super.radScale = 辐射标度;
            }
        }

        public static class 力墙场 extends ForceFieldAbility {
            public 力墙场(float 半径, float 恢复速度, float max, float 冷却时间) {
                super(半径, 恢复速度, max, 冷却时间);

            }
            public 力墙场(float 半径, float 恢复速度, float max, float 冷却时间,int 边数, float 角度) {
                super(半径, 恢复速度, max, 冷却时间);
                super.sides = 边数;
                super.rotation = 角度;

            }

        }

        public static class 能量场 extends EnergyFieldAbility {
            public 能量场(float 伤害, float 冷却时间, float 范围) {
                super(伤害, 冷却时间, 范围);
            }

            public 能量场(float 伤害, float 冷却时间, float 范围, StatusEffect 状态, float 持续时间, float x, float y, int max, float 治愈百分比) {
                super(伤害, 冷却时间, 范围);
                super.status = 状态;
                super.statusDuration = 持续时间;
                super.x = x;
                super.y = y;
                super.maxTargets = max;
                super.healPercent = 治愈百分比;
            }

        }

        public static class 装甲板 extends ArmorPlateAbility {
            public 装甲板(float 健康乘数) {
                super.healthMultiplier = 健康乘数;

            }
        }
    }

    //星球
    public static class 星球 extends Planet {
        public 星球(String name, Planet parent, float radius) {
            super(name, parent, radius);
        }

        public 星球(String name, Planet parent, float radius, int sectorSize) {
            super(name, parent, radius, sectorSize);
        }
    }

    //地图
    public static class 地图 extends SectorPreset {
        public int 占领波数 = 0;
        public float 难度;
        public float 启动波数时间倍增器 = 2f;
        public boolean 添加起始资源 = false;
        public boolean 无照明 = false;
        public boolean 最后一个;
        public boolean 显示地图信息 = true;
        public boolean 覆盖默认值 = false;
        public boolean 自定义示意图 = false;
        public boolean 启动配装 = false;
        public boolean 占领后攻击模式 = false;

        public 地图(String name, Planet planet, int sector) {
            super(name, planet, sector);
            super.captureWave = 占领波数;
            super.difficulty = 难度;
            super.startWaveTimeMultiplier = 启动波数时间倍增器;
            super.addStartingItems = 添加起始资源;
            super.noLighting = 无照明;
            super.isLastSector = 最后一个;
            super.showSectorLandInfo = 显示地图信息;
            super.overrideLaunchDefaults = 覆盖默认值;
            super.allowLaunchSchematics = 自定义示意图;
            super.allowLaunchLoadout = 启动配装;
            super.attackAfterWaves = 占领后攻击模式;
        }

        public 地图(String name) {
            super(name);
            super.captureWave = 占领波数;
            super.difficulty = 难度;
            super.startWaveTimeMultiplier = 启动波数时间倍增器;
            super.addStartingItems = 添加起始资源;
            super.noLighting = 无照明;
            super.isLastSector = 最后一个;
            super.showSectorLandInfo = 显示地图信息;
            super.overrideLaunchDefaults = 覆盖默认值;
            super.allowLaunchSchematics = 自定义示意图;
            super.allowLaunchLoadout = 启动配装;
            super.attackAfterWaves = 占领后攻击模式;
        }
    }


}
