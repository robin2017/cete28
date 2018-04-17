package day05.homework.title1;

import java.lang.reflect.Field;
class X{
    private int id;
    private String sex;
    private int age;
}
public class LianXi1 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //B(name,age,sex,aa,bb) ===> insert into B(name,age,sex,aa,bb)values(?,?,?,?,?)
        System.out.println(getSqlReplace(new User()));
    }
    public static String getSqlReplace(Object object){
        Class c = object.getClass();
        ReplaceClass replaceClass=(ReplaceClass)c.getAnnotation(ReplaceClass.class);
        StringBuffer s = new StringBuffer();
        if(replaceClass==null) {
            String className = c.getSimpleName();
            s.append("insert into ").append(className).append("(");
        }else{
            s.append("insert into ").append(replaceClass.des()).append("(");
        }
        Field[] fs = c.getDeclaredFields();
        for(int i = 0; i < fs.length;i++){
            ReplaceField replace=fs[i].getAnnotation(ReplaceField.class);
            if(replace==null) {
                s = i == 0 ? s.append(fs[i].getName()) : s.append(",").append(fs[i].getName());
            }else{
                s = i == 0 ? s.append(replace.des()) : s.append(",").append(replace.des());
            }
        }
        s.append(") values ").append(getString(fs.length));
        return s.toString();
    }

    public static String getSql(Object object){
        Class c = object.getClass();
        String className = c.getSimpleName();
        StringBuffer s = new StringBuffer();
        s.append("insert into ").append(className).append("(");
        Field[] fs = c.getDeclaredFields();
        for(int i = 0; i < fs.length;i++){
            s = i == 0 ? s.append(fs[i].getName()) : s.append(",").append(fs[i].getName());
        }
        s.append(") values ").append(getString(fs.length));
        return s.toString();

    }
    private static String getString(int length){
        StringBuffer s = new StringBuffer();
        s.append("(");
        for(int i = 0; i <length ;i++){
            s = i==0 ? s.append("?") : s.append(",?");
        }
        return s.append(")").toString();
    }

}
