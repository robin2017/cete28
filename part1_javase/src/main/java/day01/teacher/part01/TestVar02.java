package day01.teacher.part01;

public class TestVar02 {

	public static void main(String[] args) {
		int[] array= {1,2,3};
		change(array);
		System.out.println(array[0]);
	}
	public static void change(int array[]) {
		array[0]=5;
	}
}
