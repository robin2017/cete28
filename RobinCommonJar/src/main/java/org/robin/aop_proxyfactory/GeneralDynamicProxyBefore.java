package org.robin.aop_proxyfactory;

import java.lang.reflect.Method;

/**
 * Created by robin on 2017/8/21.
 */
public interface GeneralDynamicProxyBefore {
    public boolean before();
    public void setMethod(Method method);
}
