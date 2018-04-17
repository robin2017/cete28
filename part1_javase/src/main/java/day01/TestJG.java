package day01; /**
 * Created by robin on 2017/7/26.
 */

import java.util.Scanner;

/**九宫格填数
 * 第一个数字:row=1,col=3/2
 * 第二个数字： 默认数字是右上方row++,col++
 *    （1）行越界,行不越界：填写在本列最低端，row=2
 *    （2）列越界，列不越界：填写在本行第0列，col=1（与上逻辑不同）
 *    （3）行列都越界：上一个数的下方，row+2，col--
 *    （4）右上方有数据了：填写在上一个数的下方row+2，col--（与上一样）
 * */
public class TestJG {
    //.java-->.class-->0101
    //JVM
    public static void main(String[] args){
        System.out.println("please input number:");
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()) {
            int n=scanner.nextInt();
            //1、定义一个存储整数的二维数组
            int[][] array = new int[n][n];
            //2、定义一个循环，循环9次，存储9个整数
            //2.1  先确定第一个数位置
            int row = 0;
            int col = n / 2;
            for (int i = 1; i <= n*n; i++) {
                array[row][col] = i;
                //计算下一个数的位置
                row--;
                col++;
                //判定数字是否能够填充在位置，保证逻辑与注释一样
                if (row == -1 && col < n) {
                    row = n-1;
                } else if (col == n && row >= 0) {
                    col = 0;
                } else if (row == -1 && col == n) {
                    row += 2;
                    col--;
                } else if (array[row][col] != 0) {
                    row += 2;
                    col--;
                }
            }
            print(array);
        }
    }
    private static void print(int[][] array){
        for(int i=0;i<array.length;i++){
            for (int j=0;j<array[i].length;j++){
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }
    }
}


/*1、变量
* 2、语句
* 3、作用域（实例变量，类变量，参数变量，局部变量）
* */