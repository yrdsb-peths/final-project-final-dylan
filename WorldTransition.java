import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldTransition here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldTransition extends Actor
{
    /**
     * Act - do whatever the WorldTransition wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage box = new GreenfootImage("images/worldTransitBox.png");
    
    public WorldTransition(int w, int h) {
        setImage(box);
        box.scale(w, h);
    }
}
