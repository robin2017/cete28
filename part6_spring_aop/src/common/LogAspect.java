package common;
/**在spring会将这样的一个类声明为切面*/
public class LogAspect {
	/**在spring中会将这样的一个方法声明为
	 * 扩展业务中的一个步骤，这个步骤spring
	 * 会把它称之为通知，而这个通知会通过
	 * 代理的方式将其植入到核心义务执行的过程中*/
	public void before() {
		System.out.println("method.start");
	}
	public void afterReturn() {
		System.out.println("method.end");
	}
}
