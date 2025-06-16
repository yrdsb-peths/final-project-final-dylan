import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Zombie: The basic enemy, only attacks via melee 
 * 
 * @author Tam 
 * @version 6/16/2025
 */
public class Zombie extends Enemy
{
    GreenfootImage norZom = new GreenfootImage("images/enemies/zombie.png");
    EnemySensor detectionCheck;
    private int setSpeed;
    
    public Zombie(double health, int speed) {
        super(health, speed);
        setImage(norZom);
        setSpeed = speed;
        detectionCheck = new EnemySensor(300);
    }
    
    Player player;
    public void act()
    {
        //To allow zombie to access player instance methods
        player = (Player)getWorld().getObjects(Player.class).get(0);
        getWorld().addObject(detectionCheck, getX(), getY());

        //Makes zombie either track the player or, if engaged is true, follow the player
        if(engaged == true) {
            turnTowards(player.getX(), player.getY());
            move(speed);
            //So then the Zombie can't phase through the blocks
            if(isTouching(Block.class)) {
                move(-speed);
            }
        } else {
            playerTrack();
        }
        //Mechanism to determine when it attacks: uses a distance formula
        if(atkCooldown.millisElapsed() > 500 && Math.hypot(Math.abs(getExactX() - player.getX()), (Math.abs(getExactY() - player.getY()))) < 20) {
            attack();
        }

        //Taking damage mechanisms
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
        speed = 0;
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
    
    /**
     * This method is to allow the zombie to continue moving after being hit or attacking,
     * and to reset the image back to normal if it has been hit.
     */
    public void ifHit() {
        if(hitTimer.millisElapsed() >= 200) {
            setImage(norZom);
        } 
        if(hitTimer.millisElapsed() >= 400 && atkCooldown.millisElapsed() >= 800) {
            speed = setSpeed;
        } 
    }
    
    /**
     * This method is to track the player before the zombie becomes engaged: Uses distance formula
     * and a line that tracks if it is touching a block (through a boolean variable in the actor 
     * "DetectionCheck").
     */
    public void playerTrack() {
        detectionCheck.setLocation((Math.abs(getX() + player.getX()) / 2), (Math.abs(getY() + player.getY()) / 2));
        detectionCheck.scale((int) Math.hypot(Math.abs(getExactX() - player.getX()), (Math.abs(getExactY() - player.getY()))), 2);
        detectionCheck.turnTowards(player.getX(), player.getY());
        if(!detectionCheck.isTouching && Math.hypot(Math.abs(getExactX() - player.getX()), (Math.abs(getExactY() - player.getY()))) < 150) {
            engaged = true;
        }
    }

    /**
     * This method is to attack the player: If within a certain range, it will create a hitbox that,
     * if the player is in, will take a certain amount of damage.
     */
    SimpleTimer atkCooldown = new SimpleTimer();
    HitScanEnemyZom enemyHitCheck;
    public void attack() {
        atkCooldown.mark();
        hitTimer.mark();
        enemyHitCheck = new HitScanEnemyZom();
        enemyHitCheck.setRotation(getRotation());
        getWorld().addObject(enemyHitCheck, getX(), getY());
        enemyHitCheck.move(5);
        speed = 0;
    }
}
