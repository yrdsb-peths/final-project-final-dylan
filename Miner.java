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
    public Miner(double health, double damage, int speed) {
        super(health, damage, speed);
    }
    public void act()
    {
        Player player = (Player)getWorld().getObjects(Player.class).get(0);
        
        if(engaged == true) {
            turnTowards(player.getX(), player.getY());
            move(speed);
            if(isTouching(Block.class)) {
                move(-speed);
            }
        }
        if(isTouching(Bullet.class)) {
            takeDamageBullet();
        }
        if(isTouching(HitScanPlayerMelee.class)) {
            takeDamageMelee();
        }
        if(isTouching(HitScanPlayerMine.class)) {
            takeDamagePickaxe();
        }
        if(health <= 0) {
            getWorld().removeObject(this);
        }
        ifHit();
    }
    
    SimpleTimer hitTimer = new SimpleTimer();
    int bulletCritChance;
    public void takeDamageBullet() {
        bulletCritChance = Greenfoot.getRandomNumber(50);
        if(Greenfoot.getRandomNumber(50) == bulletCritChance) {
            health -= 1000.0;
        } else {
            health -= 80.0;
        }
        removeTouching(Bullet.class);
        hitTimer.mark();
        //setImage("images/enemies/minerDamaged.png");
    }
    public void takeDamagePickaxe() {
        health -= 70.0 + Greenfoot.getRandomNumber(50);
        removeTouching(HitScanPlayerMine.class);
        hitTimer.mark();
        //setImage("images/enemies/minerDamaged.png");
    }
    public void takeDamageMelee() {
        removeTouching(HitScanPlayer.class);
        hitTimer.mark();
        health -= 40.0 + Greenfoot.getRandomNumber(60);
        //("images/enemies/minerDamaged.png");
    }
    public void ifHit() {
        if(hitTimer.millisElapsed() >= 200) {
            //setImage(miner);
        } 
    }
}
