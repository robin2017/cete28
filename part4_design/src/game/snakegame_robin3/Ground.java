package game.snakegame_robin3;

import game.snakegame_robin2.Global;

import java.awt.*;
import java.util.Random;

/**
 * Created by robin on 2017/8/15.
 */
public class Ground extends Point{
    public void addGround(){
        x=new Random().nextInt(game.snakegame_robin3.Global.CELL_WIDTH);
        y=new Random().nextInt(game.snakegame_robin2.Global.CELL_HEIGHT);
    };
    public void drawMe(Graphics2D g){
        System.out.println("障碍物正在画出自己");
        g.setColor(Color.yellow);
        g.fill3DRect(x * game.snakegame_robin2.Global.CELL_SIZE,
                y * game.snakegame_robin2.Global.CELL_SIZE,
                game.snakegame_robin2.Global.CELL_SIZE,
                Global.CELL_SIZE,
                true);
    };
}
