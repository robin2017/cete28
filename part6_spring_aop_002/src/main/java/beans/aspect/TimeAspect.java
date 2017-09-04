package beans.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(1)
@Aspect
@Component
public class TimeAspect {
	/**ͨ��Pointcut���������*/
	@Pointcut("execution(* beans.service.impl.*.*(..))")
	public void pointCutMethod() {}
	
/*	@Before("pointCutMethod()")
	public void beforeMethod() {
		long start=System.nanoTime();
		System.out.println("method.start.time="+start);
	}*/
	/*@After("pointCutMethod()")
	public void afterMethod() {
		long end=System.nanoTime();
		System.out.println("method.end.time="+end);
	}*/
	@Around("pointCutMethod()")
	public Object aroundMethod(
	  ProceedingJoinPoint  p) {
		Object result=null;
		long t1=0,t2=0;
		try {
		 t1=System.nanoTime();
		 System.out.println("run.start.time="+t1);
		 result=p.proceed();//�ײ���Զ�����Ŀ������ҵ�񷽷�
		 t2=System.nanoTime();
		 System.out.println("run.start.end="+t2);
		}catch(Throwable e) {
		  e.printStackTrace();
		  throw new RuntimeException(e.getMessage());
		}finally {
		  System.out.println("total.time="+(t2-t1));
		}
		return result;
	}
}
