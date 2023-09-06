package com.zlennon.ftpmodule.service;

import com.zlennon.ftpmodule.dao.mongoDBImpl.StudentMongoDBImpl;
import com.zlennon.ftpmodule.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/4.
 */
@Service
public class StudentService {
    @Autowired
    @Qualifier("mongoDBStudent")
    StudentMongoDBImpl studentDao;
    public List<Student> getStudents(){
      return  studentDao.getStudents();
    }
    public void insertStudents(Student student){
        studentDao.insertStudents(student);
    }
}








