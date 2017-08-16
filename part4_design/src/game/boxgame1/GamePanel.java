package game.boxgame1;

import javax.swing.*;
import java.awt.*;

/**
 * Created by robin on 2017/8/16.
 */
public class GamePanel extends JPanel {

    private Boxes boxes;
    private Container container;
    public GamePanel(Boxes boxes,Container container){
        super();
        this.boxes=boxes;
        this.container=container;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g;
        boxes.drawMe(g2);
        container.drawMe(g2);
    }
}
