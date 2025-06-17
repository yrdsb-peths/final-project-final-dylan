import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ores: The money that you will mine with your pickaxe.  Contains a given health
 * and value, the latter of which will be added to the total money the player has.
 * 
 * @author Tam 
 * @version 6/16/2025
 */
public class Ore extends Block
{
    public int health;
    public int value;
    public Ore(int health, int value) {
        this.health = health;
        this.value = value;
    }
    
    //When player creates a hitbox with the pickaxe that intersects with the given ore
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

    //When given ore is destroyed
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
