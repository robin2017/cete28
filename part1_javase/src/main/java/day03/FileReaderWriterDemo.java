package day03;

import java.io.*;

/**
 * Created by robin on 2017/7/28.
 */
public class FileReaderWriterDemo {

    public void copy(File src,File dest) throws IOException {
        FileReader in=null;
        FileWriter out=null;

        in=new FileReader(src);
        out=new FileWriter(dest);
        char[] buf=new char[124];
        int len=-1;
        while((len=in.read(buf))!=-1){
            out.write(buf,0,len);
        }
        out.close();
    }

    public static void main(String[] args){

    }
}
