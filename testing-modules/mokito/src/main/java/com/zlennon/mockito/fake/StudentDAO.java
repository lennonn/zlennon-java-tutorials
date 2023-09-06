package com.zlennon.mockito.fake;

import com.zlennon.mockito.dummy.Student;

import java.util.List;


public interface StudentDAO {

	void batchUpdate(List<Student> students);
	
}
