package lostclones.map;

import java.util.ArrayList;

import lostclones.map.units.Unit;

public class LCMap {
    private Tile[][] map;

    private ArrayList<Unit> units;

    private int width;
    private int height;

    public LCMap(int newWidth, int newHeight) {
        width = newWidth;
        height = newHeight;
        map = new Tile[width][height];
    }

    public Tile getTile(int x, int y) {
        return map[x][y];
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
}
