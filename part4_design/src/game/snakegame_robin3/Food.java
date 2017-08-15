package game.snakegame_robin3;

import game.snakegame_robin2.Global;
import game.snakegame_robin2.Snake;

import java.awt.*;
import java.util.Random;

/**
 * Created by robin on 2017/8/15.
 */
public class Food extends Point{
    //行为判断
    public boolean isEatBySnake(Snake snake){return false;};
    //根据判断结果做行为
    public void addFood(){
        x=new Random().nextInt(Global.CELL_WIDTH);
        y=new Random().nextInt(Global.CELL_HEIGHT);
    };
    //UI展示
    public void drawMe(Graphics2D g){
        System.out.println("食物正在绘制自己");
        g.setColor(Color.red);
        g.fill3DRect(x * Global.CELL_SIZE,
                y * Global.CELL_SIZE,
                Global.CELL_SIZE,
                Global.CELL_SIZE,
                true);

    };
}
