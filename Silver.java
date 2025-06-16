import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Emerald here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Silver extends Ore
{
    /**
     * Act - do whatever the Emerald wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Silver() {
        super(300 + Greenfoot.getRandomNumber(400), 200 + Greenfoot.getRandomNumber(100));
        setImage("images/blocks/silverOre.png");
    }
    
    public void act()
    {
        if(isTouching(HitScanPlayerMine.class) && health > 0) {
            pickaxeStrike();
        }
        if(health <= 0) {
            mined();
        }
    }
}
