package lostclones;

import java.awt.Color;

import javax.swing.JApplet;

import lostclones.images.TextureManager;
import lostclones.map.Maps;
import lostclones.map.Tile;
import lostclones.window.WindowManager;

public class LostClonesApplet extends JApplet implements Runnable{

    private static final long serialVersionUID = -5282583319538086367L;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private static final int FPS = 60;
    private Thread thread;

    private WindowManager windowManager;

    public void init() {
        TextureManager.getInstance().setApplet(this);

        setBackground(Color.WHITE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        Maps.getInstance().setupMaps();

        windowManager = new WindowManager(this, "gameMap");
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

    public void stop() {
        System.exit(0);
    }
}
