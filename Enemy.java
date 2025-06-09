import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //Basic enemy stasts
    public double health;
    public double damage;
    public int speed;
    private boolean engaged;
    
    public Enemy(double health, double damage, int speed) {
        this.health = health;
        this.damage = damage;
        this.speed = speed;
    }
    
    public void act()
    {
        if(isTouching(Bullet.class)) {
            takeDamageBullet();
        }
        if(isTouching(HitScanBox.class)) {
            takeDamageMelee();
        }
        if(health < 0) {
            getWorld().removeObject(this);
        }
    }
    
    public void takeDamageBullet() {
        removeTouching(Bullet.class);
        health -= 50;
    }
    public void takeDamageMelee() {
        health -= 30;
    }
}
