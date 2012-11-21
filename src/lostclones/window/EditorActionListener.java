package lostclones.window;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import lostclones.map.LCMap;
import lostclones.map.Tile;
import lostclones.map.structures.Structure;
import lostclones.map.structures.StructureManager;
import lostclones.map.units.Unit;
import lostclones.map.units.UnitManager;
import lostclones.players.Player;

public class EditorActionListener implements KeyListener, MouseListener, MouseMotionListener{

    private LCMap map;
    private Editor editor;

    public EditorActionListener(Editor newEditor) {
        editor = newEditor;
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
        editor.requestFocus();
        int mouseX = e.getX();
        int mouseY = e.getY();

        mouseAction(mouseX, mouseY);
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
        int mouseX = e.getX();
        int mouseY = e.getY();
        mouseAction(mouseX, mouseY);

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public void setMap(LCMap newMap) {
        map = newMap;
    }

    private void mouseAction(int mouseX, int mouseY) {
        if (mouseX < editor.getMapWidth()*32 && mouseY < editor.getMapHeight()*32) {
            int xTile = map.getCurXTile();
            int yTile = map.getCurYTile();
            int offX = map.getCurXOffset();
            int offY = map.getCurYOffset();

            int mouseTileX = (int) Math.floor((mouseX - offX) / 32) + xTile;
            int mouseTileY = (int) Math.floor((mouseY - offY) / 32) + yTile;

            String lastAction = editor.getLastAction();
            String selectedSprite = editor.getSelectedSprite();

            String selectedPlayer = editor.getSelectedPlayer();
            Player player = map.getPlayer(selectedPlayer);

            if (lastAction.equals("sprite")) {
                map.setTile(mouseTileX, mouseTileY, new Tile(selectedSprite, mouseTileX, mouseTileY));
            } else if (lastAction.equals("unit")){
                Unit u = map.getUnit(mouseTileX, mouseTileY);
                if (u != null) {
                    String name = u.getPlayer();
                    Player p = map.getPlayer(name);
                    if (p != null) {
                        p.removeUnit(u);
                    }
                }

                String selectedUnit = editor.getSelectedUnit();
                Unit unit = UnitManager.getInstance().createUnit(selectedUnit);
                unit.setPlayer(selectedPlayer);
                unit.setX(mouseTileX);
                unit.setY(mouseTileY);

                player.addUnit(unit);
            } else if (lastAction.equals("structure")) {
                Structure s = map.getStructure(mouseTileX, mouseTileY);
                if (s != null) {
                    String name = s.getPlayer();
                    Player p = map.getPlayer(name);
                    if (p != null) {
                        p.removeStructure(s);
                    }
                }

                String selectedStructure = editor.getSelectedStructure();
                Structure structure = StructureManager.getInstance().createStructure(selectedStructure);
                structure.setPlayer(selectedPlayer);
                structure.setX(mouseTileX);
                structure.setY(mouseTileY);

                player.addStructure(structure);
            } else {
                map.toggleSelectTile(mouseTileX, mouseTileY);
            }
        }
    }

}
