package com.zlennon.mockito.stub;

import com.zlennon.mockito.stub.StudentDAO;

import java.sql.SQLException;


public class ConnectionTimedOutStudentDAOStub implements StudentDAO {
	
	public String create(String name, String className) throws SQLException {
		throw new SQLException("DB connection timed out");
	}
	
}