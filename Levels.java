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
    
    public int getX() {
        xCoord = player.getX();
        return xCoord;
    }
    public int getY() {
        yCoord = player.getY();
        return yCoord;
    }
}
