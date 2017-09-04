package robin.singleton2;
/**
 * 饿加载：一开始由实例化，在调用的时候更加快速
 * */
class Singleton01{
    private static Singleton01 instance=new Singleton01();
    private Singleton01(){}
    public Singleton01 getInstance(){
        return instance;
    }
}


/**
 * 懒加载：使用时实例化，适用于单线程，非线程安全
 * */
class Singleton02{
    private static Singleton02 instance;
    private Singleton02(){}
    public Singleton02 getInstance(){
        if (instance==null){
            instance=new Singleton02();
        }
        return instance;
    }
}

/**
 * 懒加载：使用时实例化，线程安全，效率低
 * */
class Singleton03{
    private static Singleton03 instance;
    private Singleton03(){}
    public synchronized Singleton03 getInstance(){
        if (instance==null){
            instance=new Singleton03();
        }
        return instance;
    }
}

/**
 * 懒加载：使用时实例化，线程安全，效率高
 * */
 class Singleton04 {
    private volatile static Singleton04 instance;
    private Singleton04 (){}
    public static Singleton04 getInstance() {
        if (instance == null) {
            synchronized (Singleton04.class) {
                if (instance == null) {
                    instance = new Singleton04();
                }
            }
        }
        return instance;
    }
}
/***
 * �������ĸ������ֱ�����Ϊ����ģʽģʽ����
 * 1.��������ģʽ
 * 2.ʵ�������ĸ���ĵ������
 * 3.��������������Ƶ�Ӧ�ó��������Ƽ����ơ�
 */
public class SinglegletonDemo01 {

}
