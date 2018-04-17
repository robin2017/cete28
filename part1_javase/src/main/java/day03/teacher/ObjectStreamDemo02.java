package day03.teacher;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Customer implements Serializable{
	private static final long serialVersionUID = 1105467217843196411L;
	private String name;
	private int age;
	public Customer(String name,int age) {
		this.name=name;
		this.age=age;
	}
	private void writeObject(ObjectOutputStream out) 
	throws IOException{
		System.out.println("==writeObject==");
		age=age>>2;
		out.defaultWriteObject();//��ִ�����л�
	}
	private void readObject(ObjectInputStream in) 
	throws IOException,ClassNotFoundException{
		System.out.println("==readObject==");
		in.defaultReadObject();//�ȷ����л�
		age=age<<2;
	}
	@Override
	public String toString() {
		return name+"/"+age;
	}
}
public class ObjectStreamDemo02 {
   public static void main(String[] args) 
   throws Exception{
	  Customer c1=new Customer("A",8);
	  System.out.println("c1="+c1);
	  ObjectOutputStream out=null;
	  ObjectInputStream in=null;
	  
	  out=new ObjectOutputStream(
	  new FileOutputStream("o2.txt"));
	  //���л�
	  out.writeObject(c1);
	  out.close();
	  in=new ObjectInputStream(
	  new FileInputStream("o2.txt"));
	  //�����л�
	  Customer c2=(Customer)in.readObject();
	  System.out.println("c2="+c2);
	  in.close();
   }
}
