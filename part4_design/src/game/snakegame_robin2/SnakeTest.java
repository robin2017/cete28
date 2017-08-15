package game.snakegame_robin2;


import javax.swing.*;

/**
 * Created by robin on 2017/8/15.
 */
public class SnakeTest {
    public static GamePanel gamePanel;
    public static void main(String[] args) {

        JFrame frame = new JFrame("SNAKE_version1.0");
        frame.setSize(Global.CELL_WIDTH * Global.CELL_SIZE + 10,
                Global.CELL_HEIGHT * Global.CELL_SIZE + 10);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Snake snake = new Snake();
        Food food = new Food();
        food.addFood();
        Ground ground = new Ground();
        ground.addGround();
        gamePanel = new GamePanel(snake, food, ground);


        new Thread(new SnakeDriver(snake)).start();

        gamePanel.setSize(Global.CELL_SIZE * Global.CELL_WIDTH,
                Global.CELL_SIZE * Global.CELL_WIDTH);
        frame.add(gamePanel);
        frame.setVisible(true);

    }
}
