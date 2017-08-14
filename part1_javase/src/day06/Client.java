package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by robin on 2017/8/8.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",8081);//建立并连接
        BufferedReader bufferedReader=
                new BufferedReader(
                        new InputStreamReader(System.in)); //源头为console
        String str=bufferedReader.readLine();
        PrintWriter out=new PrintWriter(socket.getOutputStream());
        out.println(str);

    }
}
