package day01.homework.jiekou;

/**
 * Created by robin on 2017/7/26.
 */
public class ResizableCircle extends Circle implements Resizable {
    public ResizableCircle(double radius) {
        super(radius);
    }

    @Override
    public void resize(int percent) {
        radius*=Math.sqrt(percent*1.0/100);
    }
}
