import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ore extends Block
{
    /**
     * Act - do whatever the Ore wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int health;
    public int value;
    public Ore(int health, int value) {
        this.health = health;
        this.value = value;
    }
    
    GreenfootSound pickaxeStrike = new GreenfootSound("sounds/blockHit1.wav");
    GreenfootSound pickaxeStrike2 = new GreenfootSound("sounds/blockHit2.wav");
    public void pickaxeStrike() {
        removeTouching(HitScanPlayerMine.class);
        health -= 70;
        if(Greenfoot.getRandomNumber(100) % 2 == 0) {
            pickaxeStrike.setVolume(70);
            pickaxeStrike.play();
        } else {
            pickaxeStrike2.setVolume(70);
            pickaxeStrike2.play();
        }
    }
    GreenfootSound mined = new GreenfootSound("sounds/blockBreak1.wav");
    GreenfootSound mined2 = new GreenfootSound("sounds/blockBreak2.wav");
    public void mined() {
        removeTouching(HitScanPlayerMine.class);
        if(Greenfoot.getRandomNumber(100) % 2 == 0) {
            mined.setVolume(70);
            mined.play();
        } else {
            mined2.setVolume(70);
            mined2.play();
        }
        Player.money += value;
        getWorld().removeObject(this);
    }
}
