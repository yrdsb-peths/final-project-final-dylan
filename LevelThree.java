import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelThree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelThree extends Levels
{

    /**
     * Constructor for objects of class LevelThree.
     * 
     */
    GreenfootImage level3 = new GreenfootImage("images/level 3.png");
    Block dirt;
    Block stone;
    Player player;
    public LevelThree()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 600, 1); 
        setBackground(level3);
    }
}
