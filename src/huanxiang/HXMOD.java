package huanxiang;

import mindustry.mod.Mod;

import static huanxiang.core.HXSpecial.HXModJS.HXMods;

public class HXMOD extends Mod {

public static String ModName = "hx";
   
    public static String DawnName(String name){
        return ModName + "-" + name;
    }
     
      
        public HXMOD() {
    }
    
    @Override
    public void loadContent() {
         HXMods();
    
    
   
    }
}
