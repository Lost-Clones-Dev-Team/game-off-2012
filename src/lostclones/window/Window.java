package lostclones.window;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JPanel;

public abstract class Window extends JPanel{
    Container contentPane;

    private static final long serialVersionUID = 8072790631856631621L;

    public Window() {
        setSize(800,600);
        setVisible(true);
    }

    public void setContentPane(Container newContentPane) {
        if (newContentPane != null) {
            contentPane = newContentPane;
        }
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(50, 50, 200, 150);
    }

}
