package robin_permission_check;

import robin_permission_check.proxyfactory.GeneralDynamicProxyFactory;
import robin_permission_check.aspect.CustomerAspectCheckPermission;
import robin_permission_check.service.CustomerService;
import robin_permission_check.service.CustomerServiceImpl;

/**
 * Created by robin on 2017/8/21.
 */
public class CustomerServiceCliet {


    public static void main(String[] args) {

        GeneralDynamicProxyFactory proxyFactory=new GeneralDynamicProxyFactory();
        proxyFactory.setTarget(new CustomerServiceImpl());
        proxyFactory.setBefore(new CustomerAspectCheckPermission("zhangshan"));

        CustomerService serviceProxy=(CustomerService)proxyFactory.getProxy();

        serviceProxy.saveObject();
        serviceProxy.updateObject();
        serviceProxy.readObject();

    }
}
