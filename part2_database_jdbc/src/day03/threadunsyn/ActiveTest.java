package day03.threadunsyn;

/**
 * Created by robin on 2017/8/11.
 */
public class ActiveTest {
    public static void main(String[] args) throws InterruptedException {
      Service service=new ServiceProxy();
        service.sayHello();
        service.sayHello();
        service.sayHello();
        Thread.sleep(2000);

        service.sayHello();
        service.sayHello();
    }
}
