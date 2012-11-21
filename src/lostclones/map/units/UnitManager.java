package lostclones.map.units;

import java.util.HashMap;

public class UnitManager {
    private static final UnitManager instance = new UnitManager();

    private HashMap<String, Unit> units = new HashMap<String, Unit>();

    private UnitManager() {}

    public static UnitManager getInstance() {
        return instance;
    }

    public void setupUnits() {
        units.put("pawn", new Pawn("neutral", -1,-1));
        units.put("archer", new Archer("neutral", -1,-1));
        units.put("knight", new Knight("neutral", -1,-1));
    }

    public String[] getListOfUnits() {
        String[] unitNames = new String[units.keySet().size()];
        int i = 0;
        for (String key : units.keySet()) {
            unitNames[i] = key;
            i ++;
        }
        return unitNames;
    }

    public Unit createUnit(String name) {
        Unit unit = null;

        if (name.equals("pawn")) {
            unit = new Pawn("neutral", -1, -1);
        } else if (name.equals("archer")) {
            unit = new Archer("neutral", -1, -1);
        } else if (name.equals("knight")) {
            unit = new Knight("neutral", -1, -1);
        }
        return unit;
    }

    public Unit getUnit(String name) {
        Unit unit = null;

        if (units.containsKey(name)) {
            unit = units.get(name);
        }

        return unit;
    }
}
