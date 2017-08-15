package game.snakegame;

import game.snakegame.controller.SnakeController;
import game.snakegame.entity.Food;
import game.snakegame.entity.GamePanel;
import game.snakegame.entity.Ground;
import game.snakegame.entity.Snake;
import game.snakegame.util.Global;

import javax.swing.*;


public class SnakeGameTest {
	public static void main(String[] args) {
		JFrame frame = new JFrame("SNAKE_version1.0");
		frame.setSize(Global.CELL_WIDTH*Global.CELL_SIZE+10,Global.CELL_HEIGHT*Global.CELL_SIZE+10);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Snake snake = new Snake();
		Food food = new Food();
		Ground ground = new Ground();
		GamePanel gamePanel = new GamePanel(snake,food,ground);
		gamePanel.setSize(Global.CELL_SIZE*Global.CELL_WIDTH,Global.CELL_SIZE*Global.CELL_WIDTH);
		SnakeController sc = new SnakeController(snake, ground, food, gamePanel);
		gamePanel.setFocusable(true);
		gamePanel.addKeyListener(sc);
		snake.setSnakeListener(sc);

		frame.add(gamePanel);
		frame.setVisible(true);
		snake.begin();
		food.addFood();
		ground.addGround();
	}
}
