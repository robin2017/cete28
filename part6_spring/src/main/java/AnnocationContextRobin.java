import annocation.Component;
import beans.PageObject;


/**
 * Created by robin on 2017/8/19.
 */
public class AnnocationContextRobin {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<?> c= PageObject.class;
        boolean flag=c.isAnnotationPresent(Component.class);
        if(flag){
            String className=c.getSimpleName();
           Object obj= c.newInstance();
        }

    }
}
