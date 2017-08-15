package game.snakegame_robin2;



import javax.swing.*;
import java.awt.*;

/**
 * Created by robin on 2017/8/15.
 */

public class GamePanel extends JPanel {
    private  Snake snake;
    private  Food food;
    private  Ground ground;
    public GamePanel(Snake snake, Food food, Ground ground) {
        super();
        this.snake = snake;
        this.food = food;
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