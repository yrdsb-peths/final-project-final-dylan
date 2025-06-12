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
    
    public void act()
    {
        if(health >= 0) {
            mined();
        }
    }
    public void mined() {
        getWorld().removeObject(this);
        Player.money += value;
    }
}
