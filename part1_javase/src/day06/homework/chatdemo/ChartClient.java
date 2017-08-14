package day06.homework.chatdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChartClient {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1",9090);
			new AcceptData(socket);
			BufferedReader br =
					new BufferedReader(
							new InputStreamReader(System.in));
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
			while(true){
				String str = br.readLine();
				if("bye-bye".equals(str))break;
				if("".equals(str)||str==null)continue;
				out.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
//随时从服务器端读数据
class AcceptData extends Thread{
	private Socket socket;
	private BufferedReader br;
	public AcceptData(Socket socket){
		this.socket = socket;
		try {
			br = new BufferedReader(
					new InputStreamReader(
							socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.start();
	}
	public void run(){
		try {
			while(true){
				String str = br.readLine();
				if(str==null || "".equals(str))
					continue;
				if("exit".equals(str))
					break;
				int index = str.indexOf("/");
				if(index==-1){
					System.out.println("群聊的内容:"+str);
				}else{
					String[] ss = str.split("/");
					System.out.println(ss[0]+"说:"+ss[1]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
