package day06.homework.rpcrobin.net_server;


import day06.homework.rpcrobin.local.UserDao;
import day06.homework.rpcrobin.local.UserDaoImpl;
import day06.homework.rpcrobin.net_common.NetConstant;
import day06.homework.rpcrobin.net_common.Request;
import day06.homework.rpcrobin.net_common.Response;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by robin on 2017/8/9.
 */
public class MainService {
    private static ExecutorService executor= Executors.newCachedThreadPool();
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(NetConstant.PORT);
        System.out.println("服务器端已开启，等待连接");
        while(true){
            Socket socket=serverSocket.accept();
            System.out.println("得到访问："+socket.getInetAddress().getHostAddress());
            executor.submit(new Task(socket));
        }
    }
}

class Task implements Runnable{
    private Socket socket;
    private UserDao userDao= UserDaoImpl.getInstance();
    public Task(Socket socket){
        this.socket=socket;
    }
    /**
     * 1、socket中得到request
     * 2、根据请求，调用业务，得到响应（用到了java反射）
     * 3、将response写入socket
     * */
    @Override
    public void run() {
        Request request= null;
        try {
            request = readRequestFromSocket();
            Response response=handler(request);
            writeResponseToSocket(response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
    private Request readRequestFromSocket() throws IOException, ClassNotFoundException {
        ObjectInputStream ois =
                new ObjectInputStream(socket.getInputStream());
        Request request=(Request) ois.readObject();
        return request;


    }
    private Response handler(Request request) throws NoSuchMethodException, IllegalAccessException {
        Response response=new Response();
        Method method=userDao.getClass().getMethod(request.getMethodName(),request.getParamTypes());
        try {
          //  System.out.println("开始调用");
            Object object=method.invoke(userDao,request.getObjs());
            response.setObj(object);
        } catch (InvocationTargetException e) {//这个异常要捕获封装给客户端,其他的就不处理了
           response.setException((Exception) e.getTargetException());
        }
        response.setSuccess();
        return response;
    }
    private void writeResponseToSocket(Response response) throws IOException {
        ObjectOutputStream  oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(response);
    }
}
