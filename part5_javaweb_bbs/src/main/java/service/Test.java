package service;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProductService ps = new ProductService();
		System.out.println(ps.getAll().size());
	}

}
