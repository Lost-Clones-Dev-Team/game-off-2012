package lostclones;

import java.awt.Color;

import javax.swing.JApplet;

import lostclones.images.TextureManager;
import lostclones.map.Maps;
import lostclones.map.structures.StructureManager;
import lostclones.map.units.UnitManager;
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
        UnitManager.getInstance().setupUnits();
        StructureManager.getInstance().setupStructures();

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
        // thread info
        while(true) {

            repaint();
            try {
                Thread.sleep(1000/FPS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        System.exit(0);
    }
}
