package day06.homework.chatrobin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by robin on 2017/8/8.
 */
public class CharServer {
    private static ExecutorService executorService= Executors.newCachedThreadPool();
    private static HashMap<String,Socket> sockets=new HashMap<String, Socket>();
    public static HashMap<String,Socket> getAllSocket(){
        return sockets;
    }
    public static Socket getSocketById(String id){
        return sockets.get(id);
    }
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket=new ServerSocket(8095);
        System.out.println("服务器开启，等待线程");
        while(true){
            Socket socket=serverSocket.accept();
            String addr=socket.getInetAddress().getHostAddress()+"--"+ UUID.randomUUID().toString();
            System.out.println(addr+"   线程进入");
            sockets.put(addr, socket);
            executorService.submit(new Transmit(socket,addr));
        }
    }

}

class Transmit implements Callable<String>{
    private Socket socket;
    private String address;//因为根据socket找address找不到，所以这里必须也传入过来
    public Transmit(Socket socket,String address){
        this.socket=socket;
        this.address=address;
    }

    @Override
    public String call() throws Exception {
        while(true) {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            HashMap<String, Socket> hashMap = CharServer.getAllSocket();
            String outMsg = br.readLine();
            int index=outMsg.indexOf('/');
            //群聊
            if(index==-1){
                for (String addr : hashMap.keySet()) {
                    Socket client = hashMap.get(addr);
                    PrintWriter out = new PrintWriter(client.getOutputStream());
                    out.println(outMsg);
                    out.flush();
                }
            }else{ //私聊
                Socket client=CharServer.getSocketById(outMsg.split("/")[0]);
                PrintWriter out = new PrintWriter(client.getOutputStream());
                out.println(address+"  对你说:  "+outMsg.split("/")[1]);
                out.flush();
            }
        }
    }
}
