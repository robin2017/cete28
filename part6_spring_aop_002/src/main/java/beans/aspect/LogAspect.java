package beans.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/***
 * AOP:����������(����:ʵ����Ҫ��չ��ҵ���ܵķ�װ)
 * 1)Sping������Ķ���
 * @Aspect ͨ����ע�ⶨ��һ������(�����Ͼ�һ����)
 * �������Ҫ��װҪ��չ��ҵ��
 * 2)Sping ������֪ͨ�Ķ���
 * ���Խ�֪ͨ�����ΪҪ��չ��ҵ����һ������
 */
@Order(2)
@Aspect
@Component
public class LogAspect {//������(��������ʱҪ����˶����еĹ���)
	/**����ǰ��֪ͨ,��Ҫʹ��@Before����
	 * ִ��:ҵ�񷽷�֮ǰ֮ǰִ��
	 * ע��������Ϊ����������(Pointcut)
	 * ����㻹���Կ��������ɸ����ӵ�(JoinPoint)
	 * �ļ���,������ӵ��Ӧ�����һ��ҵ�񷽷�
	 * ����
	 * */
	@Before("bean(petServiceImpl)")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName=
		joinPoint.getSignature().getName();
		System.out.println(methodName+".method.start");
	}
	/**
	 * @AfterReturning
	 * �������֪ͨ����������֮��ִ��
	 */
	@AfterReturning("bean(petServiceImpl)")
	public void afterReturnMethod() {
	System.out.println("method.after.return");
	}
	/**�쳣֪ͨ
	 * �����׳��쳣�Ժ�ִ��
	 * */
	@AfterThrowing("bean(petServiceImpl)")
	public void afterThreadMethod() {
		System.out.println("method.after.throwing");
	}
	/**����֪ͨ
	 * ����ִ�н����Ժ�Ҫִ���൱������
	 * finally�����ִ��
	 * */
	@After("bean(petServiceImpl)")
	public void afterMethod() {
		System.out.println("method.after");
	}
	/**
	 * try{
	 *   //1.@Before
	 *   saveObject()
	 *   //2.@AfterReturn
	 * }catch(Exception e){
	 *   //3.@AfterThrowing
	 * }finally{
	 *   //4.@After
	 * }
	 */

}
