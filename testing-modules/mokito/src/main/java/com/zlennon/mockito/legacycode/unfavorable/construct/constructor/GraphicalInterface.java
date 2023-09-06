package com.zlennon.mockito.legacycode.unfavorable.construct.constructor;

import com.zlennon.mockito.legacycode.unfavorable.construct.TestingImpedimentException;

public class GraphicalInterface {

	public static void showMessage(String msg) {
		throw new TestingImpedimentException("GUI objects need manual intervention");
	}
}
