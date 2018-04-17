package sun_tiku;

/**
 * Created by robin on 2017/7/28.
 */
public class Foo
{
    public static void main(String[] ag){
        String foo="blue";
        String bar=foo;
        foo="green";
        System.out.println(bar);
    }
}
