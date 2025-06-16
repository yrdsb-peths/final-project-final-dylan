import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bullet: The player's ranged projectile accessed through their gun.
 * 
 * @author Tam
 * @version 6/16/2025
 */
public class Bullet extends SmoothMover
{
    public Bullet() {
        setImage("images/bullet.png");
    }
    
    public void act()
    {
        move(10);
        //If the bullet is at the edge of the world or collides with a
        //block class, it will delete itself
        if(isAtEdge()) {
            getWorld().removeObject(this);
        } else if(isTouching(Block.class)) {
            getWorld().removeObject(this);
        }
    }
}
