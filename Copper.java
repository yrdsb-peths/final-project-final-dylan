import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Copper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Copper extends Ore
{
    /**
     * Act - do whatever the Copper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Copper() {
        super(75 + Greenfoot.getRandomNumber(100), 100 + Greenfoot.getRandomNumber(200));
        setImage("images/blocks/copperOre.png");
    }
    
    public void act()
    {
        if(isTouching(HitScanPlayerMine.class) && health > 0) {
            pickaxeStrike();
        }
        if(health < health / 2) {
            //setImage("images/blocks/copperOreBreaking.png");
        }
        if(health <= 0) {
            mined();
        }
    }
}
