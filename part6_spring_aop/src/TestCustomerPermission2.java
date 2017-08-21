import annocation.RequestPermission;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by robin on 2017/8/21.
 */
public class TestCustomerPermission2 {
    public  static Map<String,List<String>> maps=new HashMap<String,List<String>>();
    public static void init(){
        List<String> permissions=new ArrayList<String>();
        permissions.add("customer:save");
        permissions.add("customer:update");
        maps.put("zhangshan",permissions);
    }
    public static void main(String[] args) {
        init();
        CustomerService target=new CustomerServiceImpl();
//        saveObject(service);
//        updateObject(service);
       CustomerService service=(CustomerService)Proxy.newProxyInstance(target.getClass().getClassLoader(),
               target.getClass().getInterfaces(),
               new PermissionHandler(target));

        service.saveObject();
        service.updateObject();
       // service.readObject();


    }

}
class PermissionHandler implements InvocationHandler{

    private Object target;
    public PermissionHandler(Object target){
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Method targetMethod=target.getClass().getDeclaredMethod(method.getName(),method.getParameterTypes());
        if(targetMethod.isAnnotationPresent(RequestPermission.class));
        if(!TestCustomerPermission2.maps.containsKey("zhangshan"))
            throw new RuntimeException("请登陆");
        List<String> permissions=TestCustomerPermission2.maps.get("zhangshan");
        RequestPermission permission=targetMethod.getAnnotation(RequestPermission.class);
        String per=permission.value();
        if(!permissions.contains(per))
            throw new RuntimeException("没有权限");
        Object result=method.invoke(target,args);
        return result;
    }
}
