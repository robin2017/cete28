package game.snakegame.controller;

import game.snakegame.entity.Food;
import game.snakegame.entity.GamePanel;
import game.snakegame.entity.Ground;
import game.snakegame.entity.Snake;
import game.snakegame.listener.SnakeListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeController extends KeyAdapter implements SnakeListener{
	private Snake snake;
	private Ground ground;
	private Food food;
	private GamePanel gamePanel;
	public SnakeController(Snake snake, Ground ground, Food food,
			GamePanel gamePanel) {
		super();
		this.snake = snake;
		this.ground = ground;
		this.food = food;
		this.gamePanel = gamePanel;
	}
	@Override
	public void snakeMoved() {
		if(snake.isEatBySelf()){
			Snake.alive=false;
			System.out.println("+++++++++++++++++++++++++++++++++++++++");
			System.out.println("+++++++    you touch youself  +++++++++");
			System.out.println("+++++++++++    Game over    +++++++++++");
			System.out.println("+++++++++++++++++++++++++++++++++++++++");
		}
		if(food.isEatBySnake(snake)){
			snake.eatFood(food);
			food.addFood();
		}
		if(ground.isEatRock(snake)){
			Snake.alive=false;
			System.out.println("+++++++++++++++++++++++++++++++++++++++");
			System.out.println("+++++++    you touch ground  +++++++++");
			System.out.println("+++++++++++    Game over    +++++++++++");
			System.out.println("+++++++++++++++++++++++++++++++++++++++");
		}
		//�ػ�
		gamePanel.repaint();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_UP:
			if(Snake.direction+Snake.UP!=0)
				snake.changeDirection(Snake.UP);
			break;
		case KeyEvent.VK_DOWN:
			if(Snake.direction+Snake.DOWN!=0)
			 	snake.changeDirection(Snake.DOWN);
			break;
		case KeyEvent.VK_LEFT:
			if(Snake.direction+Snake.LEFT!=0)
				snake.changeDirection(Snake.LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			if(Snake.direction+Snake.RIGHT!=0)
				snake.changeDirection(Snake.RIGHT);
			break;
		}
	}
}
