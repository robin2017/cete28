package day03;

import java.io.File;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by robin on 2017/7/28.
 */
public class FileDemo01 {
    public static void main(String[] ag) throws IOException {

        //生成文件在工程根目录，不是模块根目录
        //创建文件对象
        File file = new File("fuddfuu.txt");
        if (!file.exists()) {
            //创建文件
            file.createNewFile();
            System.out.println("ok");

        }
        Socket socket=new Socket("117.136.45.129",220);
        System.out.println();socket.isConnected();
    }
}
