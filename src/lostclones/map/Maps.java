package lostclones.map;

import java.util.HashMap;

import lostclones.images.Sprite;
import lostclones.images.SpriteManager;
import lostclones.images.Texture;
import lostclones.images.TextureManager;
import lostclones.map.units.Pawn;

public class Maps {
    private static final Maps instance = new Maps();

    private Maps() {}

    HashMap<String, LCMap> maps = new HashMap<String, LCMap>();

    public static Maps getInstance() {
        return instance;
    }

    public void setupMaps() {
        Texture genTexture = new Texture("general.png", 32, 32);
        TextureManager.getInstance().setTexture("general", genTexture);

        Sprite grass = new Sprite("general", 0, 0);
        SpriteManager.getInstance().setSprite("grass", grass);
        Sprite grass2 = new Sprite("general", 1, 0);
        SpriteManager.getInstance().setSprite("grass2", grass2);

        Sprite unit1 = new Sprite("general", 2, 0);
        SpriteManager.getInstance().setSprite("unit1", unit1);

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
