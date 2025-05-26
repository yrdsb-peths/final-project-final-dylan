import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Enemy
{
    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Zombie(double health, double damage, int speed) {
        super(health, damage, speed);
        if(health >= 200 && damage <= 30 && speed <= 1) {
            //setImage("images/tankZombie.png");
        }
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
