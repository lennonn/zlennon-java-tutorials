package com.zlennon.mockito.spy;

import com.zlennon.mockito.dummy.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {

	private Map<String, List<Student>> studentCouseMap = new HashMap<>();
	List<Student> students;
	private StudentServiceSpy spy;
	
	public void setSpy(StudentServiceSpy spy) {
		this.spy =spy;
	}
	
	
	public void enrollToCourse(String courseName, Student student) {
		
		registerStudentServiceMethodCall(courseName, student, "enrollToCourse");
		
		students = retrieveStudentsFromCourseMap(courseName);
		addStudentToList(student);
		studentCouseMap.put(courseName, students);
		
	}
	
	protected void registerStudentServiceMethodCall(String courseName, Student student, String methodName) {
		
		MethodInvocation invocation = new MethodInvocation();
		invocation.addParam(courseName).addParam(student).setMethod(methodName);
		spy.registerMethodCall(invocation);
		
	}

	protected List<Student> retrieveStudentsFromCourseMap(String courseName) {
		
		students = studentCouseMap.get(courseName);
		if (students == null) {
			students = new ArrayList<>();
		}
		return students;
		
	}

	protected void addStudentToList(Student student) {
		
		if (!students.contains(student)) {
			students.add(student);
		}
		
	}

}
