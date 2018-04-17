package day06;

/**
 * Created by robin on 2017/8/8.
 */
public class Hello {
    public static void main(String[] args){
       System.out.println( Hello.class.getClassLoader().getClass().getName());
//        System.out.println(String.class.getClassLoader().getClass().getName());
//        System.out.println( Hello.class.getClassLoader().getClass().getName());
    }
}
