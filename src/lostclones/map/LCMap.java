package lostclones.map;

import java.util.ArrayList;

import lostclones.map.units.Unit;

public class LCMap {
    private Tile[][] map;

    private ArrayList<Unit> units;

    private int width;
    private int height;
    private int curXPos;
    private int curYPos;

    public LCMap(int newWidth, int newHeight) {
        width = newWidth;
        height = newHeight;
        curXPos = 0;
        curYPos = 0;
        map = new Tile[width][height];
    }

    public Tile getTile(int x, int y) {
        Tile tile = null;
        if (x >= 0 && y >= 0 && x < width && y < height) {
            tile = map[x][y];
        }
        return tile;
    }

    public void setTile(int x, int y, Tile newTile) {
        if (newTile != null) {
            map[x][y] = newTile;
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setCurXPos(int newXPos) {
        curXPos = newXPos;
    }

    public int getCurXPos() {
        return curXPos;
    }

    public void setCurYPos(int newYPos) {
        curYPos = newYPos;
    }

    public int getCurYPos() {
        return curYPos;
    }
}
