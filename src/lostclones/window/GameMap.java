package lostclones.window;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import lostclones.images.SpriteManager;
import lostclones.map.LCMap;
import lostclones.map.Tile;
import lostclones.map.structures.Structure;
import lostclones.map.units.Unit;
import lostclones.players.Player;

public class GameMap extends Window {

    private static final long serialVersionUID = 310643392951253204L;

    private LCMap map;
    private BufferedImage buffer;
    private int mapWidth = 20;
    private int mapHeight = 16;

    private GameMapActionListener actionListener;

    public GameMap(LCMap newMap) {
        actionListener = new GameMapActionListener();
        setMap(newMap);
        setFocusable(true);
        addKeyListener(actionListener);
        addMouseListener(actionListener);
        addMouseMotionListener(actionListener);
    }

    public void setMap(LCMap newMap) {
        map = newMap;
        actionListener.setMap(map);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (map != null) {

            buffer = new BufferedImage(mapWidth*32,mapHeight*32, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = buffer.createGraphics();
            graphics2D.clearRect(0, 0, mapWidth*32, mapHeight*32);


            int curX = map.getCurXTile();
            int curY = map.getCurYTile();

            int offX = map.getCurXOffset();
            int offY = map.getCurYOffset();

            int left = curX - 1;
            int right = curX + mapWidth;
            int top = curY - 1;
            int bot = curY + mapHeight;

            for (int i = left; i < right; i ++) {
                for (int j = top; j < bot; j++) {
                    Tile tile = map.getTile(i, j);
                    if (tile != null) {
                        BufferedImage image = tile.getSprite().getImage();
                        if (image != null) {
                            graphics2D.drawImage(image, ((i-curX)*32)+offX, ((j-curY)*32)+offY, null);
                        }
                    }
                }
            }

            ArrayList<Player> players = map.getPlayers();

            for (Player p : players) {
                ArrayList<Structure> structures = p.getStructures();
                for(Structure s : structures) {
                    int x = s.getX();
                    int y = s.getY();

                    if (x >= left &&  x < right && y >= top && y < bot) {
                        int drawX = x - curX;
                        int drawY = y - curY;
                        BufferedImage image = s.getSprite().getImage();
                        graphics2D.drawImage(image, (drawX*32)+offX, (drawY*32)+offY, null);
                    }
                }
            }

            for (Player p : players) {
                ArrayList<Unit> units = p.getUnits();
                for(Unit u : units) {
                    int x = u.getX();
                    int y = u.getY();

                    if (x >= left &&  x < right && y >= top && y < bot) {
                        int drawX = x - curX;
                        int drawY = y - curY;
                        BufferedImage image = u.getSprite().getImage();
                        graphics2D.drawImage(image, (drawX*32)+offX, (drawY*32)+offY, null);
                    }
                }
            }

            BufferedImage selectedImage = SpriteManager.getInstance().getSprite("selected").getImage();
            Unit selectedUnit = map.getSelectedUnit();
            if (selectedUnit != null) {
                int x = selectedUnit.getX();
                int y = selectedUnit.getY();
                int drawX = x - curX;
                int drawY = y - curY;
                if (x >= left &&  x < right && y >= top && y < bot) {
                    graphics2D.drawImage(selectedImage, (drawX*32)+offX, (drawY*32)+offY, null);
                }

                BufferedImage selectedMove = SpriteManager.getInstance().getSprite("selectedMove").getImage();
                int curAP = selectedUnit.getCurAP();
                while (curAP > 0) {
                    graphics2D.drawImage(selectedMove, ((drawX-curAP)*32)+offX, (drawY*32)+offY, null);
                    graphics2D.drawImage(selectedMove, ((drawX+curAP)*32)+offX, (drawY*32)+offY, null);
                    graphics2D.drawImage(selectedMove, (drawX*32)+offX, ((drawY-curAP)*32)+offY, null);
                    graphics2D.drawImage(selectedMove, (drawX*32)+offX, ((drawY+curAP)*32)+offY, null);
                    curAP --;
                }
            }


            g.clearRect(0, 0, mapWidth*32, mapHeight*32);
            g.drawImage(buffer, 0, 0, null);
            graphics2D.dispose();
        }
    }
}
