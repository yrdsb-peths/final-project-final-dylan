import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(900, 800, 1);
        Player player = new Player();
        addObject(player, 300, 200);
        
    }
}
