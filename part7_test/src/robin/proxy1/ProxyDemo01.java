package robin.proxy1;

import robin.proxy1.aop_proxyfactory.GeneralDynamicProxyFactory;
import robin.proxy1.aspect.TransactionManager;
import robin.proxy1.service.IService;
import robin.proxy1.service.TargetService;


/**
解题思路：
 1、这里将切面，业务，动态代理工厂三个角色分开，
 2、动态代理工厂可以实现复用，提高代码效率
 3、在客户端代码中直接将切面，业务注入到动态代理工厂中，然后由工厂产生动态代理
 * @author pjy
 *
 *
 *
 *
 * 题目1：描述什么时代理模式及其应用场景
 * 代理者就拥有被代理者（委托人）的部分权限，并且可以以被代理人的名义来实行这些权限，
 * 此时代理者与委托人等同，当然代理人也可以在实行权限时配合自己的能力来进行，当然不能超出这个权限。
 *
 *
 * 题目2：如代码
 */
public class ProxyDemo01 {
   public static void main(String[] args) {

	   GeneralDynamicProxyFactory proxyFactory=new GeneralDynamicProxyFactory();
	   proxyFactory.setTarget(new TargetService());
	   TransactionManager aspect=new TransactionManager();
	   proxyFactory.setBefore(aspect);
	   proxyFactory.setAfter(aspect);

	   IService serviceProxy= (IService) proxyFactory.getProxy();
	   serviceProxy.saveObject();
	   serviceProxy.writeObject();

   }
}
