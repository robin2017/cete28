package day03;

import day02.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by robin on 2017/8/11.
 */
public class DaoSupportTest {
    public static void main(String[] ag){
        DaoSupport<Student> ds=new DaoSupport<Student>();
        Student student=ds.findById(140754,"select * from student where stuNo=?",new StudentRowMapper());
        System.out.println(student);
    }
}
class StudentRowMapper implements RowMapper<Student>{
    @Override
    public Student getRow(ResultSet rs) throws SQLException {
        Student student=new Student(rs.getInt("stuNo"),rs.getString("stuName"),rs.getString("stuAge"));
        return student;
    }
}
