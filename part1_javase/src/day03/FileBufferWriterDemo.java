package day03;

import java.io.*;

/**
 * Created by robin on 2017/7/28.
 */
public class FileBufferWriterDemo {
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("dd.txt"));
        bufferedWriter.newLine();

        PrintWriter printWriter=new PrintWriter(new FileWriter("dd.txt"));
        printWriter.println("hello");


        BufferedReader bufferedReader=new BufferedReader(new FileReader("dd.txt"));
        String line=null;
        while(((line=bufferedReader.readLine())!=null)){
            System.out.println(line);
        }
    }
}
