import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dirt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dirt extends Block
{
    /**
     * Act - do whatever the Dirt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage dirt = new GreenfootImage("images/dirt.png");;
    public Dirt(int w, int h) {
        dirt.scale(w, h);
        setImage(dirt);
    }
    
    public void act()
    {
        
    }
}
