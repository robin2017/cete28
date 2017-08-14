package day06.homework.chatrobin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by robin on 2017/8/8.
 */
public class CharClient {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",8095);
        new Thread(new ReceiveMsg(socket)).start();
        new Thread(new SendMsg(socket)).start();
    }
}

class SendMsg implements Runnable{
    private Socket socket;
    public SendMsg(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        while(true) {

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in));
            String msg= null;
            try {
                msg = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            PrintWriter out = null;
            try {
                out = new PrintWriter(socket.getOutputStream());
                out.println(msg);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ReceiveMsg implements Runnable{
    private Socket socket;
    public ReceiveMsg(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                System.out.println(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
