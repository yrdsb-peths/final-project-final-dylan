import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ore extends Block
{
    /**
     * Act - do whatever the Ore wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int health;
    public int value;
    public Ore(int health, int value) {
        this.health = health;
        this.value = value;
    }
    
    public void pickaxeStrike() {
        removeTouching(HitScanPlayerMine.class);
        health -= 70;
    }
    public void mined() {
        removeTouching(HitScanPlayerMine.class);
        Player.money += value;
        getWorld().removeObject(this);
    }
}
