package day06.homework.rpcdemo;

import java.util.HashMap;

public class EntityContextTest {
	public static void main(String[] args) {
	    EntityContext entityContext  = new EntityContext();
	    HashMap<Integer,User> users = entityContext.getUsers();
	    for(Integer key : users.keySet()){
	    	System.out.println(users.get(key));
	    }
	}

}
