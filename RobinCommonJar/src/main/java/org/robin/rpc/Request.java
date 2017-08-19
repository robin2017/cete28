package org.robin.rpc;

import java.io.Serializable;
import java.util.Arrays;

public class Request implements Serializable {
	private String sessionId;
	private String typeName;
	private String methodName;
	private Class[] paramTypes;
	private Object[] objs;
	public Request() {}
	public Request(String methodName, Class[] paramTypes, Object[] objs) {
		super();
		this.methodName = methodName;
		this.paramTypes = paramTypes;
		this.objs = objs;
	}
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

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "Request{" +
				"sessionId='" + sessionId + '\'' +
				", methodName='" + methodName + '\'' +
				", paramTypes=" + Arrays.toString(paramTypes) +
				", objs=" + Arrays.toString(objs) +
				'}';
	}
}
