package day06.homework.rpcdemo2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketUtil {
	public static Response remoteCall(Request request){
		try {
			Socket socket = new Socket("127.0.0.1",9090);

	        ObjectOutputStream oos =
	        		new ObjectOutputStream(
	        				socket.getOutputStream());
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
}
