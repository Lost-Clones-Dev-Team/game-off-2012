package lostclones;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JApplet;

import lostclones.map.Maps;
import lostclones.map.Tile;
import lostclones.window.WindowManager;

public class LostClonesApplet extends JApplet implements Runnable{

    private static final long serialVersionUID = -5282583319538086367L;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private static final int FPS = 30;
    private Image doubleBufferImage;
    private Graphics doubleBufferGraphics;
    private Thread thread;

    private WindowManager windowManager;

    public void init() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        Maps.getInstance().setupMaps();
        windowManager = new WindowManager("gameMap");
    }

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        int times = 0;
        // thread info
        while(true) {
            repaint();
            try {
                Thread.sleep(1000/FPS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            times ++;

            if (times >= 15) {
                Maps.getInstance().getMap("first").setTile(5, 5, new Tile("grass2", 5, 5));
            }
            if (times >= 16) {
                Maps.getInstance().getMap("first").setTile(6, 5, new Tile("grass2", 6, 5));
            }
        }
    }

    @Override
    public void update(Graphics g) {
        if (doubleBufferImage == null) {
            doubleBufferImage = createImage(WINDOW_WIDTH, WINDOW_HEIGHT);
            doubleBufferGraphics = doubleBufferImage.getGraphics();
        }

        doubleBufferGraphics.setColor(getBackground());
        doubleBufferGraphics.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        doubleBufferGraphics.setColor(getForeground());
        paint(doubleBufferGraphics);
        g.drawImage(doubleBufferImage, 0, 0, this);
    }

    public void stop() {
        System.exit(0);
        /*
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
    }

    public void paint(Graphics g) {
        windowManager.draw(g);
    }
}
