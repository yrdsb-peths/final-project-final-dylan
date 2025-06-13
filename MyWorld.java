import greenfoot.*;

public class MyWorld extends World {
    Block dirt;
    Block stone;
    public int xCoord;
    public int yCoord;
    Player player;
    public MyWorld() {
        super(900, 800, 1);
        Player player = new Player();
        addObject(player, 300, 200);
    }
}
