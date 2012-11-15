package lostclones.images;

import java.awt.image.BufferedImage;

public class Texture {
    private int tileWidth;
    private int tileHeight;
    private BufferedImage image = null;

    public Texture(String fileName, int newTileWidth, int newTileHeight) {
        tileWidth = newTileWidth;
        tileHeight = newTileHeight;

        image = TextureManager.getInstance().getImage(fileName);
    }

    public BufferedImage getSprite(int subTileX, int subTileY) {
        BufferedImage sprite = null;

        if (image != null) {
            sprite = image.getSubimage(subTileX*tileWidth, subTileY*tileHeight, tileWidth, tileHeight);
        }

        return sprite;
    }
}
