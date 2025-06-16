import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        Player.money = 0;
        setBackground("images/TitleScreen.png");
    }
    public void act() {
        if(Greenfoot.isKeyDown("space")) {
            LevelOne levelOne = new LevelOne();
            Greenfoot.setWorld(levelOne);
        }
        if(Greenfoot.isKeyDown("a")) {
            setBackground("images/controlsAndGameplayScreen.png");
        } 
        if(Greenfoot.isKeyDown("escape")) {
            setBackground("images/TitleScreen.png");
        }
    }
}
