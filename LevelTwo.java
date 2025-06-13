import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelTwo extends Levels
{

    /**
     * Constructor for objects of class LevelTwo.
     * 
     */
    GreenfootImage level2 = new GreenfootImage("images/level 2.png");
    Block dirt;
    Block stone;
    Player player;
    public LevelTwo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 700, 1); 
        setBackground(level2);
    }
}
