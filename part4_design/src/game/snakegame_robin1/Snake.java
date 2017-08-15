package game.snakegame_robin1;


/**
 * Created by robin on 2017/8/15.
 */

public class Snake {
    //move与changeDirection有关联
    public void move(){};
    public void changeDirection(Direction direction){};
    //行为判断
    public boolean isTouchFood(){return false;};
    public boolean isTouchGround(Ground ground){return false;};
    public boolean isTouchSelf(){return false;};
    //根据判断结果做行为
    public void eatFood(Food food){};
    //UI展示
    public void drawMe(){};
}
