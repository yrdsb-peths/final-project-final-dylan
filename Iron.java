import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Iron here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Iron extends Ore
{
    /**
     * Act - do whatever the Iron wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Iron() {
        super(500 + Greenfoot.getRandomNumber(500), 200 + Greenfoot.getRandomNumber(200));
        setImage("images/blocks/ironOre.png");
    }
    
    public void act()
    {
        if(isTouching(HitScanPlayerMine.class) && health > 0) {
            pickaxeStrike();
        }
        if(health < health * (2 / 3)) {
            //setImage("images/blocks/ironOreBreaking.png");
        }
        if(health < health / 3) {
            //setImage("images/blocks/ironOreBreaking2.png");
        }
        if(health <= 0) {
            mined();
        }
    }
}
