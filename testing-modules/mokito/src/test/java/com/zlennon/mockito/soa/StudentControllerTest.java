package com.zlennon.mockito.soa;

import com.zlennon.mockito.soa.rest.controller.StudentController;
import com.zlennon.mockito.soa.rest.controller.dao.StudentDao;
import com.zlennon.mockito.soa.rest.model.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {
    @Mock
	StudentDao studentDao;
    
    @InjectMocks
	StudentController controller;
	
    @Before
    public void  setUp(){
    	Student student = new Student();
    	student.setClassName("X");
    	student.setEmailId("email@mail.com");
    	student.setName("sujoy");
    	student.setRoleNumber("7");
    	Collection<Student> studentColl = new ArrayList<Student>();
    	studentColl.add(student);
    	when(studentDao.retrieveAll()).thenReturn(studentColl);
    	
    }
	@Test
	public void retrieves_students() throws Exception {
		List<Student> retrieveAll = controller.retrieveAll();
		assertNotNull(retrieveAll);
		assertFalse(retrieveAll.isEmpty());
	}
	
	@Test
	public void retieves_a_student() throws Exception {
		when(studentDao.retrieve(eq("100"))).thenReturn(new Student());
		assertNotNull(controller.retrieve("100"));
	}
	
	@Test
	public void when_invalid_role_number_returns_null() throws Exception {
		assertNull(controller.retrieve("100"));
	}
}
