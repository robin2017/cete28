package day03;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by robin on 2017/7/28.
 */
public class ByteArrayStreamDemo {
    public static void main(String[] args) throws IOException {
        ByteArrayInputStream inputStream=null;
        ByteArrayOutputStream outputStream=null;

        String s1=new String("hello");
        outputStream=new ByteArrayOutputStream();
        outputStream.write(s1.getBytes());
        System.out.println(Arrays.toString(outputStream.toByteArray()));


        inputStream=new ByteArrayInputStream(outputStream.toByteArray());
        byte buff[] =new byte[96];
        inputStream.read(buff);
        System.out.println(new String(buff));
    }
}
