package game.snakegame_robin3;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by robin on 2017/8/15.
 */
public class SnakeController extends KeyAdapter implements SnakeListener {
    private Snake snake;
    private Ground ground;
    private Food food;
    private GamePanel gamePanel;

    public SnakeController(Snake snake, Ground ground, Food food, GamePanel gamePanel) {
        this.snake = snake;
        this.ground = ground;
        this.food = food;
        this.gamePanel = gamePanel;
    }

    @Override
    public void snakeMoved(Snake snake) {
        if(snake.isTouchFood(food)) {
            snake.eatFood(food);
            food.addFood();
        }
        if(snake.isTouchGround(ground)||snake.isTouchSelf()){
            snake.setAlive(false);
            System.out.println("------  game over --------");
        }



    }
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                System.out.println("********up******");
                if (snake.getDirection() != Direction.DOWN)
                    snake.changeDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                if (snake.getDirection() != Direction.UP)
                    snake.changeDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                if (snake.getDirection() != Direction.RIGHT)
                    snake.changeDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                if (snake.getDirection() != Direction.LEFT)
                    snake.changeDirection(Direction.RIGHT);
                break;
        }
    }
}
