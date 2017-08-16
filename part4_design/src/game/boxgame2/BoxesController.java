package game.boxgame2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by robin on 2017/8/16.
 */
public class BoxesController extends KeyAdapter implements BoxesListener,ContainerListener {
    //控制层为上层,必须拥有其他对象
    private Boxes boxes;
    private Container container;
    private GamePanel gamePanel;

    public BoxesController(Boxes boxes, Container container, GamePanel gamePanel) {
        this.boxes = boxes;
        this.container = container;
        this.gamePanel = gamePanel;
    }

    @Override
    public void boxesDeclinedFromBoxes() {
        System.out.println("boxes监听器     ：    监听到下降");
        if(boxes.isTouchEnd()){
            System.out.println("触底了------------------------------------");
            boxes.setTouchEnd(true);
            //将boxes属性给container
            container.addArray(boxes);
            //重新创建一个boxes，因为这个是单例，所以之前的会消失的

        }

        gamePanel.repaint();
    }

    @Override
    public void boxesDeclinedFromContainer() {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        int value=e.getKeyCode();
        switch (value){

            case  KeyEvent.VK_LEFT:
                System.out.println("------------left------");
                boxes.shift(Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("------------right------");
                boxes.shift(Direction.RIGHT);
                break;
            case KeyEvent.VK_0:
                System.out.println("-------------ratotion------");
                boxes.rotation();
        }
    }
}
