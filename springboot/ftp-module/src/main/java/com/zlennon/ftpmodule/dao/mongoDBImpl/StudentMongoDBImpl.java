package com.zlennon.ftpmodule.dao.mongoDBImpl;

import com.zlennon.ftpmodule.dao.StudentDao;
import com.zlennon.ftpmodule.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/5/6.
 */
@Repository
@Qualifier("mongoDBStudent")
public class StudentMongoDBImpl implements StudentDao {
    //@Resource
   //private MongoTemplate mongoTemplate;
    @Override
    public List<Student> getStudents() {
       // return mongoTemplate.findAll(Student.class);
        return null;
    }

    @Override
    public void insertStudents(Student student) {

    }
}
