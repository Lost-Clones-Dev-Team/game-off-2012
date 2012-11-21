package lostclones.window;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import lostclones.images.SpriteManager;
import lostclones.map.LCMap;
import lostclones.map.Tile;
import lostclones.map.structures.Structure;
import lostclones.map.structures.StructureManager;
import lostclones.map.units.Unit;
import lostclones.map.units.UnitManager;
import lostclones.players.Player;

public class Editor extends Window{

    private static final long serialVersionUID = 3890033735108549030L;
    private LCMap map;
    private BufferedImage buffer;
    private int mapWidth = 18;
    private int mapHeight = 16;

    private EditorActionListener actionListener;

    private String lastAction = "sprite";
    private String selectedSprite;
    private String selectedPlayer;
    private String selectedUnit;
    private String selectedStructure;
    private JLabel spriteIcon;
    private JLabel unitIcon;
    private JLabel structureIcon;
    private JTextField addPlayerText;
    private JComboBox playersDropdown;
    private JComboBox spritesDropdown;
    private JComboBox unitsDropdown;
    private JComboBox structuresDropdown;

    public Editor(LCMap newMap) {
        actionListener = new EditorActionListener(this);
        setMap(newMap);
        setFocusable(true);

        setupWindow();

        addKeyListener(actionListener);
        addMouseListener(actionListener);
        addMouseMotionListener(actionListener);
    }

