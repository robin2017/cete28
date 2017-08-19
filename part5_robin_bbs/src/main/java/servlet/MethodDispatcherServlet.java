package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by robin on 2017/8/18.
 */

public class MethodDispatcherServlet extends HttpServlet {
    public void methodDispatcher(String methodName,HttpServletRequest req, HttpServletResponse resp)  {
        try {
            System.out.println("-------");
            System.out.println(req.getClass().getSimpleName());
            System.out.println(resp.getClass().getSimpleName());
            System.out.println("----end---");

            Method method = this.getClass().getMethod(methodName, req.getClass(), resp.getClass());
            method.invoke(this,(HttpServletRequest)req, (HttpServletResponse)resp);

        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


//    Response response=new Response();
//
//    Method method=userDao.getClass().getMethod(request.getMethodName(),request.getParamTypes());
//    try {
//        //  System.out.println("开始调用");
//        Object object=method.invoke(userDao,request.getObjs());
//        response.setObj(object);
//    } catch (InvocationTargetException e) {//这个异常要捕获封装给客户端,其他的就不处理了
//        response.setException((Exception) e.getTargetException());
//    }
//    response.setSuccess();
//    return response;
}