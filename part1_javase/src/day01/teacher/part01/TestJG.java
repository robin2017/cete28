package day01.teacher.part01;//�������

import java.util.Arrays;
import java.util.Scanner;

/**�Ź�������(3*3)
 * ��һ�����֣�row=0,col=3/2
 * �ڶ�������: Ĭ�������Ӧ����
 * ��һ���������Ϸ�
 * 1)��Խ�磬�в�Խ��(��д�ڱ��е���׶�:row=2)
 * 2)��Խ�磬�в�Խ��(��д�ڱ��еĵ�0��:col=0)
 * 3)���ж�Խ��(��д����һ�������·�row+2,col--)
 * 4)���Ϸ��Ѿ�����(��д����һ�������·�row+2,col--)
 * */
public class TestJG {//����һ��Java��
    //.java-->.class-->0101
	//JVM
	public static void main(String[] args) {
		//1.����һ���洢�����Ķ�ά����
		//1.1�Ӽ�������һ������
		System.out.println("please input number:");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();//����һ������
		//1.2ͨ�������������ʼ������
		int[][] array=
		new int[n][n];
		//2.����һ��ѭ����ѭ��9�Σ��洢9����
		//2.1��ȷ����һ������λ��
		int row=0;
		int col=n/2;//1
		for(int i=1;i<=n*n;i++) {
		//2.2��д����
		   array[row][col]=i;
		//2.3������һ�����ֵ�Ĭ��λ��
		   row--;
		   col++;
		//2.4�ж������Ƿ��ܹ�����ڴ�λ��
		//2.4.1 ��Խ��,�в�Խ��
		  if(row==-1&&col<n) {
			  row=n-1;
	     //2.4.2 �в�Խ��,��Խ��
		  }else if(row>=0&&col==n) {
			  col=0;
		 //2.4.3 ���ж�Խ��
		  }else if(row==-1&&col==n) {
			  row+=2;col--;
		 //2.4.3 λ���Ѿ���ռ��
		  }else if(array[row][col]!=0) {
			  row+=2;col--;
		  }
		}
		print(array);//alt+shift+m
	}

	private static void print(int[][] array) {
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				System.out.print(array[i][j]+"\t");
			}//���ÿ�ж�Ӧ���ϵ�ֵ
			System.out.println();//���һ�����з�
		}
	}
	
}
/**
 * 1.����
 * 1)����(�������ͣ���������)
 * a)��������(byte,short,int,long,float,double,char,boolean)
 * b)��������(array[],....)
 * 
 * 2)������(��ʵ��������������������������ֲ�����)
 * 
 * 2.���(˳�򣬷�֧��ѭ��)
 * 
 * 
 */
