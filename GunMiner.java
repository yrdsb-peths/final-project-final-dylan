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
    public GunMiner(double health) {
        super(health, 0);
        //setImage("images/enemies/minerGun.png");
    }
    public void act()
    {
        Player player = (Player)getWorld().getObjects(Player.class).get(0);
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
    
    public void takeDamageBullet() {
        super.takeDamageBullet();
        //setImage("images/enemies/minerGunDamaged");
    }
    public void takeDamageMelee() {
        super.takeDamageMelee();
        //setImage("images/enemies/minerGunDamaged");
    }
    public void takeDamagePickaxe() {
        super.takeDamagePickaxe();
        //setImage("images/enemies/minerGunDamaged");
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
    int bulletCritChance;
}
