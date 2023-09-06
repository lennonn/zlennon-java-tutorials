package com.zlennon.mockito.legacycode.unfavorable.construct.constructor;


import com.zlennon.mockito.legacycode.unfavorable.construct.TestingImpedimentException;

public class DatabaseDependency {
	
	public DatabaseDependency() {
		throw new TestingImpedimentException("calls database");
	}
}
