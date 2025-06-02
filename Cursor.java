import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cursor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cursor extends SmoothMover
{
    public void act()
    {
        MouseInfo m = Greenfoot.getMouseInfo();
        setLocation(m.getX(), m.getY());
    }
}
