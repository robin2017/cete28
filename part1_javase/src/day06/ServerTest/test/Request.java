package day06.ServerTest.test;

import java.io.Serializable;

/**
 * Created by robin on 2017/8/8.
 */
public class Request implements Serializable {
    private String methodName;
    private Class[] paramTypes;
    private Object[] objs;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class[] paramTypes) {
        this.paramTypes = paramTypes;
    }

    public Object[] getObjs() {
        return objs;
    }

    public void setObjs(Object[] objs) {
        this.objs = objs;
    }
}
