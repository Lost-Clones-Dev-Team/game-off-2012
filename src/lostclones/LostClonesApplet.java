package lostclones;

import java.awt.Color;

import javax.swing.JApplet;

import lostclones.images.TextureManager;
import lostclones.map.Maps;
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

            if (times > 20) {
                Maps.getInstance().getMap("first").moveRight(1);
                Maps.getInstance().getMap("first").moveDown(1);
                times = 0;
            }
        }
    }

    public void stop() {
        System.exit(0);
    }
}
