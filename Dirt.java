import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Dirt: barrier, cannot cross
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
    
    GreenfootImage dirt = new GreenfootImage("images/blocks/dirt.png");
    public Dirt(int w, int h) {
        dirt.scale(w, h);
        setImage(dirt);
    }
}
