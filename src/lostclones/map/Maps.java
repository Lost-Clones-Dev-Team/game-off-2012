package lostclones.map;

import java.util.HashMap;

import lostclones.images.Sprite;
import lostclones.images.SpriteManager;
import lostclones.images.Texture;
import lostclones.images.TextureManager;
import lostclones.map.structures.Road;
import lostclones.map.units.Pawn;

public class Maps {
    private static final Maps instance = new Maps();

    private Maps() {}

    HashMap<String, LCMap> maps = new HashMap<String, LCMap>();

    public static Maps getInstance() {
        return instance;
    }

    public void setupMaps() {
        TextureManager.getInstance().setTexture("general", new Texture("general.png", 32, 32));

        SpriteManager sm = SpriteManager.getInstance();
        sm.setSprite("grass", new Sprite("general", 0, 0));
        sm.setSprite("grass2", new Sprite("general", 1, 0));
        sm.setSprite("unit1", new Sprite("general", 2, 0));
        sm.setSprite("road", new Sprite("general", 3, 0));
        sm.setSprite("selected", new Sprite("general", 0, 1));


        LCMap map1 = new LCMap(32,32);
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                if (i == 3 || j == 3) {
                    map1.setTile(i, j, new Tile("grass2", i, j));
                } else {
                    map1.setTile(i, j, new Tile("grass", i, j));
                }
            }
        }

        map1.addStructure(new Road(3,4));
        map1.addStructure(new Road(3,5));
        map1.addUnit(new Pawn(3,4));
        map1.addUnit(new Pawn(14,12));

        maps.put("first", map1);
    }

    public LCMap getMap(String mapName) {
        if (maps.containsKey(mapName)) {
            return maps.get(mapName);
        }
        return null;
    }
}
