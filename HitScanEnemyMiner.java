import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HitScanEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HitScanEnemyMiner extends Actor
{
    /**
     * Act - do whatever the HitScanEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    SimpleTimer removal = new SimpleTimer();
    public HitScanEnemyMiner() {
        setImage("images/hitScanBox.png");
        removal.mark();
    }
    public void act()
    {
        if(removal.millisElapsed() > 40){
            getWorld().removeObject(this);
        }
    }
}
