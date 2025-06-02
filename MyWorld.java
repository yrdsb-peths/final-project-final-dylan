import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1);
        Player player = new Player();
        addObject(player, 300, 200);
        Cursor cursor = new Cursor();
        addObject(cursor, player.getX(), player.getY());
    }
}
