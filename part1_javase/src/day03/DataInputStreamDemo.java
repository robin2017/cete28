package day03;

import java.io.*;

/**
 * Created by robin on 2017/7/28.
 */
public class DataInputStreamDemo {
    public static void main(String[] args) throws IOException {
  		/*数据流
		 * 优势读取基本数据类+String
		 */
        String src = "e:/JAVA/a.txt";
        String dst = "e:/JAVA/b.txt";
        DataInputStream in = null;
        DataOutputStream out = null;
        in = new DataInputStream(new FileInputStream(src));

        out = new DataOutputStream(new FileOutputStream(dst));
        out.writeInt(65);
        out.writeInt(97);
        out.writeBoolean(true);

        out.close();
        in.close();
    }
}
