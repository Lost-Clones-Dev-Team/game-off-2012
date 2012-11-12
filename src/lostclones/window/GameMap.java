package lostclones.window;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import lostclones.map.LCMap;

public class GameMap extends Window{
    LCMap map;

    BufferedImage buffer;

    public GameMap(LCMap newMap) {
        setMap(newMap);
    }

    public void setMap(LCMap newMap) {
        map = newMap;
    }

    @Override
    void draw(Graphics g) {
        if (map != null) {

            int mapWidth = map.getWidth();
            int mapHeight = map.getHeight();
            buffer = new BufferedImage(mapWidth*32,mapHeight*32, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = buffer.createGraphics();
            graphics2D.clearRect(0, 0, mapWidth*32, mapHeight*32);

            for (int i = 0; i < mapWidth; i ++) {
                for (int j = 0; j < mapHeight; j++) {
                    BufferedImage image = map.getTile(i,j).getSprite().getImage();
                    if (image != null) {
                        graphics2D.drawImage(image, i*32, j*32, null);
                    }
                }
            }
            g.clearRect(0, 0, mapWidth*32, mapHeight*32);
            g.drawImage(buffer, 0, 0, null);
            graphics2D.dispose();
        }

    }
}
