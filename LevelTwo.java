import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelTwo extends Levels
{

    /**
     * Constructor for objects of class LevelTwo.
     * 
     */
    GreenfootImage level2 = new GreenfootImage("images/level 2.png");
    Block dirt;
    Block stone;
    Player player;
    public LevelTwo()
    {    
        super(700, 700, 1); 
        setBackground(level2);
        player = new Player();
        addObject(player, 25, 376);
        prepareBlocks();
        prepareObjects();
        prepareEntities();
        UserInterface ui = new UserInterface();
        addObject(ui, 60, 30);
        addObject(new WorldTransition(5, 40), 698, 495);
    }
     
    public void act() {
        if(Player.trigger == 1) {
            finishLevel();
        }
    }
    
    Zombie zombie;
    Miner miner;
    public void prepareEntities() {
        addObject(new Zombie(150, 2), 170, 270);
        addObject(new Zombie(150, 2), 235, 320);
        addObject(new Zombie(150, 2), 235, 360);
        addObject(new Zombie(150, 2), 240, 460);
        addObject(new Miner(150, 1), 110, 365);
        addObject(new Miner(150, 1), 410, 365);
        addObject(new Miner(150, 1), 470, 395);
        addObject(new Miner(150, 1), 470, 495);
        addObject(new GunMiner(150), 402, 525);
        addObject(new GunMiner(150), 402, 655);
        addObject(new GunMiner(150), 442, 205);
        addObject(new Miner(150, 1), 482, 205);
        addObject(new Miner(150, 1), 482, 45);
        addObject(new Miner(150, 1), 452, 105);
        
        addObject(new Miner(200, 1), 252, 45);
        addObject(new Miner(200, 1), 352, 45);
        addObject(new Miner(200, 1), 322, 75);
        addObject(new Zombie(150, 2), 225, 160);
        addObject(new Miner(200, 1), 144, 75);
        addObject(new Miner(200, 1), 154, 145);
        addObject(new GunMiner(250), 322, 145);
        
        addObject(new Miner(200, 1), 326, 245);
        addObject(new Miner(200, 1), 326, 285);
        addObject(new Miner(200, 1), 326, 205);
        addObject(new Miner(200, 1), 56, 230);
        addObject(new Miner(200, 1), 126, 230);
        
        addObject(new Miner(200, 1), 126, 485);
        addObject(new Miner(200, 1), 146, 485);
        addObject(new Miner(200, 1), 56, 505);
        addObject(new Miner(200, 1), 76, 510);
        addObject(new Miner(200, 1), 356, 510);
        
        addObject(new Miner(200, 1), 36, 670);
        addObject(new Miner(200, 1), 36, 570);
        addObject(new Miner(200, 1), 36, 630);
        addObject(new Miner(200, 1), 126, 642);
        addObject(new Miner(200, 1), 165, 632);
        addObject(new GunMiner(250), 70, 670);
        
        addObject(new Miner(200, 1), 495, 640);
        addObject(new Miner(200, 1), 455, 640);
        addObject(new Miner(200, 1), 445, 580);
        addObject(new Miner(200, 1), 535, 570);
        addObject(new Miner(200, 1), 635, 570);
        addObject(new GunMiner(300), 565, 670);
        addObject(new Miner(200, 1), 635, 670);
        addObject(new GunMiner(300), 630, 495);
        addObject(new GunMiner(300), 680, 495);
        
        addObject(new GunMiner(300), 550, 365);
        addObject(new GunMiner(300), 550, 40);
        addObject(new GunMiner(300), 670, 95);
        addObject(new Miner(300, 1), 670, 175);
        addObject(new Miner(300, 1), 635, 205);
        addObject(new Miner(300, 1), 575, 180);
        addObject(new Miner(300, 1), 545, 210);
        addObject(new Miner(300, 1), 605, 150);
        addObject(new Miner(300, 1), 605, 270);
        addObject(new Miner(300, 1), 605, 70);
        addObject(new Miner(300, 1), 635, 70);
        addObject(new Miner(300, 1), 635, 395);
        addObject(new Miner(300, 1), 605, 455);
    }
    Ore Copper;
    Ore Iron;
    Ore Silver;
    Ore Gold;
    Ore Diamond;
    public void prepareObjects() {
        addObject(new Silver(), 100, 330);
        addObject(new Copper(), 100, 330);
        addObject(new Copper(), 100, 330);
        addObject(new Silver(), 80, 425);
        addObject(new Copper(), 80, 425);
        addObject(new Copper(), 80, 425);
        addObject(new Silver(), 80, 365);
        addObject(new Iron(), 80, 365);
        addObject(new Iron(), 380, 330);
        addObject(new Iron(), 380, 330);
        addObject(new Silver(), 380, 425);
        addObject(new Copper(), 380, 425);
        addObject(new Copper(), 380, 425);
        addObject(new Iron(), 430, 230);
        addObject(new Iron(), 430, 230);
        addObject(new Iron(), 514, 260);
        addObject(new Iron(), 514, 260);
        addObject(new Iron(), 514, 200);
        addObject(new Silver(), 514, 200);
        addObject(new Iron(), 514, 200);
        addObject(new Iron(), 470, 430);
        addObject(new Iron(), 470, 430);
        addObject(new Iron(), 470, 430);
        addObject(new Iron(), 500, 420);
        addObject(new Iron(), 500, 420);
        addObject(new Iron(), 500, 420);
        addObject(new Copper(), 433, 525);
        addObject(new Copper(), 433, 525);
        addObject(new Copper(), 463, 525);
        addObject(new Copper(), 463, 525);
        addObject(new Copper(), 493, 525);
        addObject(new Copper(), 493, 525);
        addObject(new Copper(), 380, 555);
        addObject(new Copper(), 380, 555);
        addObject(new Copper(), 410, 555);
        addObject(new Copper(), 410, 555);
        addObject(new Iron(), 380, 585);
        addObject(new Iron(), 380, 585);
        addObject(new Iron(), 410, 585);
        addObject(new Iron(), 410, 585);
        addObject(new Silver(), 450, 65);
        addObject(new Silver(), 480, 85);
        
        addObject(new Copper(), 28, 485);
        addObject(new Copper(), 28, 485);
        addObject(new Gold(), 88, 485);
        addObject(new Silver(), 178, 485);
        addObject(new Silver(), 208, 485);
        addObject(new Copper(), 268, 485);
        addObject(new Copper(), 268, 485);
        addObject(new Copper(), 268, 485);
        addObject(new Copper(), 268, 485);
        addObject(new Copper(), 308, 507);
        addObject(new Copper(), 308, 507);
        
        addObject(new Gold(), 88, 585);
        addObject(new Gold(), 88, 615);       
        addObject(new Silver(), 58, 615);
        addObject(new Silver(), 58, 615);
        addObject(new Silver(), 118, 615);
        addObject(new Silver(), 118, 615);
        addObject(new Gold(), 88, 645);
        addObject(new Copper(), 88, 645);
        addObject(new Copper(), 197, 635);
        addObject(new Copper(), 197, 635);
        addObject(new Copper(), 197, 665);
        addObject(new Copper(), 197, 665);
        addObject(new Copper(), 167, 665);
        addObject(new Copper(), 167, 665);
        
        addObject(new Copper(), 205, 290);
        addObject(new Copper(), 205, 290);
        addObject(new Copper(), 235, 290);
        addObject(new Gold(), 265, 220);
        addObject(new Gold(), 295, 220);
        addObject(new Gold(), 265, 250);
        addObject(new Gold(), 295, 250);
        addObject(new Gold(), 285, 280);
        addObject(new Silver(), 120, 200);
        addObject(new Silver(), 120, 200);
        addObject(new Silver(), 90, 230);
        addObject(new Silver(), 90, 200);
        addObject(new Silver(), 30, 200);
        addObject(new Silver(), 30, 200);
        addObject(new Copper(), 24, 200);
        addObject(new Copper(), 54, 200);
        addObject(new Copper(), 24, 290);
        
        addObject(new Diamond(), 145, 40);
        addObject(new Iron(), 175, 40);
        addObject(new Iron(), 175, 40);
        addObject(new Iron(), 175, 40);
        addObject(new Iron(), 175, 70);
        addObject(new Iron(), 175, 70);
        addObject(new Iron(), 175, 70);
        addObject(new Gold(), 285, 38);
        addObject(new Gold(), 315, 38);
        addObject(new Gold(), 285, 68);
        addObject(new Gold(), 285, 98);
        addObject(new Gold(), 285, 144);
        
        addObject(new Diamond(), 663, 38);
        addObject(new Gold(), 663, 68);
        addObject(new Gold(), 663, 68);
        addObject(new Iron(), 603, 38);
        addObject(new Iron(), 603, 38);
        addObject(new Iron(), 603, 38);
        addObject(new Iron(), 633, 38);
        addObject(new Iron(), 633, 38);
        addObject(new Iron(), 633, 38);
        addObject(new Iron(), 603, 38);
        addObject(new Iron(), 633, 38);
        addObject(new Silver(), 603, 208);
        addObject(new Silver(), 603, 238);
        addObject(new Silver(), 573, 238);
        addObject(new Silver(), 573, 208);
        addObject(new Silver(), 573, 268);
        addObject(new Silver(), 603, 178);
        addObject(new Iron(), 663, 200);
        addObject(new Iron(), 663, 200);
        addObject(new Iron(), 663, 230);
        addObject(new Iron(), 663, 260);
        addObject(new Iron(), 663, 260);
        addObject(new Iron(), 633, 260);
        addObject(new Iron(), 633, 230);
        addObject(new Gold(), 663, 418);
        addObject(new Gold(), 663, 418);
        addObject(new Gold(), 633, 418);
        addObject(new Gold(), 633, 418);
        addObject(new Copper(), 549, 418);
        addObject(new Copper(), 549, 418);
        addObject(new Copper(), 549, 418);
        addObject(new Copper(), 549, 388);
        addObject(new Copper(), 549, 388);
        addObject(new Copper(), 549, 388);
        
        addObject(new Diamond(), 667, 670);
        addObject(new Iron(), 637, 640);
        addObject(new Iron(), 637, 640);
        addObject(new Iron(), 637, 640);
        addObject(new Iron(), 667, 640);
        addObject(new Iron(), 667, 640);
        addObject(new Iron(), 667, 640);
        addObject(new Silver(), 500, 600);
        addObject(new Silver(), 500, 600);
        addObject(new Silver(), 530, 600);
        addObject(new Silver(), 470, 600);
        addObject(new Silver(), 470, 570);
        addObject(new Silver(), 500, 570);
        addObject(new Gold(), 500, 672);
        addObject(new Gold(), 500, 672);
        addObject(new Gold(), 530, 672);
        addObject(new Gold(), 530, 642);
        addObject(new Gold(), 470, 672);
    }
    
    public void prepareBlocks() {
        stone = new Stone(225, 25);
        addObject(stone, 107, 324);     
        stone = new Stone(175, 25);
        addObject(stone, 342, 324);        
        stone = new Stone(75, 155);
        addObject(stone, 392, 244);        
        stone = new Stone(12, 80);
        addObject(stone, 424, 34);        
        stone = new Stone(13, 80);
        addObject(stone, 424, 158);        
        stone = new Stone(100, 30);
        addObject(stone, 474, 13);        
        stone = new Stone(18, 100);
        addObject(stone, 518, 52);
        stone = new Stone(18, 400);
        addObject(stone, 518, 346);
        stone = new Stone(100, 10);
        addObject(stone, 468, 543);
        stone = new Stone(10, 50);
        addObject(stone, 422, 563);
        stone = new Stone(10, 90);
        addObject(stone, 422, 663);
        stone = new Stone(225, 45);
        addObject(stone, 107, 440);
        stone = new Stone(190, 45);
        addObject(stone, 357, 440);
        stone = new Stone(70, 45);
        addObject(stone, 418, 450);
        stone = new Stone(160, 185);
        addObject(stone, 301, 623);
        
        dirt = new Dirt(5, 130);
        addObject(dirt, 6, 245);
        dirt = new Dirt(213, 5);
        addObject(dirt, 112, 307);
        dirt = new Dirt(200, 5);
        addObject(dirt, 108, 180);
        dirt = new Dirt(100, 5);
        addObject(dirt, 300, 180);
        dirt = new Dirt(95, 5);
        addObject(dirt, 302, 307);
        dirt = new Dirt(5, 130);
        addObject(dirt, 347, 245);
        stone = new Stone(100, 15);
        addObject(stone, 300, 170);
        stone = new Stone(100, 15);
        addObject(stone, 155, 170);
        
        dirt = new Dirt(5, 140);
        addObject(dirt, 127, 90);
        dirt = new Dirt(290, 5);
        addObject(dirt, 273, 20);
        dirt = new Dirt(170, 5);
        addObject(dirt, 333, 160);
        dirt = new Dirt(80, 5);
        addObject(dirt, 168, 160);
        dirt = new Dirt(5, 40);
        addObject(dirt, 415, 137);
        dirt = new Dirt(5, 60);
        addObject(dirt, 415, 48);
        
        dirt = new Dirt(5, 410);
        addObject(dirt, 680, 228);
        dirt = new Dirt(5, 290);
        addObject(dirt, 531, 288);
        dirt = new Dirt(5, 80);
        addObject(dirt, 531, 61);
        dirt = new Dirt(55, 5);
        addObject(dirt, 558, 434);
        dirt = new Dirt(55, 5);
        addObject(dirt, 653, 434);
        dirt = new Dirt(152, 5);
        addObject(dirt, 606, 21);
        stone = new Stone(70, 105);
        addObject(stone, 552, 490);
        stone = new Stone(40, 35);
        addObject(stone, 601, 530);
        stone = new Stone(105, 40);
        addObject(stone, 679, 459);
        stone = new Stone(50, 37);
        addObject(stone, 683, 529);
        
        dirt = new Dirt(255, 5);
        addObject(dirt, 555, 689);
        dirt = new Dirt(5, 140);
        addObject(dirt, 684, 620);
        dirt = new Dirt(30, 5);
        addObject(dirt, 671, 551);
        dirt = new Dirt(190, 5);
        addObject(dirt, 526, 551);
        dirt = new Dirt(5, 35);
        addObject(dirt, 430, 572);
        dirt = new Dirt(5, 74);
        addObject(dirt, 430, 653);
        
        dirt = new Dirt(110, 5);
        addObject(dirt, 319, 467);
        dirt = new Dirt(215, 5);
        addObject(dirt, 115, 467);
        dirt = new Dirt(190, 5);
        addObject(dirt, 283, 523);
        dirt = new Dirt(140, 5);
        addObject(dirt, 84, 523);
        dirt = new Dirt(5, 60);
        addObject(dirt, 10, 495);
        dirt = new Dirt(5, 20);
        addObject(dirt, 376, 512);
        dirt = new Dirt(5, 5);
        addObject(dirt, 376, 472);
        stone = new Stone(150, 13);
        addObject(stone, 78, 535);
        stone = new Stone(90, 13);
        addObject(stone, 233, 535);
        
        dirt = new Dirt(143, 5);
        addObject(dirt, 82, 544);
        dirt = new Dirt(33, 5);
        addObject(dirt, 200, 544);
        dirt = new Dirt(207, 5);
        addObject(dirt, 113, 685);
        dirt = new Dirt(5, 140);
        addObject(dirt, 214, 614);
        dirt = new Dirt(5, 140);
        addObject(dirt, 12, 614);
    }
    
    public void finishLevel() {
        super.finishLevel();
        EndScreen endScreen = new EndScreen();
        Greenfoot.setWorld(endScreen);
    }
}
