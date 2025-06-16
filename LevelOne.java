import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelOne extends Levels
{

    /**
     * Constructor for objects of class LevelOne.
     * 
     */
    GreenfootImage level1 = new GreenfootImage("images/level 1.png");
    Block dirt;
    Block stone;
    Player player;
    public LevelOne()
    {    
        super(600, 500, 1); 
        setBackground(level1);
        player = new Player();
        addObject(player, 26, 256);
        prepareBlocks();
        prepareObjects();
        prepareEntities();
        UserInterface ui = new UserInterface();
        addObject(ui, 60, 30);
        addObject(new WorldTransition(5, 40), 600, 250);
    }

    public void act() {
        if(Player.trigger == 1) {
            finishLevel();
        }
    }
    
    Zombie zombie;
    Miner miner;
    private void prepareEntities() {
        addObject(new Zombie(100.0, 1), 90, 185);
        addObject(new Zombie(100.0, 1), 60, 185);
        addObject(new Zombie(100.0, 1), 95, 95);

        addObject(new Zombie(100.0, 1), 30, 384);
        addObject(new Zombie(100.0, 1), 30, 384);
        addObject(new Zombie(100.0, 1), 60, 324);
        addObject(new Zombie(100.0, 1), 90, 324);
        addObject(new Zombie(100.0, 1), 150, 324);
        addObject(new Zombie(100.0, 1), 150, 444);
        addObject(new Zombie(100.0, 1), 180, 444);
        addObject(new Miner(150.0, 1), 60, 476);

        addObject(new Zombie(50.0, 2), 520, 30);
        addObject(new Zombie(50.0, 2), 520, 84);
        addObject(new Zombie(50.0, 2), 520, 144);
        addObject(new Zombie(50.0, 2), 420, 164);

        addObject(new Zombie(100.0, 1), 200, 75);
        addObject(new Zombie(100.0, 1), 280, 75);
        addObject(new Zombie(150.0, 1), 150, 276);
        addObject(new Zombie(200.0, 1), 300, 276);
        addObject(new Zombie(200.0, 1), 340, 376);
        addObject(new Miner(150.0, 1), 560, 246);
    }

    Ore copper;
    Ore iron;
    Ore silver;
    private void prepareObjects() {
        addObject(new Copper(), 57, 156);
        addObject(new Copper(), 57, 156);
        addObject(new Iron(), 27, 156);
        addObject(new Iron(), 27, 156);
        addObject(new Copper(), 87 , 156);
        addObject(new Silver(), 27, 186);
        addObject(new Silver(), 27, 186);
        addObject(new Iron(), 27, 186);
        addObject(new Silver(), 27, 100);

        addObject(new Copper(), 60, 240);
        addObject(new Copper(), 120, 273);
        addObject(new Iron(), 310, 173);
        addObject(new Iron(), 310, 203);
        addObject(new Iron(), 310, 203);
        addObject(new Copper(), 310, 143);
        addObject(new Copper(), 310, 143);
        addObject(new Copper(), 370, 273);
        addObject(new Copper(), 370, 303);
        addObject(new Copper(), 370, 333);
        addObject(new Silver(), 240, 74);
        addObject(new Copper(), 370, 333);
        addObject(new Iron(), 470, 443);
        addObject(new Iron(), 470, 443);
        addObject(new Iron(), 420, 443);
        addObject(new Iron(), 420, 443);
        addObject(new Copper(), 520, 314);
        addObject(new Copper(), 520, 314);

        addObject(new Copper(), 30, 324);
        addObject(new Copper(), 30, 324);
        addObject(new Iron(), 30, 354);
        addObject(new Iron(), 30, 354);
        addObject(new Iron(), 60, 354);
        addObject(new Iron(), 60, 384);
        addObject(new Iron(), 90, 354);
        addObject(new Silver(), 150, 384);
        addObject(new Silver(), 180, 384);
        addObject(new Silver(), 150, 414);
        addObject(new Silver(), 180, 414);
        addObject(new Iron(), 284, 354);
        addObject(new Iron(), 284, 384);
        addObject(new Iron(), 284, 324);
        addObject(new Copper(), 30, 475);
        addObject(new Copper(), 30, 475);
        addObject(new Copper(), 30, 445);
        addObject(new Copper(), 60, 445);
        addObject(new Copper(), 90, 445);

        addObject(new Copper(), 520, 114);
        addObject(new Copper(), 490, 114);
        addObject(new Copper(), 490, 144);
        addObject(new Copper(), 490, 84);
        addObject(new Copper(), 460, 114);
        addObject(new Silver(), 480, 34);
        addObject(new Silver(), 480, 34);
        addObject(new Silver(), 450, 34);
        addObject(new Silver(), 450, 34);
        addObject(new Silver(), 420, 34);
    }

    private void prepareBlocks() {
        dirt = new Dirt(5, 125);
        addObject(dirt, 9, 143);
        dirt = new Dirt(100, 5);
        addObject(dirt, 60, 203);
        dirt = new Dirt(28, 5);
        addObject(dirt, 100, 80);
        dirt = new Dirt(75, 5);
        addObject(dirt, 45, 80);
        dirt = new Dirt(5, 65);
        addObject(dirt, 111, 168);
        dirt = new Dirt(5, 35);
        addObject(dirt, 111, 95);

        stone = new Stone(120, 15);
        addObject(stone, 60, 215);
        stone = new Stone(7, 80);
        addObject(stone, 120, 180);
        stone = new Stone(270, 50);
        addObject(stone, 257, 30);
        stone = new Stone(7, 80);
        addObject(stone, 118, 55);
        stone = new Stone(10, 80);
        addObject(stone, 148, 55);
        stone.setRotation(45);        

        stone = new Stone(140, 160);
        addObject(stone, 245, 175);
        stone = new Stone(105, 165);
        addObject(stone, 421, 305);

        dirt = new Dirt(5, 186);
        addObject(dirt, 12, 399);
        dirt = new Dirt(205, 5);
        addObject(dirt, 120, 306);
        dirt = new Dirt(290, 5);
        addObject(dirt, 157, 492);
        dirt = new Dirt(5, 186);
        addObject(dirt, 301, 399);

        stone = new Stone(225, 9);
        addObject(stone, 108, 297);
        stone = new Stone(55, 13);
        addObject(stone, 288, 297);
        stone = new Stone(10, 210);
        addObject(stone, 310, 397);

        stone = new Stone(250, 40);
        addObject(stone, 440, 457);
        stone = new Stone(85, 200);
        addObject(stone, 560, 370);
        stone = new Stone(220, 45);
        addObject(stone, 500, 208);

        dirt = new Dirt(190, 5);
        addObject(dirt, 495, 14);
        dirt = new Dirt(190, 5);
        addObject(dirt, 495, 182);
        dirt = new Dirt(5, 170);
        addObject(dirt, 588, 100);
        dirt = new Dirt(5, 68);
        addObject(dirt, 398, 50);
        dirt = new Dirt(5, 68);
        addObject(dirt, 398, 150);
        stone = new Stone(25, 68);
        addObject(stone, 380, 50);
        stone = new Stone(25, 108);
        addObject(stone, 381, 170);
    }

    public void finishLevel() {
        super.finishLevel();
        LevelTwo levelTwo = new LevelTwo();
        Greenfoot.setWorld(levelTwo);
    }
}
