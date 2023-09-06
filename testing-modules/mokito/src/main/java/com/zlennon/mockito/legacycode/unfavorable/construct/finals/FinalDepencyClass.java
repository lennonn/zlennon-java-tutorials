package com.zlennon.mockito.legacycode.unfavorable.construct.finals;

import com.zlennon.mockito.legacycode.unfavorable.construct.TestingImpedimentException;

public final class FinalDepencyClass {

	public void poison() {
		throw new TestingImpedimentException("Finals cannot be mocked");
	}
}
