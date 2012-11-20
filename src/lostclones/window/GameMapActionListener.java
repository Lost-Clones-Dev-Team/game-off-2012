package lostclones.window;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import lostclones.map.LCMap;
import lostclones.map.Maps;

public class GameMapActionListener implements KeyListener, MouseListener, MouseMotionListener{

    private LCMap map;

    public GameMapActionListener() {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int scrollspeed = 16;
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                map.moveLeft(scrollspeed);
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                map.moveRight(scrollspeed);
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                map.moveUp(scrollspeed);
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                map.moveDown(scrollspeed);
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
        int mouseX = e.getX();
        int mouseY = e.getY();

        LCMap map = Maps.getInstance().getMap("first");
        int xTile = map.getCurXTile();
        int yTile = map.getCurYTile();
        int offX = map.getCurXOffset();
        int offY = map.getCurYOffset();

        int mouseTileX = (int) Math.floor((mouseX - offX) / 32) + xTile;
        int mouseTileY = (int) Math.floor((mouseY - offY) / 32) + yTile;

        map.toggleSelectTile(mouseTileX, mouseTileY);

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
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public void setMap(LCMap newMap) {
        map = newMap;
    }

}
