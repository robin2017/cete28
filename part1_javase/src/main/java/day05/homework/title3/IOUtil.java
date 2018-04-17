package day05.homework.title3;

import java.io.File;

/**
 * Created by robin on 2017/8/7.
 */
public class IOUtil {
    public static void main(String[] args){
        findFiles(new File("fff"));
    }

    /*
     * 删除一个目录
     * 请在磁盘中删除file
     * @param file
     */
    public static void delDirectory(File file){
        File[] files=file.listFiles();
        for(File f:files){
            if(f.isFile())
                f.delete();
            else {
                delDirectory(f);
                f.delete();
            }
        }
        file.delete();
    }
    /**
     * 查找并遍历文件
     * 请查找出file所代表的目录中的所有.java文件
     * @param file
     */
    private static String regex=".*?java";
    public static void findFiles(File file){
      for(File fi:file.listFiles()){
          if(fi.isDirectory())
              findFiles(fi);
          else{
              if(fi.getName().matches(regex))
                  System.out.println(fi.getName());
          }
      }
    }
}


