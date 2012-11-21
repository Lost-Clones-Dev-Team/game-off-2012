package lostclones.window;

import java.awt.Container;

import lostclones.LostClonesApplet;
import lostclones.map.LCMap;
import lostclones.map.Maps;

public class WindowManager {
    Window window;
    LostClonesApplet applet;
    Container contentPane;

    public WindowManager(LostClonesApplet newApplet, String windowToLoad) {
        applet = newApplet;
        contentPane = applet.getContentPane();
        contentPane.setLayout(null);

        if (windowToLoad.equals("mainMenu")) {
            loadMainMenu();
        } else if (windowToLoad.equals("gameMap")) {
            //loadGameMap(Maps.getInstance().getMap("first"));
            loadEditor(Maps.getInstance().getMap("first"));
        }

        if (window != null) {
            contentPane.add(window);
        }

    }

    public void loadMainMenu() {
        window = new MainMenu();
    }

    public void loadGameMap(LCMap newMap) {
        window = new GameMap(newMap);
    }

    public void loadEditor(LCMap newMap) {
        window = new Editor(newMap);
    }
}
