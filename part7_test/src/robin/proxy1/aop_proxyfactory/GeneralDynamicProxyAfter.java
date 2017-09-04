package robin.proxy1.aop_proxyfactory;

import java.lang.reflect.Method;

/**
 * Created by robin on 2017/8/21.
 */
public interface GeneralDynamicProxyAfter {
    public void after();
    public void setMethod(Method method);
}
