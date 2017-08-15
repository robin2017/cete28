package game.snakegame_robin2;


import java.awt.*;
import java.util.LinkedList;

import static game.snakegame_robin2.Direction.*;

/**
 * Created by robin on 2017/8/15.
 */

public class Snake {

    public LinkedList<Point> body=new LinkedList<Point>();
    public Direction direction= RIGHT;


    public Snake(){
        //最先插入的为first
        body.add(new Point(Global.CELL_WIDTH/2+1,Global.CELL_HEIGHT/2));
        body.add(new Point(Global.CELL_WIDTH/2,Global.CELL_HEIGHT/2));
        body.add(new Point(Global.CELL_WIDTH/2-1,Global.CELL_HEIGHT/2));
    }
    //move与changeDirection有关联
    public void move(){
        System.out.println("蛇动起来了");
        Point header=body.getFirst();
        Point next=getNext(header,direction);
        System.out.println("----"+next.x+":"+next.y);
        body.addFirst(next);
        body.removeLast();
        SnakeTest.gamePanel.repaint();
    }

    private Point getNext(Point header, Direction direction) {
        Point res=new Point(header.x,header.y);
        switch(direction){
            case UP:
                res.y++;
                break;
            case DOWN:
                res.y--;
                break;
            case LEFT:
                res.x--;
                break;
            case RIGHT:
                res.x++;
                break;
        }
        return res;
    }
    public void changeDirection(Direction direction){};
    //行为判断
    public boolean isTouchFood(){return false;};
    public boolean isTouchGround(Ground ground){return false;};
    public boolean isTouchSelf(){return false;};
    //根据判断结果做行为
    public void eatFood(Food food){};
    //UI展示
    public void drawMe(Graphics2D g){
        System.out.println("蛇正在画出自己");
        g.setColor(Color.blue);
        for(Point p:body)
            g.fill3DRect(p.x * Global.CELL_SIZE,
                    p.y * Global.CELL_SIZE,
                    Global.CELL_SIZE,
                    Global.CELL_SIZE,
                    true);
    };
}

class SnakeDriver implements Runnable{
    private Snake snake;
    public SnakeDriver(Snake snake){
        this.snake=snake;
    }
    @Override
    public void run() {
        while(true){
            snake.move();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
