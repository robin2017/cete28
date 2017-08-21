package robin_permission_check.proxyfactory;

import java.lang.reflect.Method;

/**
 * Created by robin on 2017/8/21.
 */
public interface GeneralDynamicProxyBefore {
    public boolean before();
    public void setMethod(Method method);
}
