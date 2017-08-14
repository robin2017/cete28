package day03;

import day02.Student;

/**
 * Created by robin on 2017/8/11.
 */
public class ORMTest {
    public static void main(String[] args){
        Student student=new Student(1,"d","");
        Session session=new Session();
        session.save(student);
    }
}
