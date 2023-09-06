package com.zlennon.mockito.legacycode.unfavorable.construct.finals;

import com.zlennon.mockito.legacycode.unfavorable.construct.TestingImpedimentException;

public class FinalDependency {

	public final void doSomething() {
		/*throw new TestingImpedimentException(
				"Final methods cannot be overriden");*/
	}
}
