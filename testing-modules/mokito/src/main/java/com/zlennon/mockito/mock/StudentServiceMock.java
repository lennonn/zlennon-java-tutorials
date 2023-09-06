package com.zlennon.mockito.mock;


import com.zlennon.mockito.dummy.Student;
import com.zlennon.mockito.spy.MethodInvocation;
import com.zlennon.mockito.spy.StudentService;

public class StudentServiceMock extends StudentService {
	
	private StudentServiceMockObject mock;
	
	public void setMock(StudentServiceMockObject mock)  {
		this.mock = mock;
	}

	@Override
	protected void registerStudentServiceMethodCall(String courseName, Student student, String methodName) {
		
		MethodInvocation invocation = new MethodInvocation();
		invocation.addParam(courseName).addParam(student).setMethod(methodName);
		mock.registerMethodCall(invocation);
		
	}
}
