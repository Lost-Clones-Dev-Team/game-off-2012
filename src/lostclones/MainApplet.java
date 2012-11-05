package lostclones;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class MainApplet extends Applet{

    int windowWidth = 800;
    int windowHeight = 600;


    public void init() {
        setSize(windowWidth, windowHeight);

        setBackground(Color.black);
    }

    public void paint(Graphics g) {
        g.setColor(Color.green);

        for (int i = 0; i < 10; i ++) {
            g.drawLine(windowWidth, windowHeight, i * windowWidth/10, 0);
        }
    }
}
