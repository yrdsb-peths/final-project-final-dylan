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

    GreenfootImage norZom = new GreenfootImage("images/enemies/zombie.png");
    EnemySensor detectionCheck;
    Player player;
    public Zombie(double health, double damage, int speed) {
        super(health, damage, speed);
        setImage(norZom);
        detectionCheck = new EnemySensor(300);
    }
    
    public void act()
    {
        player = (Player)getWorld().getObjects(Player.class).get(0);
        getWorld().addObject(detectionCheck, getX(), getY());
        if(engaged == true) {
            turnTowards(player.getX(), player.getY());
            move(speed);
            if(isTouching(Block.class)) {
                move(-speed);
            }
        } else {
            playerTrack();
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
    public void takeDamageBullet() {
        health -= 50.0;
        removeTouching(Bullet.class);
        hitTimer.mark();
        setImage("images/enemies/zombieDamaged.png");
    }
    public void takeDamagePickaxe() {
        health -= 140.0 + Greenfoot.getRandomNumber(100);
        removeTouching(HitScanPlayerMine.class);
        hitTimer.mark();
        setImage("images/enemies/zombieDamaged.png");
    }
    int slashCritRoll;
    public void takeDamageMelee() {
        slashCritRoll = Greenfoot.getRandomNumber(50);
        removeTouching(HitScanPlayer.class);
        hitTimer.mark();
        if(Greenfoot.getRandomNumber(50) == slashCritRoll) {
            health -= 1000.0;
        }
        health -= 30.0;
        setImage("images/enemies/zombieDamaged.png");
    }
    public void ifHit() {
        if(hitTimer.millisElapsed() >= 200) {
            setImage(norZom);
        } 
    }
    public void playerTrack() {
        detectionCheck.setLocation((Math.abs(getX() + player.getX()) / 2), (Math.abs(getY() + player.getY()) / 2));
        detectionCheck.scale((int) Math.hypot(Math.abs(getExactX() - player.getX()), (Math.abs(getExactY() - player.getY()))), 2);
        detectionCheck.turnTowards(player.getX(), player.getY());
        if(!detectionCheck.isTouching && Math.hypot(Math.abs(getExactX() - player.getX()), (Math.abs(getExactY() - player.getY()))) < 100) {
            engaged = true;
        }
    }
    
    SimpleTimer atkCooldown = new SimpleTimer();
}
