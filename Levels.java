import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Levels here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Levels extends World
{

    /**
     * Constructor for objects of class Levels.
     * 
     */
    Player player;
    public int xCoord;
    public int yCoord;
    public Levels(int width, int height, int cellSize)
    {    
        super(width, height, cellSize); 
    }
    
    public Levels getLevel() {
        return this;
    }
    public int getX() {
        xCoord = player.getX();
        return xCoord;
    }
    public int getY() {
        yCoord = player.getY();
        return yCoord;
    }
    
    public void finishLevel() {
        double moneyToPayHealth = 20 * (200 - Player.health);
        double ammoToPayFor = 30 * (70 - Player.ammoCount);
        if(Player.money > moneyToPayHealth && Greenfoot.ask("Refill Health for: " + moneyToPayHealth).equals("yes")) {
            Player.health = 200;
            Player.money -= moneyToPayHealth;
        }
        if(Player.money > ammoToPayFor && Greenfoot.ask("Refill Ammo for: " + ammoToPayFor).equals("yes")) {
            Player.ammoCount = 70;
            Player.money -= ammoToPayFor;
        }
        Player.trigger = 0;
    }
}
