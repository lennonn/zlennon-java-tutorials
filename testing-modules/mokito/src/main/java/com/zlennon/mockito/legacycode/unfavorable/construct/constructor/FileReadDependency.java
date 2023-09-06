package com.zlennon.mockito.legacycode.unfavorable.construct.constructor;


import com.zlennon.mockito.legacycode.unfavorable.construct.TestingImpedimentException;

public class FileReadDependency {
	public FileReadDependency() {
		throw new TestingImpedimentException("File read error");
	}
}
