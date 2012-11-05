package lostclones.map;

import lostclones.images.Sprite;
import lostclones.images.SpriteManager;



public class Tile {

    private int x;
    private int y;
    private String spriteName;

    public Tile(String newSpriteName, int newX, int newY) {
        spriteName = newSpriteName;
        x = newX;
        y = newY;
    }

    public void setX(int newX) {
        x = newX;
    }

    public int getX() {
        return x;
    }

    public void setY(int newY) {
        y = newY;
    }

    public int getY() {
        return y;
    }

    public Sprite getSprite() {
        return SpriteManager.getInstance().getSprite(spriteName);
    }


}
