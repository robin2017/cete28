package game.snakegame.entity;

import game.snakegame.listener.SnakeListener;
import game.snakegame.util.Global;

import java.awt.*;
import java.util.LinkedList;

public class Snake {
	private SnakeListener snakeListener;
	public static final int LEFT = 1;
	public static final int RIGHT = -1;
	public static final  int UP = 2;
	public static final int DOWN = -2;
	public static int direction;
	private Point oldTail;
	public  static boolean alive=true;
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public static Point getHeader(){
		return body.getFirst();
	}
	private static LinkedList<Point> body = new LinkedList<Point>();
	public Snake(){
		int x = Global.CELL_WIDTH/2;
		int y = Global.CELL_HEIGHT/2;
		for(int i = 0; i < 3;i++){
			body.addFirst(new Point(x++,y));
		}
		this.direction = RIGHT;
	}
	public void setSnakeListener(SnakeListener snakeListener) {
		this.snakeListener = snakeListener;
	}
	public void move(){
		System.out.println("蛇正在移动...");
		oldTail = body.removeLast();
		int x = body.getFirst().x;
		int y = body.getFirst().y;
		switch (this.direction) {
			case UP:
				y--;
				break;
			case DOWN:
				y++;
				break;
			case LEFT:
				x--;
				break;
			case RIGHT:
				x++;
				break;
		}
		if(x<0)
			x+=Global.CELL_WIDTH;
		if(y<0)
			y+=Global.CELL_HEIGHT;
		x%=Global.CELL_WIDTH;
		y%=Global.CELL_HEIGHT;
		Point head = new Point(x,y);
		body.addFirst(head);
	}
	public void changeDirection(int direction){
		System.out.println("蛇正在改变方向...");
		this.direction = direction;
		System.out.println("---------::::" + direction);
	}
	public void eatFood(Food food){
		System.out.println("蛇正在吃食物...");
		body.add(oldTail);
		food.addFood();
	}
	public boolean isEatBySelf(){
		System.out.println("判断是否碰到了自己");
		Point head=getHeader();
		int flag=1;
		for(Point p:body)
			if(head.equals(p))
				flag--;
		return flag==0?false:true;
	}
	public void drawMe(Graphics2D g){
		System.out.println("蛇正在画出自己");
		g.setColor(Color.blue);
		for(Point p : body){
			g.fill3DRect(p.x*Global.CELL_SIZE, p.y*Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE, true);
		}

	}
	public void begin(){
		new Thread(new SnakeDriver()).start();
	}
	private class SnakeDriver implements Runnable{

		@Override
		public void run() {
			while(true&&alive){

				move();
				snakeListener.snakeMoved();
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
