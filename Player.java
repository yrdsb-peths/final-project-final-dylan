import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Player: The main character that you control.
 * 
 * @author Tam
 * @version 6/16/2025
 */
public class Player extends SmoothMover
{    
    //Basic stats of the player
    public static double health;
    public static int money = 0;
    private static double speed;
    
    //Equipment the player has
    private boolean pickaxeEquip;
    private boolean gunEquip;
    public static int ammoCount;    
    private boolean daggerEquip;
    
    GreenfootImage player = new GreenfootImage("images/character/characterPlayer.png");
    GreenfootImage playerPick = new GreenfootImage("images/character/characterPlayerPickaxe.png");
    GreenfootImage playerGun = new GreenfootImage("images/character/characterPlayerGun.png");
    GreenfootImage playerKnife = new GreenfootImage("images/character/characterPlayerKnife.png");
    
    public Player() {
        setImage(player);
        health = 200.0;
        speed = 1.5;
        
        pickaxeEquip = true;
        gunEquip = false;
        ammoCount = 70;
        daggerEquip = false;
    }
    
    public void act()
    {
        //Movement mechanics
        if(Greenfoot.isKeyDown("w")) {
            setLocation(getExactX(), getExactY() - speed);
            if(isTouching(Block.class)) {
                setLocation(getExactX(), getExactY() + speed);
            }
        } else if(Greenfoot.isKeyDown("s")) {
            setLocation(getExactX(), getExactY() + speed);
            if(isTouching(Block.class)) {
                setLocation(getExactX(), getExactY() - speed);
            }
        }
        if(Greenfoot.isKeyDown("a")) {
            setLocation(getExactX() - speed, getExactY());
            if(isTouching(Block.class)) {
                setLocation(getExactX() + speed, getExactY());
            }
        } else if(Greenfoot.isKeyDown("d")) {
            setLocation(getExactX() + speed, getExactY());
            if(isTouching(Block.class)) {
                setLocation(getExactX() - speed, getExactY());
            }
        }
        
        //"inventory" keys
        if(Greenfoot.isKeyDown("1") && pickaxeEquip != true) {
            pickaxeEquip = true;
            gunEquip = false;
            daggerEquip = false;
            setImage(playerPick);
        }
        if(Greenfoot.isKeyDown("2") && gunEquip != true) {
            pickaxeEquip = false;
            gunEquip = true;
            daggerEquip = false;
            setImage(playerGun);
        }
        if(Greenfoot.isKeyDown("3") && daggerEquip != true) {
            pickaxeEquip = false;
            gunEquip = false;
            daggerEquip = true;
            setImage(playerKnife);
        }
        
        //attack mechanisms, specifically cooldowns
        if(gunEquip == true && gunCooldown == false && Greenfoot.mouseClicked(null)) {
            if(ammoCount > 0) {
                shootGun();
                atkCooldown.mark();
                gunCooldown = true;
            }
        }
        gunCooldown();
        if(daggerEquip == true && stabCooldown == false && Greenfoot.mouseClicked(null)) {
            stab();
            atkCooldown.mark();
            stabCooldown = true;
        }
        stabCooldown();
        if(pickaxeEquip == true && mineCooldown == false && Greenfoot.mouseClicked(null)) {
            mine();
            atkCooldown.mark();
            mineCooldown = true;
        }
        mineCooldown();
        
        //Methods that are called upon attacked
        if(isTouching(HitScanEnemyZom.class)) {
            meleeAttackedByZom();
        }
        if(isTouching(HitScanEnemyMiner.class)) {
            meleeAttackedByMiner();
        }
        if(isTouching(BulletMiner.class)) {
            shotByMiner();
        }
        
        //allows player to track the mouse
        MouseInfo m = Greenfoot.getMouseInfo();
        if(m != null) {
            turnTowards(m.getX(), m.getY());
        }

        //allows Player to transition from one world into the next
        if(isTouching(WorldTransition.class)) {
            finishLevel();
        }

        //droppables mechanism: if taken it will help you
        if(isTouching(HealthDrop.class)) {
            health += (10 + Greenfoot.getRandomNumber(10));
            removeTouching(HealthDrop.class);
        }
        if(isTouching(AmmoDrop.class)) {
            ammoCount += (1 + Greenfoot.getRandomNumber(10));   
            removeTouching(AmmoDrop.class);
        }
        
        //death mechanism
        if(health <= 0) {
            EndScreen deadEndScreen = new EndScreen();
            Greenfoot.setWorld(deadEndScreen);
        }
    }
    
    /**
     * Various Methods that dictate how the Player attacks/mines.
     */
    GreenfootSound gunShoot = new GreenfootSound("sounds/gunShoot1.wav");
    public void shootGun() {
        Bullet bullet = new Bullet();
        bullet.setRotation(getRotation());
        getWorld().addObject(bullet, getX(), getY());
        bullet.move(10);
        gunShoot.setVolume(70);
        gunShoot.play();
        ammoCount--;
    }
    HitScanPlayerMelee hitCheckMelee;
    GreenfootSound meleeAttempt = new GreenfootSound("sounds/meleeAttempt.wav");
    public void stab() {
        hitCheckMelee = new HitScanPlayerMelee();
        hitCheckMelee.setRotation(getRotation());
        getWorld().addObject(hitCheckMelee, getX(), getY());
        hitCheckMelee.move(9);
        meleeAttempt.setVolume(70);
        meleeAttempt.play();
    }
    HitScanPlayerMine hitCheckMine;
    public void mine() {
        hitCheckMine = new HitScanPlayerMine();
        hitCheckMine.setRotation(getRotation());
        getWorld().addObject(hitCheckMine, getX(), getY());
        hitCheckMine.move(15);
        meleeAttempt.setVolume(70);
        meleeAttempt.play();
    }
    
    /**
     * Various methods that dictate how attacking should be spaced out.
     */
    SimpleTimer atkCooldown = new SimpleTimer();
    private boolean gunCooldown;
    private void gunCooldown() {
        if(atkCooldown.millisElapsed() > 400) {
            gunCooldown = false;
        }
    }
    private boolean mineCooldown;
    private void mineCooldown() {
        if(atkCooldown.millisElapsed() > 750) {
            mineCooldown = false;
        }
    }
    private boolean stabCooldown;
    private void stabCooldown() {
        if(atkCooldown.millisElapsed() > 250) {
            stabCooldown = false;
        }
    }
    /**
     * Various Methods that dictate how the Player should react if attacked by different enemies.
     */
    SimpleTimer hitTimer = new SimpleTimer();
    public void meleeAttackedByZom() {
        removeTouching(HitScanEnemyZom.class);
        health -= 1 + Greenfoot.getRandomNumber(10);
        hitTimer.mark();
    }
    public void meleeAttackedByMiner() {
        removeTouching(HitScanEnemyMiner.class);
        health -= 1 + Greenfoot.getRandomNumber(20);
        hitTimer.mark();
    }
    public void shotByMiner() {
        removeTouching(BulletMiner.class);
        health -= 20 + Greenfoot.getRandomNumber(30);
        hitTimer.mark();
    }
    
    /**
     * Method that allows the world to be toggled from one to the next through a static variable.
     */
    public static int trigger = 0;
    public void finishLevel() {
        trigger = 1;
    }
}
