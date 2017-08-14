
package day03.teacher;
import java.util.HashSet;

class Obj{
    int i;
    public Obj(int i) {
        this.i=i;
    }
    @Override
    public int hashCode() {
        return i;
    }
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return this.i==((Obj)obj).i;
    }
}

public class Test02 {
    public static void main(String[] args) {
        Obj o1=new Obj(1);
        Obj o2=new Obj(1);
        Obj o3=new Obj(1);
        HashSet<Obj> set=
                new HashSet<Obj>();
        set.add(o1);
        set.add(o2);
        set.add(o3);
        System.out.println(set.size());
        o1.i=5;
        System.out.println(set);
        set.remove(o1);
        System.out.println(set.size());
    }
}
