package lostclones.images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Texture {
    private static String currentDir = System.getProperty("user.dir");
    private int tileWidth;
    private int tileHeight;
    private BufferedImage image = null;

    public Texture(String fileName, int newTileWidth, int newTileHeight) {
        tileWidth = newTileWidth;
        tileHeight = newTileHeight;

        try {
            image = ImageIO.read(new File(currentDir + fileName));
        } catch (IOException e) {
            System.err.println("File: " + currentDir + fileName + " could not be found.");
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
