import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Miner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Miner extends Enemy
{
    /**
     * Act - do whatever the Miner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean ranged;
    
    public Miner(double health, double damage, int speed, boolean ranged) {
        super(health, damage, 0);
        this.ranged = ranged;
        if(ranged == true) {
            //setImage("images/gunMiner.png");
        } else {
            //setImage("images/meleeMiner.png");
        }
    }
    
    public Miner(double health, double damage, int speed) {
        super(health, damage, speed);
        ranged = false;
        //setImage("images/meleeMiner.png");
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
