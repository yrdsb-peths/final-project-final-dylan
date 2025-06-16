import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UserInterface here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UserInterface extends Actor
{
    /**
     * Act - do whatever the UserInterface wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Label health;
    Label ammo;
    Label money;
    public UserInterface() {
        setImage("images/userInterface.png");
        health = new Label("HP: " + Player.health, 20);
        ammo = new Label("Ammo: " + Player.ammoCount, 20);
        money = new Label("Money: " + Player.money, 20);
    }
    
    public void act()
    {
        getWorld().addObject(health, getX(), getY() - 10);        
        getWorld().addObject(ammo, getX(), getY() + 10);        
        getWorld().addObject(money, getX(), getY() + 30);
        health.setValue("HP: " + Player.health);
        ammo.setValue("Ammo: " + Player.ammoCount);
        money.setValue("Money: " + Player.money);
    }
}
