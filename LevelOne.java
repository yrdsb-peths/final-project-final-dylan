import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelOne extends World
{

    /**
     * Constructor for objects of class LevelOne.
     * 
     */
    GreenfootImage level1 = new GreenfootImage("images/level 1.png");
    public LevelOne()
    {    
        super(600, 500, 1); 
        setBackground("images/level 1.png");
        Block d = new Dirt(40, 40, 10, 10);
        addObject(d, 40, 40);
    }
}
