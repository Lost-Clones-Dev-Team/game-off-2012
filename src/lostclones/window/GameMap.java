package lostclones.window;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import lostclones.map.LCMap;
import lostclones.map.Tile;
import lostclones.map.units.Unit;

public class GameMap extends Window implements KeyListener, MouseListener {

    private static final long serialVersionUID = 310643392951253204L;

    private LCMap map;
    private BufferedImage buffer;
    private int mapWidth = 20;
    private int mapHeight = 16;

    public GameMap(LCMap newMap) {
        setMap(newMap);
    }

    public void setMap(LCMap newMap) {
        map = newMap;
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

            ArrayList<Unit> units = map.getUnits();
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
            g.clearRect(0, 0, mapWidth*32, mapHeight*32);
            g.drawImage(buffer, 0, 0, null);
            graphics2D.dispose();
        }

    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }
}
