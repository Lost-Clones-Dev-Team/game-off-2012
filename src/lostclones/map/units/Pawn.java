package lostclones.map.units;


public class Pawn extends Unit{

    public Pawn(String newPlayer, int newX, int newY) {
        super(newPlayer, newX, newY);
        setSprite("pawn");
    }
}
