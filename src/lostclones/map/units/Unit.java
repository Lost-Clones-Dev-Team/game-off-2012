package lostclones.map.units;

import lostclones.images.Sprite;

public abstract class Unit {

    private int attackRadius = 1;
    private int sightRadius = 3;
    private int maxHP = 1;
    private int curHP = 1;
    private int damage = 1;

    private int maxAP = 1;
    private int curAP = 1;

    private int x;
    private int y;

    private Sprite sprite;


    public void setAttackRadius(int newAttackRadius) {
        if (newAttackRadius >= 0) {
            attackRadius = newAttackRadius;
        }
    }

    public int getAttackRadius() {
        return attackRadius;
    }

    public void setSightRadius(int newSightRadius) {
        if (newSightRadius >= 0) {
            sightRadius = newSightRadius;
        }
    }

    public int getSightRadius() {
        return sightRadius;
    }

    public void setMaxHP(int newMaxHP) {
        if (newMaxHP > 0) {
            maxHP = newMaxHP;
        }
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setCurHP(int newCurHP) {
        if (newCurHP > 0 && newCurHP <= maxHP) {
            curHP = newCurHP;
        }
    }

    public int getCurHP() {
        return curHP;
    }

    public void setDamage(int newDamage) {
        if (newDamage >= 0) {
            damage = newDamage;
        }
    }

    public int getDamage() {
        return damage;
    }

    public void setX(int newX) {
        x = newX;
    }

    public int getX() {
        return x;
    }

    public void setY(int newY) {
        y = newY;
    }

    public int getY() {
        return y;
    }

    public void setMaxAP(int newMaxAP) {
        if (newMaxAP > 0) {
            maxAP = newMaxAP;
        }
    }

    public int getMaxAP() {
        return maxAP;
    }

    public void setCurAP(int newCurAP) {
        if (newCurAP >= 0 && newCurAP <= maxAP) {
            curAP = newCurAP;
        }
    }

    public int getCurAP() {
        return curAP;
    }

    public void setSprite(Sprite newSprite) {
        sprite = newSprite;
    }

    public Sprite getSprite() {
        return sprite;
    }

}
