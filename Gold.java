import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gold here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gold extends Ore
{
    /**
     * Act - do whatever the Gold wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Gold() {
        super(200 + Greenfoot.getRandomNumber(300), 1600 + Greenfoot.getRandomNumber(1000));
        setImage("images/blocks/goldOre.png");
    }
    
    public void act()
    {
        if(isTouching(HitScanPlayerMine.class) && health > 0) {
            pickaxeStrike();
        }
        if(health < health / 2) {
            //setImage("images/blocks/goldOreBreaking.png");
        }
        if(health <= 0) {
            mined();
        }
    }
}
