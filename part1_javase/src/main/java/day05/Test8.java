package day05;

/**
 * Created by robin on 2017/8/7.
 */
public class Test8 {
}


class MyWeekDay{  //jdk5之前版本
    private MyWeekDay(){}
    public final MyWeekDay Mon=new MyWeekDay();
    public final MyWeekDay Tue=new MyWeekDay();
    public final MyWeekDay WED=new MyWeekDay();
    public final MyWeekDay THU=new MyWeekDay();
    public final MyWeekDay FRI=new MyWeekDay();
    public final MyWeekDay SAT=new MyWeekDay();
    public final MyWeekDay SUN=new MyWeekDay();
    public MyWeekDay nextDay(){
        //todu
        return null;
    }
}
enum WeekDay{
    Mon,Tue,Wed,Thu,Fri,Sat,Sun;
}