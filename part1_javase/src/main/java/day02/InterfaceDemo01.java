package day02;

/**
 * Created by robin on 2017/7/27.
 */

interface ICallable{
    void call();
}
/**
 * 将关联放在抽象层中，相当于spring将关联放在xml文件中
 *
 * */
interface IExecutorService{
    public void execute(ICallable call);
}

class IExecutorServiceImpl implements IExecutorService{

    @Override
    public void execute(ICallable call) {
        call.call();
    }
}

class CallableImpl implements ICallable{
    @Override
    public void call() {
        System.out.println("call");
    }
}
public class InterfaceDemo01 {
    public static void main(String[] args){

    }
}
