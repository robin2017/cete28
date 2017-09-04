package beans.aspect;
import beans.common.Permission;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
@Order(0)
@Aspect
@Component
public class PermissionAspect {
	@Before("bean(*ServiceImpl)")
	public void beforeMethod(JoinPoint joinPoint)throws Exception {
		System.out.println("permission check");
		Object obj=joinPoint.getTarget();
		String methodName=
		joinPoint.getSignature().getName();
		MethodSignature ms=(MethodSignature)
				joinPoint.getSignature();
	    Class<?>[] parameterTypes=
	    ms.getMethod().getParameterTypes();
	    Method method=
	    obj.getClass().getDeclaredMethod(methodName,
	    		parameterTypes);
		boolean flag=
		method.isAnnotationPresent(Permission.class);
		if(flag) {
		System.out.println("obj="+obj);
		throw new RuntimeException("������������");	
		}
		//Method method;
		//method.isAnnotationPresent(annotationClass)
		//method.getAnnotation(annotationClass)
	}
}
