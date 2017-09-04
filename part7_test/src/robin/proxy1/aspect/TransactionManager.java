package robin.proxy1.aspect;

import robin.proxy1.service.TargetService;
import robin.proxy1.aop_proxyfactory.GeneralDynamicProxyAfter;
import robin.proxy1.aop_proxyfactory.GeneralDynamicProxyBefore;

import java.lang.reflect.Method;

/**
 * Created by robin on 2017/8/24.
 */
public class TransactionManager implements GeneralDynamicProxyBefore,GeneralDynamicProxyAfter {
    private Method method;
    public void beginTransaction() {
        System.out.println("begin transaction");
    }
    public void commitTransaction() {
        System.out.println( "commit transaction");
    }

    @Override
    public boolean before() throws NoSuchMethodException {
        //System.out.println("before");
        Method[] methods= TargetService.class.getDeclaredMethods();
        for(Method method:methods){
            //System.out.println(method.getName());
            if(method.isAnnotationPresent(Transaction.class)){
                beginTransaction();
            }
        }
        return true;
    }

    @Override
    public void after() {
        Method[] methods= TargetService.class.getDeclaredMethods();
        for(Method method:methods){
            if(method.isAnnotationPresent(Transaction.class)){
                commitTransaction();
            }
        }

    }

    @Override
    public void setMethod(Method method) {
        this.method=method;
    }
}