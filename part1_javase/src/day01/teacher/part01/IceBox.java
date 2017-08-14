package day01.teacher.part01;
/**����*/
public class IceBox {//IceBox
	private String brand;
	private String code;
	private Elephant elephant;
	//.....
	public void open() {
		System.out.println("����");
	}
	public void put(Elephant elephant) {
		System.out.println("�Ŵ���:"+elephant.name+"/"+elephant.birthday);
		this.elephant=elephant;
		
	}
	public void close() {
		System.out.println("����");
	}
	/**�䶳*/
    public void ice() {
    	System.out.println("�䶳");
    }	
}
