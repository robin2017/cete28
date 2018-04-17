package day06.homework.rpcdemo2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

public class MainServer {
	static HashMap<String,Date> sessionMap=new HashMap<String, Date>();
	public static void main(String[] args) {
		try {
			ServerSocket s = new ServerSocket(9090);
			System.out.println("服务已经开启，等待客户来访问");
			while(true){
				Socket socket = s.accept();
				System.out.println("接收到客户"+socket.getInetAddress().getHostAddress()+"的访问");
				new MyThread(socket).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static Request getRequest(Socket socket)throws Exception{
		ObjectInputStream ois =
				new ObjectInputStream(socket.getInputStream());
		Request request =(Request) ois.readObject();
		return request;
	}
	private static Object invokeMethod(Request request)throws Exception{
		UserServiceImpl us = new UserServiceImpl();
		EntityContext entityContext = EntityContext.getInstance();
		us.setEntityContext(entityContext);
		Method method = us.getClass().getMethod(request.getMethodName(),request.getParamTypes());
		try {
			Object obj = method.invoke(us, request.getObjs());
			return obj;
		}catch (InvocationTargetException e) {
			throw new RuntimeException(e.getTargetException());
		}catch(Exception e){
			throw e;
		}
	}
	static class MyThread extends Thread{
		private Socket socket;
		public MyThread(Socket socket){
			this.socket = socket;
		}
		@Override
		public void run() {
			Response response = new Response();
			ObjectOutputStream oos = null;
			try {
				Request request = getRequest(socket);
				Object obj = invokeMethod(request);
				//此时登陆成功
				String sessionId=request.getSessionId();
				if(sessionMap.containsKey(sessionId)) {
					System.out.println("客户端: "+sessionId+"   上次登陆时间：" + sessionMap.get(sessionId));
					sessionMap.put(sessionId,new Date());
				}
				else {
					String id=UUID.randomUUID().toString();
					System.out.println("客户端: "+id+"    首次登陆！！");
					response.setSessionId(id);
					sessionMap.put(id,new Date());
				}

				response.setObj(obj);
			} catch (Exception e) {
				response.setException(e);
			}finally{
				try {
					response.setSuccess();
					oos = new ObjectOutputStream(socket.getOutputStream());
					oos.writeObject(response);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
}
