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
    
    public Dirt(int x, int y, int w, int h) {
        super();
        GreenfootImage model = new GreenfootImage(w, h);
        model.drawRect(x, y, w, h);
        model.fillRect(x, y, w, h);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
