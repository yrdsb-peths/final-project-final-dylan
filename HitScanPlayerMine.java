import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HitScanPlayerMine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HitScanPlayerMine extends HitScanPlayer
{
    /**
     * Act - do whatever the HitScanPlayerMine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    SimpleTimer removal = new SimpleTimer();
    public HitScanPlayerMine() {
        setImage("images/hitScanBoxMine.png");
        removal.mark();
    }
    public void act()
    {
        if(removal.millisElapsed() > 40){
            getWorld().removeObject(this);
        }
    }
}
