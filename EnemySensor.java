import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemySensor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemySensor extends Actor
{
    /**
     * Act - do whatever the EnemySensor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean isTouching;
    GreenfootImage sensor = new GreenfootImage("images/sensor.png");
    public EnemySensor(int width) {
        setImage(sensor);
        sensor.scale(width, 2);
        isTouching = true;
    }
    
    public void act() {
        if(!isTouching(Block.class)) {
            isTouching = false;
        } else {
            isTouching = true;
        }
    }
    
    public void scale(int width, int height) {
        sensor.scale(width, height);
    }
}
