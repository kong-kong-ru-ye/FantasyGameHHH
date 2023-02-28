package huanxiang.gdfgdg;






//
//
//
//wall
//
//
//public HXWall(String name) {
//        super(name);
//        insulated = 绝缘;
//        absorbLasers = 吸收激光;
//        solid = true;
//        destructible = true;
//        group = BlockGroup.walls;
//        buildCostMultiplier = 6f;
//        canOverdrive = false;
//        drawDisabled = false;
//        crushDamageMultiplier = 5f;
//        priority = TargetPriority.wall;
//
//        //it's a wall of course it's supported everywhere
//        envEnabled = Env.any;
//        }




















//
//import huanxiang.HXnengli.NengLiType;
//import mindustry.gen.Building;
//import mindustry.type.Item;
//import mindustry.type.ItemStack;
//import mindustry.type.Liquid;
//import mindustry.type.LiquidStack;
//import mindustry.world.blocks.payloads.Payload;
//
//import java.util.ArrayList;
//
//public class HXBuilding extends Building {
//
//
//
//// Building 中这个 → nearby
///*
//public Building nearby(final int n) {
//        Building building;
//        if (n != 0) {
//            if (n != 1) {
//                if (n != 2) {
//                    if (n != 3) {
//                        building = null;
//                    }
//                    else {
//                        final World world = Vars.world;
//                        final Tile tile = this.tile;
//                        building = world.build((int)tile.x, tile.y - 1);
//                    }
//                }
//                else {
//                    final World world2 = Vars.world;
//                    final Tile tile2 = this.tile;
//                    building = world2.build(tile2.x - 1, (int)tile2.y);
//                }
//            }
//            else {
//                final World world3 = Vars.world;
//                final Tile tile3 = this.tile;
//                building = world3.build((int)tile3.x, tile3.y + 1);
//            }
//        }
//        else {
//            final World world4 = Vars.world;
//            fin
//
//*/
//
//
//    public int 物品数量(Item b) {
//        return items.get(b);
//    }
//
//    public boolean 判断物品数量(Item b, int c, int d) {
//        if (d == 0) return items.get(b) >= c;
//        if (d == 1) return items.get(b) == c;
//        if (d == 2) return items.get(b) <= c;
//        return false;
//    }
//
//    public boolean 判断物品数量(ItemStack[] stacks) {
//        for (ItemStack stack : stacks) {
//            if (!items.has(stack.item, stack.amount)) return false;
//        }
//        return true;
//    }
//
//    public void 生成物品(Item b, int c) {
//        items.add(b, c);
//    }
//
//    public void 生成物品(ItemStack[] b) {
//        for (ItemStack stack : b) {
//            items.add(stack.item, stack.amount);
//        }
//    }
//
//    /*
//    public static <Build extends Building> void 生成物品(Build a,Item b, int c) {
//        items.add(b, c);
//    }
//
//    public static <Build extends Building>void 生成物品(Build a,ItemStack[] b  ){
//        for (ItemStack stack : b) {
//            items.add(stack.item, stack.amount);
//        }
//    }
//*/
//    public void 清除物品(Item b, int c) {
//        items.remove(b, c);
//    }
//
//    public void 清除物品(ItemStack[] stacks) {
//        for (ItemStack stack : stacks)
//            items.remove(stack.item, stack.amount);
//    }
//
//
//    public float 流体数量(Liquid b) {
//        return liquids.get(b);
//    }
//
//    public boolean 判断流体数量(Liquid b, float c, int d) {
//        if (d == 0) return liquids.get(b) >= c;
//        if (d == 1) return liquids.get(b) == c;
//        if (d == 2) return liquids.get(b) <= c;
//        return false;
//    }
//
//    public boolean 判断流体数量(LiquidStack[] stacks) {
//        for (LiquidStack stack : stacks) {
//            if (!判断流体数量(stack.liquid, stack.amount, 0)) return false;
//        }
//        return true;
//    }
//
//    public void 生成流体(Liquid b, float c) {
//        liquids.add(b, c);
//    }
//
//    public void 生成流体(LiquidStack[] b) {
//        for (LiquidStack stack : b) {
//            liquids.add(stack.liquid, stack.amount);
//        }
//    }
//
//    public void 清除流体(Liquid b, float c) {
//        liquids.remove(b, c);
//    }
//
//    public void 清除流体(LiquidStack[] b) {
//        for (LiquidStack stack : b) {
//            liquids.remove(stack.liquid, stack.amount);
//        }
//    }
//
//    public void 导出(Building a) {
//        dump();
//    }
//
//    public void 导出(Item b) {
//        dump(b);
//    }
//
//    public void 导出(ItemStack[] b) {
//        for (ItemStack stack : b) {
//            dump(stack.item);
//        }
//    }
//
//    public void 导出(Liquid b) {
//        dumpLiquid(b);
//    }
//
//    public void 导出(LiquidStack[] b) {
//        for (LiquidStack stack : b) {
//            dumpLiquid(stack.liquid);
//        }
//    }
//
//    public void 导出(Payload b) {
//        dumpPayload(b);
//    }
//
//    ///////////////////////
//
//
//}
