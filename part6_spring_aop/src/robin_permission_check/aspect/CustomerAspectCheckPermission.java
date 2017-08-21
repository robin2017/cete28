package robin_permission_check.aspect;

import robin_permission_check.proxyfactory.GeneralDynamicProxyBefore;
import robin_permission_check.data.PermissionData;
import robin_permission_check.service.CustomerServiceImpl;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by robin on 2017/8/21.
 */
public class CustomerAspectCheckPermission implements GeneralDynamicProxyBefore {
    private Method method;
    private String name;
    public CustomerAspectCheckPermission(String name){
        this.name=name;
    }
    @Override
    public void setMethod(Method method) {
        this.method=method;
    }
    @Override
    public boolean before() {
        boolean isContinue=true;
        try {
            Method targetMethod= CustomerServiceImpl.class.getDeclaredMethod(method.getName(),
                    method.getParameterTypes());
            if(targetMethod.isAnnotationPresent(RequestPermission.class)){
                if(!PermissionData.maps.containsKey(name))
                    throw new RuntimeException("请登陆");
                List<String> permissions=PermissionData.maps.get(name);
                RequestPermission permission=targetMethod.getAnnotation(RequestPermission.class);
                String per=permission.value();
                if(!permissions.contains(per))
                    throw new RuntimeException("没有权限:"+method.getName());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        catch (RuntimeException e){
            isContinue=false;
            System.out.println(e.getMessage());
        }
        return isContinue;
    }
}
