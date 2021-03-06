package lostclones.map;

import java.util.HashMap;

import lostclones.images.Sprite;
import lostclones.images.SpriteManager;
import lostclones.images.Texture;
import lostclones.images.TextureManager;
import lostclones.map.structures.Road;
import lostclones.players.Player;

public class Maps {
    private static final Maps instance = new Maps();

    private Maps() {}

    HashMap<String, LCMap> maps = new HashMap<String, LCMap>();

    public static Maps getInstance() {
        return instance;
    }

    public void setupMaps() {
        TextureManager.getInstance().setTexture("general", new Texture("general.png", 32, 32));

        SpriteManager sm = SpriteManager.getInstance();
        sm.setSprite("grass", new Sprite("general", "tile", 0, 0));
        sm.setSprite("grass2", new Sprite("general", "tile", 1, 0));
        sm.setSprite("pawn", new Sprite("general", 2, 0));
        sm.setSprite("road", new Sprite("general", 3, 0));
        sm.setSprite("archer", new Sprite("general", 4, 0));
        sm.setSprite("knight", new Sprite("general", 5, 0));
        sm.setSprite("selected", new Sprite("general", 0, 1));
        sm.setSprite("selectedMove", new Sprite("general", 1, 1));
        sm.setSprite("selectedAttack", new Sprite("general", 2, 1));
        sm.setSprite("add", new Sprite("general", 0, 2));
        sm.setSprite("remove", new Sprite("general", 1, 2));


        LCMap map1 = new LCMap(32,32);
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                if (i == 3 || j == 3) {
                    map1.setTile(i, j, new Tile("grass2", i, j));
                } else {
                    map1.setTile(i, j, new Tile("grass", i, j));
                }
            }
        }

        Player human = new Player("human1");
        Player neutral = new Player("neutral");
        Player ai1 = new Player("ai1");
        map1.addPlayer(human);
        map1.addPlayer(neutral);
        map1.addPlayer(ai1);

        neutral.addStructure(new Road("neutral", 3,4));
        neutral.addStructure(new Road("neutral", 3,5));
        //human.addUnit(new Pawn("human1", 3,4));
        //ai1.addUnit(new Pawn("ai1", 14,12));

        maps.put("first", map1);
    }

    public LCMap getMap(String mapName) {
        if (maps.containsKey(mapName)) {
            return maps.get(mapName);
        }
        return null;
    }
}
