package lostclones.images;

import java.util.HashMap;

public class TextureManager {
    private static final TextureManager instance = new TextureManager();

    private HashMap<String, Texture> textures = new HashMap<String, Texture>();

    private TextureManager() {}

    public static TextureManager getInstance() {
        return instance;
    }

    public Texture getTexture(String textureName) {
        return textures.get(textureName);
    }

    public void setTexture(String textureName, Texture texture) {
        if (textures.containsKey(textureName)) {
            System.err.println("Texture: " + textureName + " already exists. Overwriting.");
        }
        textures.put(textureName, texture);
    }
}
