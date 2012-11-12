package lostclones.window;

import java.awt.Graphics;

import lostclones.map.LCMap;
import lostclones.map.Maps;

public class WindowManager {
    Window window;

    public WindowManager(String window) {
        if (window.equals("mainMenu")) {
            loadMainMenu();
        } else if (window.equals("gameMap")) {
            loadGameMap(Maps.getInstance().getMap("first"));
        }
    }

    public void draw(Graphics g) {
        if (window != null) {
            window.draw(g);
        }
    }

    public void loadMainMenu() {
        window = new MainMenu();
    }

    public void loadGameMap(LCMap newMap) {
        window = new GameMap(newMap);
    }
}
