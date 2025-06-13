import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Diamond here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Diamond extends Ore
{
    /**
     * Act - do whatever the Diamond wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Diamond() {
        super(1400 + Greenfoot.getRandomNumber(400), 7000 + Greenfoot.getRandomNumber(2000));
        setImage("images/blocks/diamondOre.png");
    }
    
    public void act()
    {
        if(isTouching(HitScanPlayerMine.class) && health > 0) {
            pickaxeStrike();
        }
        if(health < health * (2 / 3)) {
            //setImage("images/blocks/diamondOreBreaking.png");
        }
        if(health < health / 3) {
            //setImage("images/blocks/diamondOreBreaking2.png");
        }
        if(health <= 0) {
            mined();
        }
    }
}
