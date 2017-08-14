package day06.homework.rpcdemo2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class EntityContext {
	volatile private static EntityContext instance=null;

	public static EntityContext getInstance(){
		try{
			if(instance!=null){}
			else{
				synchronized (EntityContext.class){
					if(instance==null)
						instance=new EntityContext();
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return instance;
	}


	private HashMap<Integer, User> users = new HashMap<Integer, User>();

	private EntityContext() {
		loadUsers();
	}

	public void loadUsers() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					"user.txt")));
			String str = null;
			while ((str = br.readLine()) != null) {
				User u = new User();
				u.setUid(Integer.parseInt(str.split(":")[0]));
				u.setName(str.split(":")[1]);
				u.setPass(str.split(":")[2]);
				u.setEmail(str.split(":")[3]);
				users.put(u.getUid(), u);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HashMap<Integer, User> getUsers() {
		return users;
	}

}
