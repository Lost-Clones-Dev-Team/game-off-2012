package lostclones.window;

import java.awt.Color;
import java.awt.Graphics;

public class MainMenu extends Window{

    @Override
    void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawRect(50, 50, 200, 200);
    }

}
