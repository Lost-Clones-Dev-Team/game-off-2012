package lostclones.map.structures;

import java.util.HashMap;

public class StructureManager {
    private static final StructureManager instance = new StructureManager();

    private HashMap<String, Structure> structures = new HashMap<String, Structure>();

    private StructureManager() {}

    public static StructureManager getInstance() {
        return instance;
    }

    public void setupStructures() {
        structures.put("road", new Road("neutral", -1, -1));
    }

    public String[] getListOfStructures() {
        String[] structureNames = new String[structures.keySet().size()];
        int i = 0;
        for (String key : structures.keySet()) {
            structureNames[i] = key;
            i ++;
        }
        return structureNames;
    }

    public Structure createStructure(String name) {
        Structure structure = null;

        if (name.equals("road")) {
            structure = new Road("neutral", -1, -1);
        }
        return structure;
    }

    public Structure getStructure(String name) {
        Structure structure = null;

        if (structures.containsKey(name)) {
            structure = structures.get(name);
        }

        return structure;
    }
}
