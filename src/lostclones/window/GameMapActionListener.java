package lostclones.window;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import lostclones.map.Maps;

public class GameMapActionListener implements KeyListener, MouseListener, MouseMotionListener{

    public GameMapActionListener() {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                Maps.getInstance().getMap("first").moveLeft(8);
                break;
            case KeyEvent.VK_RIGHT:
                Maps.getInstance().getMap("first").moveRight(8);
                break;
            case KeyEvent.VK_UP:
                Maps.getInstance().getMap("first").moveUp(8);
                break;
            case KeyEvent.VK_DOWN:
                Maps.getInstance().getMap("first").moveDown(8);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked");
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent arg0) {

    }

    @Override
    public void mouseMoved(MouseEvent arg0) {

    }

}
