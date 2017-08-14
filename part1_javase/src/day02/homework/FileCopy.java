package day02.homework;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * Created by robin on 2017/7/28.
 * ref:https://my.oschina.net/biezhi/blog/486030
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {
        File file1=new File("/Users/robin/WorkInfo/cetc28/cetc28_code/part1_javase/file1.txt");
        File file2=new File("/Users/robin/WorkInfo/cetc28/cetc28_code/part1_javase/file2.txt");
        long start,end;
        start=System.currentTimeMillis();
        copyFileUsingFileStreams(file1,file2);
        end=System.currentTimeMillis();
        System.out.println("io方式用时："+(end-start));


        start=System.currentTimeMillis();
        copyFileUsingFileChannels(file1,file2);
        end=System.currentTimeMillis();
        System.out.println("nio方式用时："+(end-start));


    }
    /**nio---FileChannel实现，高效*/
    private static void copyFileUsingFileChannels(File source, File dest) throws IOException {
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            inputChannel = new FileInputStream(source).getChannel();
            outputChannel = new FileOutputStream(dest).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } finally {
            inputChannel.close();
            outputChannel.close();
        }
    }

    /** 每次一个字节，太低效了*/
    private static void copyFileUsingFile(File src,File dest)
            throws IOException {
        FileOutputStream out=null;
        FileInputStream in=null;
        in=new FileInputStream(src);
        out=new FileOutputStream(dest);
        int content=0;
        while((content=in.read())!=-1) {
            out.write(content);
        }
    }
    /** io---BufferedInputStrean实现，低效*/
    private static void copyFileUsingFileStreams(File source, File dest)
            throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new BufferedInputStream(new FileInputStream(source));
            output = new BufferedOutputStream(new FileOutputStream(dest));
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf))!=-1) {
                output.write(buf, 0, bytesRead);
            }
        } finally {
            input.close();
            output.close();
        }
    }

}
