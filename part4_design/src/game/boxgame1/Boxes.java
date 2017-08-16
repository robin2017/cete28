package game.boxgame1;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by robin on 2017/8/16.
 */

public class Boxes {
    private ArrayList<Point> body=new ArrayList<Point>();
    private Color bodyColor=null;
    public Boxes(){
        body=getNextBody();
    }
     //行为
    public void decline(){
        System.out.println("方块正在下降");
    };
    public void shift(){};
    public void rotation(){};

    //判断
    public void isTouchEnd(){};

    //ui
    public void drawMe(Graphics2D g){
        System.out.println("boxes正在画出自己");
        g.setColor(bodyColor);
        for(Point p:body)
            g.fill3DRect(p.x*Global.CELL_SIZE,
                    p.y*Global.CELL_SIZE,
                    Global.CELL_SIZE,
                    Global.CELL_SIZE,
                    true);
    };

    public ArrayList<Point> getNextBody(){
        ArrayList<Point> body=null;
        int type=1+new Random().nextInt(3);
        System.out.println("产生boxes的种类为："+type);
        switch(type){
            case 1:
                body=getBody1();
                break;
            case 2:
                body=getBody2();
                break;
            case 3:
                body=getBody3();
                break;
            case 4:
                body=getBody4();
                break;
        }
        return body;
    }

    public ArrayList<Point> getBody1(){ //长条
        ArrayList<Point> res=new ArrayList<Point>();
        res.add(new Point(Global.CELL_WIDTH/2-1,0));
        res.add(new Point(Global.CELL_WIDTH/2,0));
        res.add(new Point(Global.CELL_WIDTH/2+1,0));
        res.add(new Point(Global.CELL_WIDTH/2+2,0));
        bodyColor=Color.red;
        return res;
    }

    public ArrayList<Point> getBody2(){ //凸条
        ArrayList<Point> res=new ArrayList<Point>();
        res.add(new Point(Global.CELL_WIDTH/2-1,0));
        res.add(new Point(Global.CELL_WIDTH/2,0));
        res.add(new Point(Global.CELL_WIDTH/2+1,0));
        res.add(new Point(Global.CELL_WIDTH/2,1));
        bodyColor=Color.blue;
        return res;
    }

    public ArrayList<Point> getBody3(){ //凸条
        ArrayList<Point> res=new ArrayList<Point>();
        res.add(new Point(Global.CELL_WIDTH/2-1,0));
        res.add(new Point(Global.CELL_WIDTH/2,0));
        res.add(new Point(Global.CELL_WIDTH/2+1,0));
        res.add(new Point(Global.CELL_WIDTH/2-1,1));
        bodyColor=Color.green;
        return res;
    }

    public ArrayList<Point> getBody4(){ //凸条
        ArrayList<Point> res=new ArrayList<Point>();
        res.add(new Point(Global.CELL_WIDTH/2-1,0));
        res.add(new Point(Global.CELL_WIDTH/2,0));
        res.add(new Point(Global.CELL_WIDTH/2+1,0));
        res.add(new Point(Global.CELL_WIDTH/2+1,1));
        bodyColor=Color.yellow;
        return res;
    }
}

class BoxesDriver implements Runnable{
    private Boxes boxes;
    public BoxesDriver(Boxes boxes){
        this.boxes=boxes;
    }
    @Override
    public void run() {
        while(true){
            boxes.decline();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}