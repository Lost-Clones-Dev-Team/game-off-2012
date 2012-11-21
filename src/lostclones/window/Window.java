package lostclones.window;

import java.awt.Container;

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
}
