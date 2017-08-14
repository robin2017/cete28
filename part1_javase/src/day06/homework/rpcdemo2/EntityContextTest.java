package day06.homework.rpcdemo2;

import java.util.HashMap;

public class EntityContextTest {
	public static void main(String[] args) {
	    EntityContext entityContext  = EntityContext.getInstance();
	    HashMap<Integer,User> users = entityContext.getUsers();
	    for(Integer key : users.keySet()){
	    	System.out.println(users.get(key));
	    }
	}

}
