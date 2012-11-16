package lostclones.window;

import java.awt.Color;
import java.awt.Graphics;

public class MainMenu extends Window{

    private static final long serialVersionUID = 5924779066308318961L;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (g != null) {
            g.setColor(Color.BLUE);
            g.drawRect(50, 50, 200, 200);
        }
    }

}
