import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends World
{

    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    public EndScreen()
    {    
        super(600, 600, 1); 
        if(Player.health <= 0) {
            setBackground("images/endScreenDead.png");
        } else {
            setBackground("images/endScreenWin.png");
        }
        Label moneyEarned = new Label("You made: " + Player.money, 30);
        addObject(moneyEarned, getWidth() / 2, getHeight() / 2);
        Greenfoot.stop();
    }
}
