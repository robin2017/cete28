package day03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by robin on 2017/8/11.
 */
public class GenralProxyFactoryBean implements InvocationHandler {
    private Object target;
//    public void setTarget();
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
