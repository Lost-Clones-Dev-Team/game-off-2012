package lostclones.images;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.imageio.ImageIO;

import lostclones.LostClonesApplet;

public class TextureManager {
    private static final TextureManager instance = new TextureManager();

    private HashMap<String, Texture> textures = new HashMap<String, Texture>();

    private LostClonesApplet applet = null;

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

    public void setApplet(LostClonesApplet newApplet) {
        applet = newApplet;
    }

    public BufferedImage getImage(String fileName) {
        BufferedImage image = null;
        if (applet != null) {
            InputStream is = applet.getClass().getResourceAsStream("/resources/images/" + fileName);
            try {
                image = ImageIO.read(is);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("File: " + fileName + " not found.");
            }
        }

        return image;
    }
}
