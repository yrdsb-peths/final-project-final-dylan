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
    EnemySensor detectionCheck;
    Player player;
    GreenfootImage regular = new GreenfootImage("images/enemies/miner.png");
    private int setSpeed;
    public Miner(double health, int speed) {
        super(health, speed);
        detectionCheck = new EnemySensor(300);
        setImage(regular);
        setSpeed = speed;
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
        if(atkCooldown.millisElapsed() > 1000 && Math.hypot(Math.abs(getExactX() - player.getX()), (Math.abs(getExactY() - player.getY()))) < 20) {
            attack();
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
            getWorld().addObject(new HealthDrop(), getX(), getY());
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
        setImage("images/enemies/minerDamaged.png");
    }
    GreenfootSound mineMiner = new GreenfootSound("sounds/miningStab1.wav");
    GreenfootSound mineMiner2 = new GreenfootSound("sounds/miningStab2.wav");
    public void takeDamagePickaxe() {
        health -= 70.0 + Greenfoot.getRandomNumber(50);
        removeTouching(HitScanPlayerMine.class);
        hitTimer.mark();
        if(Greenfoot.getRandomNumber(100) % 2 == 0) {
            mineMiner.setVolume(70);
            mineMiner.play();
        } else {
            mineMiner2.setVolume(70);
            mineMiner2.play();
        }
        setImage("images/enemies/minerDamaged.png");
    }
    GreenfootSound stabMiner1 = new GreenfootSound("sounds/daggerStab1.wav");
    GreenfootSound stabMiner2 = new GreenfootSound("sounds/daggerStab2.wav");
    public void takeDamageMelee() {
        removeTouching(HitScanPlayer.class);
        hitTimer.mark();
        health -= 40.0 + Greenfoot.getRandomNumber(60);
        if(Greenfoot.getRandomNumber(100) % 2 == 0) {
            stabMiner1.setVolume(70);
            stabMiner1.play();
        } else {
            stabMiner2.setVolume(70);
            stabMiner2.play();
        }
        setImage("images/enemies/minerDamaged.png");
    }
    public void ifHit() {
        if(hitTimer.millisElapsed() >= 200) {
            setImage(regular);
        } 
        if(hitTimer.millisElapsed() >= 400 && atkCooldown.millisElapsed() >= 800) {
            speed = setSpeed;
        } 
    }
    public void playerTrack() {
        detectionCheck.setLocation((Math.abs(getX() + player.getX()) / 2), (Math.abs(getY() + player.getY()) / 2));
        detectionCheck.scale((int) Math.hypot(Math.abs(getExactX() - player.getX()), (Math.abs(getExactY() - player.getY()))), 2);
        detectionCheck.turnTowards(player.getX(), player.getY());
        if(!detectionCheck.isTouching && Math.hypot(Math.abs(getExactX() - player.getX()), (Math.abs(getExactY() - player.getY()))) < 200) {
            engaged = true;
        }
    }
    
    SimpleTimer atkCooldown = new SimpleTimer();
    HitScanEnemyMiner enemyHitCheck;
    public void attack() {
        atkCooldown.mark();
        hitTimer.mark();
        enemyHitCheck = new HitScanEnemyMiner();
        enemyHitCheck.setRotation(getRotation());
        getWorld().addObject(enemyHitCheck, getX(), getY());
        enemyHitCheck.move(6);
        speed = 0;
    }
}
