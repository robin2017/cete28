package day06.ServerTest.test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by robin on 2017/8/8.
 */
public class SocketUtil {
    public static Response remoteCall(Request request) throws ClassNotFoundException, IOException {
            System.out.println("ddd");
            Socket socket=new Socket("127.0.0.1",8080);
            ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(request);
            oos.close();
             System.out.println("ddddddffffdd");
            ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
            Response response=(Response)ois.readObject();
            System.out.println("读取结束");
            return response;

    }
}
