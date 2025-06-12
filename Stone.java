import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stone here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stone extends Block
{
    /**
     * Act - do whatever the Stone wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage stone = new GreenfootImage("images/blocks/stone.png");
    public Stone(int w, int h) {
        stone.scale(w, h);
        setImage(stone);
    } 
    public void act()
    {
        // Add your action code here.
    }
}
