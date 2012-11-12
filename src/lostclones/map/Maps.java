package lostclones.map;

import java.util.HashMap;

import lostclones.images.Sprite;
import lostclones.images.SpriteManager;
import lostclones.images.Texture;
import lostclones.images.TextureManager;

public class Maps {
    private static final Maps instance = new Maps();

    private Maps() {}

    HashMap<String, LCMap> maps = new HashMap<String, LCMap>();

    public static Maps getInstance() {
        return instance;
    }

    public void setupMaps() {
        Texture grassTexture = new Texture("grass.png", 32,32);
        TextureManager.getInstance().setTexture("grass", grassTexture);

        Sprite grass = new Sprite("grass", 1, 3);
        SpriteManager.getInstance().setSprite("grass", grass);
        Sprite grass2 = new Sprite("grass", 1, 2);
        SpriteManager.getInstance().setSprite("grass2", grass2);

        LCMap map1 = new LCMap(32,32);
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                map1.setTile(i, j, new Tile("grass", i, j));
            }
        }

        maps.put("first", map1);
    }

    public LCMap getMap(String mapName) {
        if (maps.containsKey(mapName)) {
            return maps.get(mapName);
        }
        return null;
    }
}
