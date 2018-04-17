package day02;

/**
 * Created by robin on 2017/7/27.
 */
class Student{
    private String name;
    private Double height;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
//    public boolean equals(Object obj){
//        if(obj==null)
//            return false;
//        if(this==obj)
//            return true;
//        if(!(obj instanceof Student))
//            return false;
//        Student other=(Student)obj;
//        if(this.height.equals(other.height)||this.name!=other.name)
//            return false;
//        return true;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        return !(height != null ? !height.equals(student.height) : student.height != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (height != null ? height.hashCode() : 0);
        return result;
    }
}
public class ObjectDemo1 {

}
