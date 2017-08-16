package game.boxgame2;

import java.awt.*;

/**
 * Created by robin on 2017/8/16.
 */

public class Container {

    private boolean isFull[][]=new boolean[Global.CELL_WIDTH][Global.CELL_HEIGHT+1];
    private Color color[][]=new Color[Global.CELL_WIDTH][Global.CELL_HEIGHT];
    public Container(){
        for(int i=0;i<Global.CELL_WIDTH;i++){
            isFull[i][Global.CELL_HEIGHT]=true;
        }
    }
    public boolean[][] getIsFull(){
        return isFull;
    }
    public void addArray(Boxes boxes){
        for(Point p:boxes.getBody()){
            isFull[p.x][p.y]=true;
            color[p.x][p.y]=Color.yellow;
        }

    };
    public boolean isLineFull(int n){return false;}
    public void removeLineFull(int n){};
    public void drawMe(Graphics2D g){
        System.out.println("容器正在绘制自己");
        g.setColor(Color.yellow);
        for(int i=0;i<Global.CELL_HEIGHT;i++)
            for(int j=0;j<Global.CELL_WIDTH;j++)
                if(isFull[i][j]==true)
                    g.fill3DRect(i*Global.CELL_SIZE,
                            j*Global.CELL_SIZE,
                            Global.CELL_SIZE,
                            Global.CELL_SIZE,
                            true);
    }
}
