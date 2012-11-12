package lostclones.images;

import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

import lostclones.LostClonesApplet;

public class Texture {
    private int tileWidth;
    private int tileHeight;
    private BufferedImage image = null;

    public Texture(String fileName, int newTileWidth, int newTileHeight) {
        tileWidth = newTileWidth;
        tileHeight = newTileHeight;

        try {
            URL url = LostClonesApplet.class.getResource("resources/images/" + fileName);
            image = ImageIO.read(url);
        } catch (Exception e) {
            System.err.println("File: " + fileName + " could not be found.");
        }
    }

    public BufferedImage getSprite(int subTileX, int subTileY) {
        BufferedImage sprite = null;

        if (image != null) {
            sprite = image.getSubimage(subTileX*tileWidth, subTileY*tileHeight, tileWidth, tileHeight);
        }

        return sprite;
    }
}
