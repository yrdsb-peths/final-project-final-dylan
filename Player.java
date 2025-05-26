import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //Basic stats of the player
    public double health;
    public int armourLevel;
    public double stam;
    public int speed;
    
    //Equipment the player has
    private boolean pickaxeEquip = false;
    
    private boolean gunEquip = false;
    private int ammoCount = 70;
    
    private boolean daggerEquip = false;
    
    public Player() {
        setImage("images/characterPlayer.png");
        health = 100.0;
        armourLevel = 0;
        stam = 10.0;
        speed = 1;
    }
    
    public void act()
    {
        //Movement mechanics
        if(Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - speed);
        } else if(Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + speed);
        }
        if(Greenfoot.isKeyDown("a")) {
            setLocation(getX() - speed, getY());
        } else if(Greenfoot.isKeyDown("d")) {
            setLocation(getX() + speed, getY());
        }
        
        
        if(gunEquip == true) {
            //shootGun;
        }
    }
}
