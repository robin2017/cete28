package game.snakegame_robin2;

import java.awt.*;
import java.util.Random;

/**
 * Created by robin on 2017/8/15.
 */
public class Ground extends Point{
    public void addGround(){
        x=new Random().nextInt(Global.CELL_WIDTH);
        y=new Random().nextInt(Global.CELL_HEIGHT);
    };
    public void drawMe(Graphics2D g){
        System.out.println("障碍物正在画出自己");
        g.setColor(Color.yellow);
        g.fill3DRect(x * Global.CELL_SIZE,
                y * Global.CELL_SIZE,
                Global.CELL_SIZE,
                Global.CELL_SIZE,
                true);
    };
}
