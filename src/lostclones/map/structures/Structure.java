package lostclones.map.structures;

import lostclones.images.Sprite;
import lostclones.images.SpriteManager;

public abstract class Structure {

    private int x;
    private int y;
    private String sprite;

    private boolean walkable;
    private String player;

    public Structure(String newPlayer, int newX, int newY) {
        player = newPlayer;
        x = newX;
        y = newY;
        walkable = true;
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

    public void setSprite(String newSprite) {
        sprite = newSprite;
    }

    public Sprite getSprite() {
        return SpriteManager.getInstance().getSprite(sprite);
    }

    public void setWalkable(boolean isWalkable) {
        walkable = isWalkable;
    }

    public boolean getWalkable() {
        return walkable;
    }

    public void setPlayer(String newPlayer) {
        player = newPlayer;
    }

    public String getPlayer() {
        return player;
    }
}
