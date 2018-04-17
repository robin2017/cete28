package day06.homework.chatdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.UUID;

public class ChartServer {
	private static HashMap<String, Socket> sockets =
			new HashMap<String,Socket>();
	public static void addSocket(String addr,Socket socket){
		sockets.put(addr, socket);
	}
	public static Socket findSocket(String addr){
		if(sockets.containsKey(addr))
			return sockets.get(addr);
		return null;
	}
	public static HashMap<String, Socket> getSockets() {
		return sockets;
	}
	public static void main(String[] args) {
		try {
			ServerSocket s = new ServerSocket(9090);
			System.out.println("服务已经开启等待客户来访问!");
			while(true){
				Socket socket = s.accept();
				//每个客户端连接服务器产生的Socket都要保存下来。
				String addr = socket.getInetAddress().getHostAddress()+UUID.randomUUID().toString();
				System.out.println("接受到客户端:"+addr+"的访问!");
				ChartServer.addSocket(addr, socket);
				new Service(socket,addr);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
class Service extends Thread{
	private Socket socket;
	private BufferedReader br;
	private PrintStream ps;
	private String addr;
	public Service(Socket socket,String addr){
		this.socket = socket;
		try {
			br = new BufferedReader(
					new InputStreamReader(
							socket.getInputStream()));
			ps = new PrintStream(socket.getOutputStream());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.addr = addr;
		this.start();
	}
	public void run(){
		try {
			while(true){
				String str = br.readLine();
				if(str==null || "".equals(str))continue;
				if("exit".equals(str))break;
				int index = str.indexOf("/");
				if(index==-1){
					for(String addr : ChartServer.getSockets().keySet()){
						Socket clientSocket = ChartServer.getSockets().get(addr);
						PrintStream clientToAll = new PrintStream(clientSocket.getOutputStream());
						clientToAll.println(str);
					}
				}else{
					String[] ss = str.split("/");
					//ss[0]  ss[1]
					String msg = addr + "/" + ss[1];
					Socket clientSocket = ChartServer.findSocket(ss[0]);
					if(clientSocket!=null){
						PrintStream clientToClient = new PrintStream(clientSocket.getOutputStream());
						clientToClient.println(msg);
					}else{
						ps.println("@您要聊天的客户不存在");
					}


				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}






}