    private void setupWindow() {
        setLayout(null);
        setFocusable(true);
        String[] sprites = SpriteManager.getInstance().getAllTileNames();

        spritesDropdown = new JComboBox(sprites);
        spritesDropdown.setSize(140, 20);
        spritesDropdown.setLocation(590, 25);
        spritesDropdown.setFocusable(false);
        spritesDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selection = (String) spritesDropdown.getSelectedItem();
                spriteIcon.setIcon(new ImageIcon(SpriteManager.getInstance().getSprite(selection).getImage()));
                lastAction = "sprite";
                selectedSprite = selection;
            }
        });
        add(spritesDropdown);

        JLabel spritesText = new JLabel("Sprites:");
        spritesText.setLocation(590, 0);
        spritesText.setSize(100, 20);
        add(spritesText);

        selectedSprite = sprites[0];
        spriteIcon = new JLabel(new ImageIcon(SpriteManager.getInstance().getSprite(selectedSprite).getImage()));
        spriteIcon.setSize(32,32);
        spriteIcon.setLocation(745,15);
        add(spriteIcon);


        JLabel playerText = new JLabel("Players:");
        playerText.setLocation(590, 70);
        playerText.setSize(100, 20);
        add(playerText);

        String[] players = map.getListOfPlayers();
        selectedPlayer = players[0];
        playersDropdown = new JComboBox(players);
        playersDropdown.setSize(140, 20);
        playersDropdown.setLocation(590, 95);
        playersDropdown.setFocusable(false);
        playersDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selection = (String) playersDropdown.getSelectedItem();
                selectedPlayer = selection;

            }
        });
        add(playersDropdown);

        addPlayerText = new JTextField();
        addPlayerText.setSize(140, 20);
        addPlayerText.setLocation(590, 120);
        add(addPlayerText);

        JButton addPlayer = new JButton(new ImageIcon(SpriteManager.getInstance().getSprite("add").getImage()));
        addPlayer.setSize(32, 32);
        addPlayer.setLocation(745, 80);
        addPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newName = addPlayerText.getText();
                newName = newName.trim();
                addPlayerText.setText("");
                requestFocus();

                boolean same = false;
                int itemCount = playersDropdown.getItemCount();
                for (int i = 0; i < itemCount && !same; i ++) {
                    String item = (String) playersDropdown.getItemAt(i);
                    if (item.equals(newName)) {
                        same = true;
                    }
                }
                if (!same && !newName.equals("")) {
                    Player player = new Player(newName);
                    map.addPlayer(player);
                    playersDropdown.addItem(newName);
                }
            }

        });
        add(addPlayer);

        JButton removePlayer = new JButton(new ImageIcon(SpriteManager.getInstance().getSprite("remove").getImage()));
        removePlayer.setSize(32, 32);
        removePlayer.setLocation(745, 115);
        removePlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = (String) playersDropdown.getSelectedItem();
                name = name.trim();
                if (!name.equals("neutral")) {
                    playersDropdown.removeItem(name);
                }
            }
        });
        add(removePlayer);

        JLabel unitText = new JLabel("Units:");
        unitText.setSize(100, 20);
        unitText.setLocation(590, 155);
        add(unitText);
        String[] units = UnitManager.getInstance().getListOfUnits();
        selectedUnit = units[0];
        unitsDropdown = new JComboBox(units);
        unitsDropdown.setSize(140, 20);
        unitsDropdown.setLocation(590, 180);
        unitsDropdown.setFocusable(false);
        unitsDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String unitName =  (String) unitsDropdown.getSelectedItem();
                lastAction = "unit";
                selectedUnit = unitName;
                Unit unit = UnitManager.getInstance().getUnit(selectedUnit);
                unitIcon.setIcon(new ImageIcon(unit.getSprite().getImage()));
            }
        });
        Unit unit = UnitManager.getInstance().getUnit(selectedUnit);
        unitIcon = new JLabel(new ImageIcon(unit.getSprite().getImage()));
        unitIcon.setSize(32,32);
        unitIcon.setLocation(745,175);
        add(unitIcon);

        add(unitsDropdown);

        JLabel structureText = new JLabel("Structures:");
        structureText.setSize(100, 20);
        structureText.setLocation(590, 220);
        add(structureText);

        String[] structures = StructureManager.getInstance().getListOfStructures();
        selectedStructure = structures[0];
        structuresDropdown = new JComboBox(structures);
        structuresDropdown.setSize(140, 20);
        structuresDropdown.setLocation(590, 245);
        structuresDropdown.setFocusable(false);
        structuresDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String structureName = (String) structuresDropdown.getSelectedItem();
                lastAction = "structure";
                selectedStructure = structureName;
                Structure structure = StructureManager.getInstance().getStructure(selectedStructure);
                structureIcon.setIcon(new ImageIcon(structure.getSprite().getImage()));
            }
        });
        Structure structure = StructureManager.getInstance().getStructure(selectedStructure);
        structureIcon = new JLabel(new ImageIcon(structure.getSprite().getImage()));
        structureIcon.setSize(32, 32);
        structureIcon.setLocation(745, 240);
        add(structureIcon);

        add(structuresDropdown);
    }

    public void setMap(LCMap newMap) {
        map = newMap;
        actionListener.setMap(map);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (map != null) {

            buffer = new BufferedImage(mapWidth*32,mapHeight*32, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = buffer.createGraphics();
            graphics2D.clearRect(0, 0, mapWidth*32, mapHeight*32);


            int curX = map.getCurXTile();
            int curY = map.getCurYTile();

            int offX = map.getCurXOffset();
            int offY = map.getCurYOffset();

            int left = curX - 1;
            int right = curX + mapWidth;
            int top = curY - 1;
            int bot = curY + mapHeight;

            for (int i = left; i < right; i ++) {
                for (int j = top; j < bot; j++) {
                    Tile tile = map.getTile(i, j);
                    if (tile != null) {
                        BufferedImage image = tile.getSprite().getImage();
                        if (image != null) {
                            graphics2D.drawImage(image, ((i-curX)*32)+offX, ((j-curY)*32)+offY, null);
                        }
                    }
                }
            }

            ArrayList<Player> players = map.getPlayers();

            for (Player p : players) {
                ArrayList<Structure> structures = p.getStructures();
                for(Structure s : structures) {
                    int x = s.getX();
                    int y = s.getY();

                    if (x >= left &&  x < right && y >= top && y < bot) {
                        int drawX = x - curX;
                        int drawY = y - curY;
                        BufferedImage image = s.getSprite().getImage();
                        graphics2D.drawImage(image, (drawX*32)+offX, (drawY*32)+offY, null);
                    }
                }
            }

            for (Player p : players) {
                ArrayList<Unit> units = p.getUnits();
                for(Unit u : units) {
                    int x = u.getX();
                    int y = u.getY();

                    if (x >= left &&  x < right && y >= top && y < bot) {
                        int drawX = x - curX;
                        int drawY = y - curY;
                        BufferedImage image = u.getSprite().getImage();
                        graphics2D.drawImage(image, (drawX*32)+offX, (drawY*32)+offY, null);
                    }
                }
            }

            BufferedImage selectedImage = SpriteManager.getInstance().getSprite("selected").getImage();
            Unit selectedUnit = map.getSelectedUnit();
            if (selectedUnit != null) {
                int x = selectedUnit.getX();
                int y = selectedUnit.getY();
                int drawX = x - curX;
                int drawY = y - curY;
                if (x >= left &&  x < right && y >= top && y < bot) {
                    graphics2D.drawImage(selectedImage, (drawX*32)+offX, (drawY*32)+offY, null);
                }

                BufferedImage selectedMove = SpriteManager.getInstance().getSprite("selectedMove").getImage();
                int curAP = selectedUnit.getCurAP();
                while (curAP > 0) {
                    graphics2D.drawImage(selectedMove, ((drawX-curAP)*32)+offX, (drawY*32)+offY, null);
                    graphics2D.drawImage(selectedMove, ((drawX+curAP)*32)+offX, (drawY*32)+offY, null);
                    graphics2D.drawImage(selectedMove, (drawX*32)+offX, ((drawY-curAP)*32)+offY, null);
                    graphics2D.drawImage(selectedMove, (drawX*32)+offX, ((drawY+curAP)*32)+offY, null);
                    curAP --;
                }
            }


            g.clearRect(0, 0, mapWidth*32, mapHeight*32);
            g.drawImage(buffer, 0, 0, null);
            graphics2D.dispose();
        }
    }

    public String getLastAction() {
        return lastAction;
    }

    public String getSelectedSprite() {
        return selectedSprite;
    }

    public String getSelectedPlayer() {
        return selectedPlayer;
    }

    public String getSelectedUnit() {
        return selectedUnit;
    }

    public String getSelectedStructure() {
        return selectedStructure;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }
}
