import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Enemy extends SmoothMover
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //Basic enemy stasts
    public double health;
    public double damage;
    public int speed;
    public boolean engaged;
    
    public Enemy(double health, double damage, int speed) {
        this.health = health;
        this.damage = damage;
        this.speed = speed;
    }
    
    public abstract void takeDamageBullet();
    public abstract void takeDamageMelee();
    public abstract void takeDamagePickaxe();
    public abstract void playerTrack();
}
