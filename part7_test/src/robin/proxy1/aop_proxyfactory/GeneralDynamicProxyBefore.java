package robin.proxy1.aop_proxyfactory;

import java.lang.reflect.Method;

/**
 * Created by robin on 2017/8/21.
 */
public interface GeneralDynamicProxyBefore {
    public boolean before() throws NoSuchMethodException;
    public void setMethod(Method method);
}
