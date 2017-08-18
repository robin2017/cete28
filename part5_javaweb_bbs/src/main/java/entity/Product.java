package entity;

public class Product {
	private int id;
	private String proname;
	private String prodes;
	private int proCount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public String getProdes() {
		return prodes;
	}
	public void setProdes(String prodes) {
		this.prodes = prodes;
	}
	public int getProCount() {
		return proCount;
	}
	public void setProCount(int proCount) {
		this.proCount = proCount;
	}
	public Product(int id, String proname, String prodes, int proCount) {
		super();
		this.id = id;
		this.proname = proname;
		this.prodes = prodes;
		this.proCount = proCount;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}

}
