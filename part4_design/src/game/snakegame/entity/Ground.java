package game.snakegame.entity;

import game.snakegame.util.Global;

import java.awt.*;
import java.util.Random;

public class Ground extends Point {
	public boolean isEatRock(Snake snake){
		System.out.println("蛇判断是否碰到了障碍物...");
		Point header=Snake.getHeader();
		if(x==header.x&&y==header.y)
			return true;
		return false;
	}
	public void drawMe(Graphics2D g){
		System.out.println("障碍物正在画出自己...");
		g.setColor(Color.yellow);
		g.fill3DRect(x * Global.CELL_SIZE,
				y * Global.CELL_SIZE,
				Global.CELL_SIZE,
				Global.CELL_SIZE, true);

	}
	public void addGround(){
		x = new Random().nextInt(Global.CELL_WIDTH);
		y = new Random().nextInt(Global.CELL_HEIGHT);
	}
}

