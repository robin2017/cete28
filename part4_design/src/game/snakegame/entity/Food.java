package game.snakegame.entity;

import game.snakegame.util.Global;

import java.awt.*;
import java.util.Random;

public class Food extends Point{
	public boolean isEatBySnake(Snake snake){
		System.out.println("判断蛇是否碰到了食物...");
		if(snake.getHeader().x==x && snake.getHeader().y==y)
			return true;
		return false;
	}
	public void drawMe(Graphics2D g){
		System.out.println("食物正在画出自己...");
		g.setColor(Color.red);
		g.fill3DRect(x*Global.CELL_SIZE,
				y*Global.CELL_SIZE,
				Global.CELL_SIZE,
				Global.CELL_SIZE,
				true);
	}
	public void addFood(){
		x = new Random().nextInt(Global.CELL_WIDTH);
		y = new Random().nextInt(Global.CELL_HEIGHT);
	}
}
