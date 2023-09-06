package com.zlennon.mockito.legacycode.unfavorable.construct.finals;

public class FinalClassDependency {
	private final FinalDepencyClass finalDepencyClass;

	public FinalClassDependency(FinalDepencyClass finalDepencyClass) {
		this.finalDepencyClass = finalDepencyClass;
	}
	
	public void testMe() {
		finalDepencyClass.poison();
	}
}
