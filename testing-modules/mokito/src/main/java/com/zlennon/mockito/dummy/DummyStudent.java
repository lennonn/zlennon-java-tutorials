package com.zlennon.mockito.dummy;


/**
 * @author P100X1
 * For creating dummy object
 */
public class DummyStudent extends Student{
	
	public DummyStudent() {
		super(null, null);
	}
	
	public String getRoleNumber( ) {
		throw new RuntimeException("Dummy Student");
	}
	
	public String getName() {
		throw new RuntimeException("Dummy Student");
	}
}
