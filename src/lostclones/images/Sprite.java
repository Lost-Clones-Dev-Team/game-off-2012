package lostclones.images;

import java.awt.image.BufferedImage;

public class Sprite {
    private String textureName;
    private int xTile;
    private int yTile;
    private String type;

    public Sprite(String newTextureName, int newXTile, int newYTile) {
        textureName = newTextureName;
        type = "generic";
        xTile = newXTile;
        yTile = newYTile;
    }
    public Sprite(String newTextureName, String newType, int newXTile, int newYTile) {
        textureName = newTextureName;
        type = newType;
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

    public void setType(String newType) {
        type = newType;
    }

    public String getType() {
        return type;
    }
}
