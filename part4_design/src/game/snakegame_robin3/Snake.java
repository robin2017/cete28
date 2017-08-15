package game.snakegame_robin3;


import java.awt.*;
import java.util.LinkedList;

/**
 * Created by robin on 2017/8/15.
 */

public class Snake {

    public LinkedList<Point> body=new LinkedList<Point>();
    private Direction direction= Direction.RIGHT;
    private boolean alive=true;
    private SnakeListener snakeListener;
    private Point old_tail;
    public void  setSnakeListener(SnakeListener snakeListener){
        this.snakeListener=snakeListener;
    }

    public Snake(){
        //最先插入的为first
        body.add(new Point(Global.CELL_WIDTH/2+1,Global.CELL_HEIGHT/2));
        body.add(new Point(Global.CELL_WIDTH/2,Global.CELL_HEIGHT/2));
        body.add(new Point(Global.CELL_WIDTH/2-1,Global.CELL_HEIGHT/2));
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    //move与changeDirection有关联
    public void move(){
        System.out.println("蛇动起来了");
        Point header=body.getFirst();
        Point next=getNext(header,direction);
        verfy(next);
        System.out.println("----"+next.x+":"+next.y);
        body.addFirst(next);
        old_tail=body.removeLast();
        snakeListener.snakeMoved(this);
        SnakeTest.gamePanel.repaint();
    }

    private void verfy(Point point) {
        if(point.x<0)
            point.x+=Global.CELL_WIDTH;
        if(point.x>=Global.CELL_WIDTH)
            point.x-=Global.CELL_WIDTH;
        if(point.y<0)
            point.y+=Global.CELL_HEIGHT;
        if(point.y>=Global.CELL_HEIGHT)
            point.y-=Global.CELL_HEIGHT;
    }

    private Point getNext(Point header, game.snakegame_robin3.Direction direction) {
        Point res=new Point(header.x,header.y);
        switch(direction){
            case UP:
                res.y--;
                break;
            case DOWN:
                res.y++;
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
    public void changeDirection(Direction direction){
        System.out.println("#######change dir:"+direction);
        this.direction=direction;
    };
    //行为判断
    public boolean isTouchFood(Food food){
        Point header=body.getFirst();
        if(header.x==food.x&&header.y==food.y)
            return true;
        return false;};
    public boolean isTouchGround(Ground ground){
        Point header=body.getFirst();
        if(header.x==ground.x&&header.y==ground.y)
            return true;
        return false;};
    public boolean isTouchSelf(){
        Point header=body.getFirst();
        int flag=1;
        for(Point p:body)
            if(header.x==p.x&&header.y==p.y)
                flag--;
        return flag==0?false:true;};
    //根据判断结果做行为
    public void eatFood(Food food){
        body.addLast(old_tail);
    };
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
        while(true&&snake.isAlive()){
            snake.move();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
