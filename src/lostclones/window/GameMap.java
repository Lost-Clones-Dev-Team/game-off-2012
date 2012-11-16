package lostclones.window;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import lostclones.map.LCMap;
import lostclones.map.Tile;

public class GameMap extends Window{

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


            int curX = map.getCurXPos();
            int curY = map.getCurYPos();

            for (int i = curX; i < curX + mapWidth; i ++) {
                for (int j = curY; j < curY + mapHeight; j++) {

                    Tile tile = map.getTile(i, j);
                    if (tile != null) {
                        BufferedImage image = tile.getSprite().getImage();
                        if (image != null) {
                            graphics2D.drawImage(image, (i-curX)*32, (j-curY)*32, null);
                        }
                    }
                }
            }
            g.clearRect(0, 0, mapWidth*32, mapHeight*32);
            g.drawImage(buffer, 0, 0, null);
            graphics2D.dispose();
        }

    }
}
