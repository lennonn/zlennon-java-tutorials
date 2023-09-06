package com.zlennon.mockito.soa.rest.controller.dao;

import com.zlennon.mockito.soa.rest.model.Student;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Component
public class StudentDao {

	private Map<String, Student> database = new HashMap<String, Student>();
	public StudentDao(){
		load();
	}
	
	public Collection<Student> retrieveAll() {
		return database.values();
	}
	
	public Student retrieve(String roleId) {
		return database.get(roleId);
	}
	
	private void load() {
		Student student = new Student();
		student.setClassName("X");
		student.setEmailId("sujoy@gmaill.com");
		student.setName("Sujoy Acharya");
		student.setRoleNumber("100");
		database.put(student.getRoleNumber(), student);
		
		student = new Student();
		student.setClassName("XII");
		student.setEmailId("leo.p@gmaiil.com");
		student.setName("Leo Anthony");
		student.setRoleNumber("101");
		database.put(student.getRoleNumber(), student);
		
		student = new Student();
		student.setClassName("XII");
		student.setEmailId("john.p@ggmail.com");
		student.setName("John Paul");
		student.setRoleNumber("7");
		database.put(student.getRoleNumber(), student);
		
		student = new Student();
		student.setClassName("XII");
		student.setEmailId("cs@yahumail.com");
		student.setName("Subodh Chavan");
		student.setRoleNumber("3");
		database.put(student.getRoleNumber(), student);
	}
}
