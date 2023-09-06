package com.zlennon.mockito.soa.rest.controller;

import com.zlennon.mockito.soa.rest.controller.dao.StudentDao;
import com.zlennon.mockito.soa.rest.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/college")
public class StudentController {
	@Autowired
	private StudentDao studentDao;
	
	@RequestMapping(value = "/students/{roleNumber}", method = RequestMethod.GET)
	public @ResponseBody
	Student retrieve(@PathVariable String roleNumber) {
		return studentDao.retrieve(roleNumber);
	}

	@RequestMapping(value = "/students/", method = RequestMethod.GET)
	public @ResponseBody List<Student> retrieveAll() {
		return new ArrayList<>(studentDao.retrieveAll());
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
}
