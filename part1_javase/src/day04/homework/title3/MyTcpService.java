package day04.homework.title3;

/**
 * Created by robin on 2017/8/4.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *服务器
 */
public class MyTcpService {
    /**主函数*/
    public static void main(String[] args) {
        System.out.println("主机启动。。。");
        try {
            //创建服务器,并开放10000端口
            ServerSocket server = new ServerSocket(10000);
            while(true){
                //从连接队列中取出一个连接，如果没有则等待
                Socket socket = server.accept();
                //启动线程
                new Thread(new ToClientDialog(socket)).start();
                System.out.println("客户端连接成功      地址："+socket.getInetAddress()+"   端口:"+socket.getPort());//接收和发送数据

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**向客户端发送消息的任务*/
class ToClientDialog implements Runnable{
    /**socket*/
    private Socket dialogSocket = null;
    /**构造器*/
    public ToClientDialog() {
        super();
    }

    /**构造器*/
    public ToClientDialog(Socket socket){
        dialogSocket = socket;
    }

    public void run() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if (dialogSocket != null) {
            BufferedReader in;
            PrintWriter out;
            try {
                //接收
                in = new BufferedReader(new InputStreamReader(dialogSocket.getInputStream()));
                //输出
                out = new PrintWriter(dialogSocket.getOutputStream(), true);
                //获取用户输入
                BufferedReader line = new BufferedReader(new InputStreamReader(
                        System.in));
                while(true){
                    //接收客户端发送来的数据
                    String msg = in.readLine();
                    if (msg.equals("end")) {
                        break;
                    }
                    System.out.println(sdf.format(new Date()) + "  client：" + msg);
                    //向客户端发送用户输入的数据
                    out.println(line.readLine());
                }

                line.close();
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
