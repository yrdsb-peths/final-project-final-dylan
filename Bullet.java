import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends SmoothMover
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Bullet() {
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
