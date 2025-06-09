import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelFour here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelFour extends World
{

    /**
     * Constructor for objects of class LevelFour.
     * 
     */
    GreenfootImage level4 = new GreenfootImage("images/level 4.png");
    
    public LevelFour()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 900, 1); 
        setBackground(level4);
    }
}
