package day01.teacher.part02;

import java.util.Date;
/**��������*/
public class Animal {//new Animal()
	private int id;
	private String name;
	private Date birthday;
	
	//public Animal() {}
	public Animal(int id) {
	    this.id=id;
	}
	public Animal(String name,Date birthday) {
		this.name=name;
		this.birthday=birthday;
	}
	/**����*/
	public int attack() {
		return 0;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
}
