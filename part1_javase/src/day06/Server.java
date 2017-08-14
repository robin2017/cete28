package day06;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by robin on 2017/8/8.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket s=new ServerSocket(8081);
        System.out.println("服务开启");
        Socket socket =s.accept(); //阻塞时有性能问题
        System.out.println("客户访问");

    }
}
