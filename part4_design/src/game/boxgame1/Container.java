package game.boxgame1;

import java.awt.*;

/**
 * Created by robin on 2017/8/16.
 */

public class Container {

    public void addArray(){};
    public boolean isLineFull(int n){return false;}
    public void removeLineFull(int n){};
    public void drawMe(Graphics2D g){
        System.out.println("容器正在绘制自己");
        g.setColor(Color.blue);
        g.fill3DRect(0,0,0,0,true);
    }
}
