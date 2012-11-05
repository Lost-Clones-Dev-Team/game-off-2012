package lostclones.images;

import java.awt.image.BufferedImage;

public class Sprite {
    private String textureName;
    private int xTile;
    private int yTile;

    public Sprite(String newTextureName, int newXTile, int newYTile) {
        textureName = newTextureName;
        xTile = newXTile;
        yTile = newYTile;
    }

    public BufferedImage getImage() {
        BufferedImage image = null;

        Texture texture = TextureManager.getInstance().getTexture(textureName);
        if (texture != null) {
            image = texture.getSprite(xTile, yTile);
        }
        return image;
    }
}
