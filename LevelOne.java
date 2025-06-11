import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelOne extends World
{

    /**
     * Constructor for objects of class LevelOne.
     * 
     */
    GreenfootImage level1 = new GreenfootImage("images/level 1.png");
    Block dirt;
    Block stone;
    public LevelOne()
    {    
        super(600, 500, 1); 
        setBackground("images/level 1.png");
        prepare();
    }
    
    private void prepare() {
        dirt = new Dirt(5, 198);
        addObject(dirt, 10, 107);
        dirt = new Dirt(100, 5);
        addObject(dirt, 60, 203);
        dirt = new Dirt(100, 5);
        addObject(dirt, 60, 10);
        dirt = new Dirt(5, 65);
        addObject(dirt, 111, 168);
        dirt = new Dirt(5, 95);
        addObject(dirt, 111, 55);
        
        stone = new Stone(120, 15);
        addObject(stone, 60, 215);
        stone = new Stone(7, 80);
        addObject(stone, 120, 180);
        stone = new Stone(270, 40);
        addObject(stone, 257, 40);
        
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
    }
}
