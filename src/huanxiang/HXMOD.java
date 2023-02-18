package huanxiang;

import mindustry.mod.Mod;

import huanxiang.core.HXSpecial.HXModJS;

public class HXMOD extends Mod {

public static String ModName = "hx";
   
    public static String DawnName(String name){
        return ModName + "-" + name;
    }
     
      
        public HXMOD() {
    }
    
    @Override
    public void loadContent() {
         HXModJS.HXMods();
    
    
   
    }
}
