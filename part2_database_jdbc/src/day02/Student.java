package day02;

/**
 * Created by robin on 2017/8/10.
 */
public class Student {
    private int StuNo;
    private String StuName;
    private String StuAge;

    public Student(int stuNo, String stuName, String stuAge) {
        StuNo = stuNo;
        StuName = stuName;
        StuAge = stuAge;
    }

    public int getStuNo() {
        return StuNo;
    }

    public void setStuNo(int stuNo) {
        StuNo = stuNo;
    }

    public String getStuName() {
        return StuName;
    }

    public void setStuName(String stuName) {
        StuName = stuName;
    }

    public String getStuAge() {
        return StuAge;
    }

    public void setStuAge(String stuAge) {
        StuAge = stuAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "StuNo=" + StuNo +
                ", StuName='" + StuName + '\'' +
                ", StuAge='" + StuAge + '\'' +
                '}';
    }
}
