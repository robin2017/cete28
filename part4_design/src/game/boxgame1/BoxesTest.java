package game.boxgame1;

import javax.swing.*;

/**
 * Created by robin on 2017/8/16.
 */
public class BoxesTest {
    public static void main(String[] args){
        JFrame frame = new JFrame("Boxes_version1.0");
        frame.setSize(Global.CELL_WIDTH * Global.CELL_SIZE + 10, Global.CELL_HEIGHT * Global.CELL_SIZE + 10);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Boxes boxes=new Boxes();
        Container container=new Container();

        GamePanel gamePanel = new GamePanel(boxes,container);
        gamePanel.setSize(Global.CELL_SIZE*Global.CELL_WIDTH,Global.CELL_SIZE*Global.CELL_WIDTH);

        gamePanel.setFocusable(true);

        new Thread(new BoxesDriver(boxes)).start();

        frame.add(gamePanel);
        frame.setVisible(true);

    }
}
