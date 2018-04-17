package day06.ServerTest.test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by robin on 2017/8/8.
 */
public class MainServer {
    private static UserServiceImpl userService = new UserServiceImpl();
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("服务开启");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("接受socket");
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Response response = new Response();
            try {
                Request request = (Request) ois.readObject();
                String methodName = request.getMethodName();
                Class[] paramTypes = request.getParamTypes();
                Object[] objs = request.getObjs();
                Class c = userService.getClass();
                Method method = c.getDeclaredMethod(methodName,paramTypes);
                User user = (User) method.invoke(objs);
                response.setObj(user);
            } catch (Exception e) {
                response.setException(e);
            }
            response.setSuccess();
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(response);
        }
    }

    static class MyThread extends Thread{
        private Socket socket;
        public void run(){
            Response response=new Response();
            ObjectOutputStream oos=null;
            try{
                oos=new ObjectOutputStream(socket.getOutputStream());
            }catch(Exception e)
            {}finally {

            }
        }
    }
}
