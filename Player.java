import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends SmoothMover
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int money = 0;
    
    //Basic stats of the player
    public static double health;
    private static int armourLevel;
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
    
    //Cooldowns for attacking
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
    
    public Player() {
        setImage(player);
        health = 100.0;
        armourLevel = 0;
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
        
        //attack mechanisms
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
        
        //if attacked
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
        ifHit();
        
        if(isTouching(WorldTransition.class)) {
            finishLevel();
        }
    }
    
    public void shootGun() {
        Bullet bullet = new Bullet();
        bullet.setRotation(getRotation());
        getWorld().addObject(bullet, getX(), getY());
        bullet.move(10);
        ammoCount--;
    }
    HitScanPlayerMelee hitCheckMelee;
    public void stab() {
        //animate a stab motion
        hitCheckMelee = new HitScanPlayerMelee();
        hitCheckMelee.setRotation(getRotation());
        getWorld().addObject(hitCheckMelee, getX(), getY());
        hitCheckMelee.move(9);
    }
    HitScanPlayerMine hitCheckMine;
    public void mine() {
        //animate mine motion
        hitCheckMine = new HitScanPlayerMine();
        hitCheckMine.setRotation(getRotation());
        getWorld().addObject(hitCheckMine, getX(), getY());
        hitCheckMine.move(15);
    }
    
    SimpleTimer hitTimer = new SimpleTimer();
    public void meleeAttackedByZom() {
        removeTouching(HitScanEnemyZom.class);
        health -= 1 + Greenfoot.getRandomNumber(10);
        hitTimer.mark();
        if(pickaxeEquip == true) {
            //setImage("images/character/characterPlayerPickaxeDamaged.png");
        } else if(gunEquip == true) {
            //setImage("images/character/characterPlayerGunDamaged.png");
        } else if(daggerEquip == true) {
            //setImage("images/character/characterPlayerDaggerDamaged.png");
        }
    }
    public void meleeAttackedByMiner() {
        removeTouching(HitScanEnemyMiner.class);
        health -= 1 + Greenfoot.getRandomNumber(20);
        hitTimer.mark();
        if(pickaxeEquip == true) {
            //setImage("images/character/characterPlayerPickaxeDamaged.png");
        } else if(gunEquip == true) {
            //setImage("images/character/characterPlayerGunDamaged.png");
        } else if(daggerEquip == true) {
            //setImage("images/character/characterPlayerDaggerDamaged.png");
        }
    }
    public void shotByMiner() {
        removeTouching(BulletMiner.class);
        health -= 20 + Greenfoot.getRandomNumber(30);
        hitTimer.mark();
        if(pickaxeEquip == true) {
            //setImage("images/character/characterPlayerPickaxeDamaged.png");
        } else if(gunEquip == true) {
            //setImage("images/character/characterPlayerGunDamaged.png");
        } else if(daggerEquip == true) {
            //setImage("images/character/characterPlayerDaggerDamaged.png");
        }
    }
    
    public void ifHit() {
        if(hitTimer.millisElapsed() >= 200 && pickaxeEquip == true) {
            //setImage("images/character/characterPlayerPickaxe.png");
        } else if(hitTimer.millisElapsed() >= 200 && gunEquip == true) {
            //setImage("images/character/characterPlayerGun.png");
        } else if(hitTimer.millisElapsed() >= 200 && daggerEquip == true) {
            //setImage("images/character/characterPlayerDagger.png");
        }
    }
    
    public static int trigger = 0;
    public void finishLevel() {
        trigger = 1;
    }
}
