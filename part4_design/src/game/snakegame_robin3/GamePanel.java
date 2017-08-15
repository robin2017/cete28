package game.snakegame_robin3;



import javax.swing.*;
import java.awt.*;

/**
 * Created by robin on 2017/8/15.
 */

public class GamePanel extends JPanel {
    private game.snakegame_robin3.Snake snake;
    private game.snakegame_robin3.Food food;
    private game.snakegame_robin3.Ground ground;
    public GamePanel(game.snakegame_robin3.Snake snake, game.snakegame_robin3.Food food, game.snakegame_robin3.Ground ground) {
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