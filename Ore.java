import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ores: The money that you will mine with your pickaxe.  Contains a given health
 * and value, the latter of which will be added to the total money the player has.
 * 
 * @author Tam 
 * @version 6/16/2025
 */
public class Ore extends Block
{
    public int health;
    public int value;
    public Ore(int health, int value) {
        this.health = health;
        this.value = value;
    }

    //When player creates a hitbox with the pickaxe that intersects with the given ore
    public void pickaxeStrike() {
        removeTouching(HitScanPlayerMine.class);
        health -= 70;
    }

    //When given ore is destroyed
    public void mined() {
        removeTouching(HitScanPlayerMine.class);
        Player.money += value;
        getWorld().removeObject(this);
    }
}
