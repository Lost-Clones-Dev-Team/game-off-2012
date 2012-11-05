package lostclones.map;

import java.util.ArrayList;

import lostclones.map.units.Unit;

public class Map {
    private ArrayList<ArrayList<Tile>> map;
    private ArrayList<Unit> units;

    public Map(int width, int height) {
        map = new ArrayList<ArrayList<Tile>>();

        for (int i = 0; i < width; i++) {
            map.add(new ArrayList<Tile>());
        }
    }

    public Tile getTile(int x, int y) {
        Tile tile = null;
        if (map.size() > x && map.get(x).size() > y) {
            tile = map.get(x).get(y);
        }
        return tile;
    }

    public void setTile(int x, int y, Tile newTile) {
        if (newTile != null) {
            map.get(x).set(y, newTile);
        }
    }
}
