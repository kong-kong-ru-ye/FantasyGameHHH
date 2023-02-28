package huanxiang.type;

import mindustry.type.Planet;

public class HXPlanet extends Planet {

    public HXPlanet(String name, Planet parent, float radius) {
        super(name, parent, radius);

    }

    public HXPlanet(String name, Planet parent, float radius, int sectorSize) {
        super(name, parent, radius, sectorSize);

    }


}
