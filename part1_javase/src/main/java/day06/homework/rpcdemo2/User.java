package day06.homework.rpcdemo2;

import java.io.Serializable;

public class User implements Serializable{
	private int uid;
	private String name;
	private String pass;
	private String email;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(int uid, String name, String pass, String email) {
		super();
		this.uid = uid;
		this.name = name;
		this.pass = pass;
		this.email = email;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", pass=" + pass
				+ ", email=" + email + "]";
	}
	
}
