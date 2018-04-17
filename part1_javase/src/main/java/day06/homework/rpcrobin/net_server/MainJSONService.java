package day06.homework.rpcrobin.net_server;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import day06.homework.rpcrobin.local.UserDao;
import day06.homework.rpcrobin.local.UserDaoImpl;
import day06.homework.rpcrobin.net_common.NetConstant;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static day06.homework.rpcrobin.net_common.NetConstant.*;
/**
 * Created by robin on 2017/8/9.
 */
public class MainJSONService {
    private static ExecutorService executor= Executors.newCachedThreadPool();
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(NetConstant.PORT);
        System.out.println("���������ѿ������ȴ�����");
        while(true){
            Socket socket=serverSocket.accept();
            System.out.println("�õ����ʣ�"+socket.getInetAddress().getHostAddress());
            executor.submit(new TaskJSON(socket));
        }
    }
}

class TaskJSON implements Runnable{
    private Socket socket;
    private UserDao userDao= UserDaoImpl.getInstance();
    public TaskJSON(Socket socket){
        this.socket=socket;
    }
    /**
     * 1��socket�еõ�request
     * 2���������󣬵���ҵ�񣬵õ���Ӧ���õ���java���䣩
     * 3����responseд��socket
     * */
    @Override
    public void run() {
        JSONObject request= null;
        try {
            request = readRequestFromSocket();
            JSONObject response=handler(request);
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
    private JSONObject readRequestFromSocket() throws IOException, ClassNotFoundException {
        ObjectInputStream ois =
                new ObjectInputStream(socket.getInputStream());
        JSONObject request=(JSONObject) ois.readObject();
        return request;


    }
    private JSONObject handler(JSONObject request) throws NoSuchMethodException, IllegalAccessException, ClassNotFoundException {
        JSONObject response=new JSONObject();
        List<Class> classList = new ArrayList<Class>();
        JSONArray clas = (JSONArray) request.get(REQUEST_PARAM_TYPES);
        if(clas!=null) {
            for(int i=0;i<clas.size();i++){
                Class c = Class.forName((String) clas.get(i));
                classList.add(c);
            }
        }

        Class[] classes = new Class[classList.size()];
        classList.toArray(classes);
        String methodName = (String) request.get(REQUEST_METHOD_NAME);
        Method method=userDao.getClass().getMethod(methodName,classes);
        try {
            List<Object> objectList = new ArrayList<Object>();
            JSONArray objs = (JSONArray) request.get(REQUEST_OBJECTS);
            if(objs!=null){
                for(int i=0;i<objs.size();i++){
                    Object object = objs.get(i);
                    objectList.add(object);
                }
            }
            Object[] objects = new Object[objectList.size()];
            objectList.toArray(objects);
            Object object = method.invoke(userDao,objects);
            response.put(RESPONSE_OBJECT, JSON.toJSONString(object));
        } catch (InvocationTargetException e) {//����쳣Ҫ�����װ���ͻ���,�����ľͲ�������
            response.put(RESPONSE_EXCEPTIION,e.getTargetException());
        }

        response.put(RESPONSE_SUCCESS,response.get(RESPONSE_EXCEPTIION)==null?true:false);
        return response;
    }
    private void writeResponseToSocket(JSONObject response) throws IOException {
        ObjectOutputStream  oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(response);
    }
}
