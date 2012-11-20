package lostclones.players;

import java.util.ArrayList;

import lostclones.map.structures.Structure;
import lostclones.map.units.Unit;
import lostclones.players.ai.AI;

public class Player {

    private ArrayList<Unit> units;
    private ArrayList<Structure> structures;
    private String name;

    private AI ai;

    public Player(String newName) {
        name = newName;
        units = new ArrayList<Unit>();
        structures = new ArrayList<Structure>();
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public void removeUnit(Unit unit) {
        if (units.contains(unit)) {
            units.remove(unit);
        }
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public void addStructure(Structure structure) {
        structures.add(structure);
    }

    public void removeStructure(Structure structure) {
        if (structures.contains(structure)) {
            structures.remove(structure);
        }
    }

    public ArrayList<Structure> getStructures() {
        return structures;
    }

    public void setAI(AI newAI) {
        ai = newAI;
    }

    public AI getAI() {
        return ai;
    }

    public boolean hasAI() {
        return ai != null;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }
}
