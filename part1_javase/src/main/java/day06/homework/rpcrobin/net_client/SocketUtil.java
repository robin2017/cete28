package day06.homework.rpcrobin.net_client;


import com.alibaba.fastjson.JSONObject;
import day06.homework.rpcrobin.net_common.NetConstant;
import day06.homework.rpcrobin.net_common.Request;
import day06.homework.rpcrobin.net_common.Response;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


/**
 * Created by robin on 2017/8/9.
 */
public class SocketUtil {
   /**
    * java序列化
    * */
    public static Response remoteCall(Request request){
        try {
            System.out.println("写入的request为："+request);
            Socket socket = new Socket("127.0.0.1",NetConstant.PORT);
            ObjectOutputStream oos =
                    new ObjectOutputStream(
                            socket.getOutputStream());
            Thread.sleep(1000);
            oos.writeObject(request);

            ObjectInputStream ios =
                    new ObjectInputStream(
                            socket.getInputStream());
            Response response = (Response)ios.readObject();

            return response;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * json
     * */
    public static JSONObject remoteCallJson(JSONObject request){
        try {
            System.out.println("写入的request为："+request);
            Socket socket = new Socket("127.0.0.1",NetConstant.PORT);
            ObjectOutputStream oos =
                    new ObjectOutputStream(
                            socket.getOutputStream());
            Thread.sleep(1000);
            oos.writeObject(request);

            ObjectInputStream ios =
                    new ObjectInputStream(
                            socket.getInputStream());
            JSONObject response = (JSONObject)ios.readObject();

            return response;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
