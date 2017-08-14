package day03;

/**
 * Created by robin on 2017/8/11.
 */

public class HelloAdapter implements MethodRequest {
    private Hello he;
    @Override
    public void call() {
        he.sayHello();
    }

}
