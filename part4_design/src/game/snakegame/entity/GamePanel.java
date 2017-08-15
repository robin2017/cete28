package game.snakegame.entity;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{
	private Snake snake;
	private Food food;
	private Ground ground;
	
	public GamePanel(Snake snake, Food food, Ground ground) {
		super();
		this.snake = snake;
		this.food = food;
		this.ground = ground;
	}
	public Snake getSnake() {
		return snake;
	}
	public void setSnake(Snake snake) {
		this.snake = snake;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public Ground getGround() {
		return ground;
	}
	public void setGround(Ground ground) {
		this.ground = ground;
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		snake.drawMe(g2);
		food.drawMe(g2);
		ground.drawMe(g2);
	}
}
