package com.zlennon.mockito.stub;

import org.junit.Test;

import static org.junit.Assert.assertFalse;


public class StudentServiceTest {

	private StudentService studentService;
	
	@Test
	public void when_connection_times_out_then_the_student_is_not_saved() {
		studentService = new StudentServiceImpl(new ConnectionTimedOutStudentDAOStub());
		
		String classNumber = "IX";
		String studentName = "John Smith";
		
		CreateStudentResponse resp = studentService.create(studentName, classNumber);
		assertFalse(resp.isSuccess());
	}
	
}
