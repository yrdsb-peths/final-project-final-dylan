import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BulletMiner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BulletMiner extends SmoothMover
{
    /**
     * Act - do whatever the BulletMiner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public BulletMiner() {
        setImage("images/bullet.png");
    }
    
    public void act()
    {
        move(10);
        if(isAtEdge()) {
            getWorld().removeObject(this);
        } else if(isTouching(Block.class)) {
            getWorld().removeObject(this);
        }
    }
}
