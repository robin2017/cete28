import annocation.RequestPermission;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by robin on 2017/8/21.
 */
public class TestCustomerPermission {
    private static Map<String,List<String>> maps=new HashMap<String,List<String>>();
    public static void init(){
        List<String> permissions=new ArrayList<String>();
        permissions.add("customer:save");
        permissions.add("customer:update");
        maps.put("zhangshan",permissions);
    }
    public static void main(String[] args) {
        init();
        CustomerService service=new CustomerServiceImpl();
        saveObject(service);
        updateObject(service);
    }

    public static void saveObject(CustomerService service){
        Class c=service.getClass();
        Method[] methods=c.getDeclaredMethods();
        for(Method method:methods){
          //  System.out.println("SAVEOBJECT---:"+method.getName());
            RequestPermission permission=(RequestPermission)method.getAnnotation(RequestPermission.class);
          //  System.out.println("permission---:"+permission.value());
            if(permission!=null&&permission.value().equals("customer:save")){
               if( maps.get("zhangshan").contains("customer:save"))
                        service.saveObject();
            }
        }
    }
    public static void updateObject(CustomerService service){
        Class c=service.getClass();
        Method[] methods=c.getDeclaredMethods();
        for(Method method:methods){
            RequestPermission permission=(RequestPermission)method.getAnnotation(RequestPermission.class);
            if(permission!=null&&permission.value().equals("customer:update")){
                if( maps.get("zhangshan").contains("customer:update"))
                    service.updateObject();
            }
        }
    }
}
