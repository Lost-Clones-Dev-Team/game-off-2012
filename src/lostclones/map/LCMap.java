package lostclones.map;

import java.util.ArrayList;

import lostclones.map.structures.Structure;
import lostclones.map.units.Unit;
import lostclones.players.Player;

public class LCMap {
    private Tile[][] map;

    private ArrayList<Player> players;
    private Unit selectedUnit;

    private int width;
    private int height;
    private int curXTile;
    private int curYTile;
    private int curXOffset;
    private int curYOffset;

    public LCMap(int newWidth, int newHeight) {
        players = new ArrayList<Player>();
        width = newWidth;
        height = newHeight;
        curXTile = 0;
        curYTile = 0;
        curXOffset = 0;
        curYOffset = 0;
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
            if (x >= 0 && y >= 0 && x < width && y < height) {
                map[x][y] = newTile;
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setCurXTile(int newXTile) {
        curXTile = newXTile;
    }

    public int getCurXTile() {
        return curXTile;
    }

    public void setCurYTile(int newYTile) {
        curYTile = newYTile;
    }

    public int getCurYTile() {
        return curYTile;
    }

    public void setCurXOffset(int newXOffset) {
        curXOffset = newXOffset;
    }

    public int getCurXOffset() {
        return curXOffset;
    }

    public void setCurYOffset(int newYOffset) {
        curYOffset = newYOffset;
    }

    public int getCurYOffset() {
        return curYOffset;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        if (players.contains(player)) {
            players.remove(player);
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public String[] getListOfPlayers() {
        String[] playerList = new String[players.size()];
        int i = 0;
        for (Player p : players) {
            playerList[i] = p.getName();
            i ++;
        }
        return playerList;
    }
    public void moveLeft(int amount) {
        curXOffset += amount;
        if (curXOffset > 32) {
            curXOffset -= 32;
            curXTile --;
        }
    }

    public void moveRight(int amount) {
        curXOffset -= amount;
        if (curXOffset < 0) {
            curXOffset += 32;
            curXTile ++;
        }
    }

    public void moveUp(int amount) {
        curYOffset += amount;
        if (curYOffset > 32) {
            curYOffset -= 32;
            curYTile --;
        }
    }

    public void moveDown(int amount) {
        curYOffset -= amount;
        if (curYOffset < 0) {
            curYOffset += 32;
            curYTile ++;
        }
    }

    public Unit getUnit(int tileX, int tileY) {
        Unit unit = null;
        for (Player p : players) {
            ArrayList<Unit> units = p.getUnits();
            for (Unit u : units) {
                if (tileX == u.getX() && tileY == u.getY()) {
                    unit = u;
                    break;
                }
            }
            if (unit != null) {
                break;
            }
        }
        return unit;
    }

    public Structure getStructure(int tileX, int tileY) {
        Structure structure = null;
        for (Player p : players) {
            ArrayList<Structure> structures = p.getStructures();
            for (Structure s : structures) {
                if (tileX == s.getX() && tileY == s.getY()) {
                    structure = s;
                    break;
                }
            }
            if (structure != null) {
                break;
            }
        }
        return structure;
    }

    public void toggleSelectTile(int tileX, int tileY) {
        Unit u = getUnit(tileX, tileY);
        if (u != null) {
            if (u.equals(selectedUnit)) {
                selectedUnit = null;
            } else {
                selectedUnit = u;
            }
        }
    }

    public void setSelectedUnit(Unit unit) {
        selectedUnit = unit;
    }

    public Unit getSelectedUnit() {
        return selectedUnit;
    }

    public Player getPlayer(String playerName) {
        Player player = null;

        for (Player p : players) {
            String name = p.getName();
            if (name.equals(playerName)) {
                player = p;
                break;
            }
        }

        return player;
    }
}
