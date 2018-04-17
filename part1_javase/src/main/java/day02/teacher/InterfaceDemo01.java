package day02.teacher;



interface ICallable{
    void call();
}
interface IExecutorService{
    //Use a (依赖关系)
    void execute(ICallable call);
}
class ExecutorServiceImpl implements IExecutorService{
    @Override
    public void execute(ICallable c) {
        c.call();
    }
}
//is a (extends,implements)
class CallableImpl implements ICallable{
    @Override
    public void call() {
        System.out.println("call");
    }
}
interface IOnClickListener{
    void onClick();

}
class OnClickListenerImpl implements IOnClickListener{
    @Override
    public void onClick() {
        System.out.println("对象被点击了");
    }
}

class Button{
    private String mText;
    public Button(String text) {
        mText=text;
    }
    //has a
    private IOnClickListener onClickListener;
    public void setOnClickListener(
            IOnClickListener onClickListener) {
        this.onClickListener =
                onClickListener;
    }
    public void click() {
        onClickListener.onClick();
    }
}

public class InterfaceDemo01 {
    public static void main(String[] args) {
        IExecutorService executor=null;
        executor=new ExecutorServiceImpl();
        executor.execute(
                new CallableImpl());
        //===============
        Button btn=new Button("按钮");
        IOnClickListener listener=new OnClickListenerImpl();
        btn.setOnClickListener(listener);
        btn.click();
    }
}
