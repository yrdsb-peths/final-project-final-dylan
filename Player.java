import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends SmoothMover
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //Basic stats of the player
    private double health;
    private int armourLevel;
    private double stam;
    private double speed;
    
    //Equipment the player has
    private boolean pickaxeEquip = false;
    private boolean gunEquip = false;
    private int ammoCount = 70;    
    private boolean daggerEquip = false;
    
    MyWorld world = (MyWorld) getWorld();
    
    
    public Player() {
        setImage("images/characterPlayer.png");
        health = 100.0;
        armourLevel = 0;
        stam = 10.0;
        speed = 1.5;
    }
    
    public void act()
    {
        //Movement mechanics
        if(Greenfoot.isKeyDown("w")) {
            setLocation(getExactX(), getExactY() - speed);
        } else if(Greenfoot.isKeyDown("s")) {
            setLocation(getExactX(), getExactY() + speed);
        }
        if(Greenfoot.isKeyDown("a")) {
            setLocation(getExactX() - speed, getExactY());
        } else if(Greenfoot.isKeyDown("d")) {
            setLocation(getExactX() + speed, getExactY());
        }
        
        //"inventory" keys
        if(Greenfoot.isKeyDown("1") && pickaxeEquip != true) {
            pickaxeEquip = true;
            gunEquip = false;
            daggerEquip = false;
        }
        if(Greenfoot.isKeyDown("2") && gunEquip != true) {
            pickaxeEquip = false;
            gunEquip = true;
            daggerEquip = false;
        }
        if(Greenfoot.isKeyDown("3") && daggerEquip != true) {
            pickaxeEquip = false;
            gunEquip = false;
            daggerEquip = true;
        }
        
        //attack mechanisms
        if(gunEquip == true && Greenfoot.mouseClicked(true)) {
            if(ammoCount > 0) {
                shootGun();
            }
        }
        if(daggerEquip == true && Greenfoot.mouseClicked(true)) {
            stab();
        }
        if(pickaxeEquip == true && Greenfoot.mouseClicked(true)) {
            //mine();
        }
        
        //allows player to track the mouse
        MouseInfo m = Greenfoot.getMouseInfo();
        if(m != null) {
            turnTowards(m.getX(), m.getY());
        }
    }
    
    public void shootGun() {
        Bullet bullet = new Bullet();
        world.addObject(bullet, getX(), getY());
        bullet.setRotation(getRotation());
        ammoCount--;
    }
    
    HitScanBox c = new HitScanBox();
    public void stab() {
        world.addObject(c, getX(), getY());
        //animate a stab motion
        world.getObjectsAt(c.getX(), c.getY(), Enemy.class);
        
        world.removeObject(c);
    }
    public void mine() {
        
    }
}
