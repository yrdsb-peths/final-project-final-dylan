import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * BulletMiner: The bullet that is created by the GunMiner, will kill you!
 * 
 * @author Tam
 * @version 6/16/2025
 */
public class BulletMiner extends SmoothMover
{
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
