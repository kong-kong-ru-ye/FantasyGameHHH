package huanxiang.type.HX;

import mindustry.gen.Building

public class HuanXiangBuilding{
public static Building 核心;
//@Override

// this.items.remove(物品, 数量); //清除物品


// this.liquids.get(流体); //检测流体数量
// this.liquids.add(流体, 数量); //生成流体
// this.liquids.remove(流体, 数量); //清除流体
// this.liquidsreset(流体, 数量); //重置？
// this.items.current(); //最后接收或装载的流体

// this.dump(); //导出
// this.dump(物品); //导出物品
// this.dumpLiquid(流体); //导出流体
// this.dumpPayload(载荷); //导出载荷

    
    public void 物品数量(Item 物品){
       
     return 核心.items.get(物品)
     
    }
    
    
    public boolean 判断物品数量(Item 物品, int 数量,int 类){
       if(类=0) return 核心.items.get(物品) >= 数量;
       if(类=1) return 核心.items.get(物品) > 数量;
       if(类=2) return 核心.items.get(物品) = 数量;
       if(类=3) return 核心.items.get(物品) < 数量;
       if(类=4) return 核心.items.get(物品) <= 数量;       
       return false;
    }

    public boolean 判断物品数量(ItemStack[] 物品栈){
        return 核心.items.has(物品栈);
    }







public void 生成物品(ItemStack[] 物品栈){
        for(ItemStack stack : 物品栈){
            核心.items.add(stack.item, stack.amount);
        }
    }

    
    public void 生成物品(Item 物品, int 数量){
        核心.items.add(物品.id, 数量);
    }

  public void 清除物品(Item item, int 数量){
        amount = Math.min(数量, items[item.id]);

        items[item.id] -= 数量;
        total -= amount;
    }

    public void 清除物品(ItemStack[] stacks){
        for(ItemStack stack : stacks) remove(stack.item, stack.amount);
    }
  
  
  
  
}
