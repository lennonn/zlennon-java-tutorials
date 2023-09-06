package com.zlennon.ftpmodule.dao.staticImpl;

import com.zlennon.ftpmodule.dao.StudentDao;
import com.zlennon.ftpmodule.entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/5/4.
 */
@Component
public class StudentDaoStaticImpl implements StudentDao {
    private static List<Student> students;

    @Override
    public List<Student> getStudents(){
        return  students;
    }

    @Override
    public void insertStudents(Student student){
        students.add(student);
    }
    static {
        students =new ArrayList<Student>(
                Arrays.asList(
                        new Student("1","test"),
                        new Student("2","student")
                )
        );

    }
}




