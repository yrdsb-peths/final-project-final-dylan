import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GunMiner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GunMiner extends Miner
{
    /**
     * Act - do whatever the GunMiner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Player player;
    GreenfootImage gunMiner = new GreenfootImage("images/enemies/minerGun.png");
    public GunMiner(double health) {
        super(health, 0);
        detectionCheck = new EnemySensor(300);
        setImage(gunMiner);
    }
    
    public void act()
    {
        player = (Player)getWorld().getObjects(Player.class).get(0);
        getWorld().addObject(detectionCheck, getX(), getY());
        if(engaged == true) {
            turnTowards(player.getX(), player.getY());
            if(atkCooldown.millisElapsed() > 1500 && Math.hypot(Math.abs(getExactX() - player.getX()), (Math.abs(getExactY() - player.getY()))) < 800) {
                attack();
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
            getWorld().addObject(new AmmoDrop(), getX(), getY());
            getWorld().removeObject(this);
        }
        ifHit();
    }
    
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
        setImage("images/enemies/minerGunDamaged.png");
    }
    public void takeDamageMelee() {
        health -= 160.0 + Greenfoot.getRandomNumber(50);
        removeTouching(HitScanPlayerMine.class);
        hitTimer.mark();
        setImage("images/enemies/minerGunDamaged.png");
    }
    public void takeDamagePickaxe() {
        removeTouching(HitScanPlayer.class);
        hitTimer.mark();
        health -= 40.0 + Greenfoot.getRandomNumber(60);
        setImage("images/enemies/minerGunDamaged.png");
    }
    public void playerTrack() {
        detectionCheck.setLocation((Math.abs(getX() + player.getX()) / 2), (Math.abs(getY() + player.getY()) / 2));
        detectionCheck.scale((int) Math.hypot(Math.abs(getExactX() - player.getX()), (Math.abs(getExactY() - player.getY()))), 2);
        detectionCheck.turnTowards(player.getX(), player.getY());
        if(!detectionCheck.isTouching && Math.hypot(Math.abs(getExactX() - player.getX()), (Math.abs(getExactY() - player.getY()))) < 1200) {
            engaged = true;
        }
    }
    SimpleTimer hitTimer = new SimpleTimer();
    public void ifHit() {
        if(hitTimer.millisElapsed() >= 200) {
            setImage(gunMiner);
        } 
    }
    
    SimpleTimer atkCooldown = new SimpleTimer();
    public void attack() {
        atkCooldown.mark();
        BulletMiner bullet = new BulletMiner();
        bullet.setRotation(getRotation());
        getWorld().addObject(bullet, getX(), getY());
        bullet.move(10);
    }
}
