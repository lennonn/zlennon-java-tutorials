package com.zlennon.ftpmodule.dao;


import com.zlennon.ftpmodule.entity.Student;

import java.util.List;

/**
 * Created by Administrator on 2017/5/6.
 */
public interface StudentDao {
    List<Student> getStudents();

    void insertStudents(Student student);
}
