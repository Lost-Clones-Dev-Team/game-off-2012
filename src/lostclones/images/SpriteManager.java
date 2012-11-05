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
}
