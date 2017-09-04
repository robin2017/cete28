package beans;

public class Test {

	static int method() {
		System.out.println("======");
		try {
			System.out.println("before");
			return 10;
		}finally {
			//return 20;
			System.out.println("finally");
		}
	}
	public static void main(String[] args) {
		System.out.println(method());
	}
}
