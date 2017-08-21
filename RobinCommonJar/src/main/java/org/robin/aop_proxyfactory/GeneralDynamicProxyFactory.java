package org.robin.aop_proxyfactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class GeneralDynamicProxyFactory implements InvocationHandler{
	private Object target;
	private GeneralDynamicProxyBefore before;
	private GeneralDynamicProxyAfter after;
	private boolean isContinue=true;

	public void setBefore(GeneralDynamicProxyBefore before) {
		this.before = before;
	}
	public void setAfter(GeneralDynamicProxyAfter after) {
		this.after = after;
	}
	public void setTarget(Object target) {
		this.target = target;
	}
	//@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//ǰ������
		if(before!=null) {
			before.setMethod(method);
			isContinue=before.before();
		}
		if(isContinue)
			method.invoke(target, args);
		//��������
		if(after!=null) {
			after.setMethod(method);
			after.after();
		}
		return null;
	}
	public Object getProxy(){
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

}
