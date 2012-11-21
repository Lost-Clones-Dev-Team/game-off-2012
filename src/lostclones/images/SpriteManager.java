package lostclones.images;

import java.util.HashMap;

public class SpriteManager {
    private static final SpriteManager instance = new SpriteManager();

    private HashMap<String, Sprite> sprites = new HashMap<String, Sprite>();

    private SpriteManager() {}

    public static SpriteManager getInstance() {
        return instance;
    }

    public Sprite getSprite(String spriteName) {
        return sprites.get(spriteName);
    }

    public void setSprite(String spriteName, Sprite sprite) {
        if (sprites.containsKey(spriteName)) {
            System.err.println("Sprite: " + spriteName + " already exists. Overwriting.");
        }
        sprites.put(spriteName, sprite);
    }

    public String[] getAllSpriteNames() {
        String[] spriteNames = new String[sprites.keySet().size()];
        int i = 0;
        for (String key : sprites.keySet()) {
            spriteNames[i] = key;
            i ++;
        }
        return spriteNames;
    }

    public String[] getAllTileNames() {
        String[] spriteNames = getAllSpriteNames();
        String[] tempNames = new String[spriteNames.length];
        int i = 0;
        for (String s : spriteNames) {
            Sprite sprite = sprites.get(s);
            if (sprite.getType().equals("tile")) {
                tempNames[i] = s;
                i ++;
            }
        }
        String[] tileNames = new String[i];
        for (int j = 0; j < i; j ++) {
            tileNames[j] = tempNames[j];
        }

        return tileNames;
    }
}
