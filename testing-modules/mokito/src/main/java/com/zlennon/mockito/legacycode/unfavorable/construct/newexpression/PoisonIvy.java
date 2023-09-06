package com.zlennon.mockito.legacycode.unfavorable.construct.newexpression;

import com.zlennon.mockito.legacycode.unfavorable.construct.TestingImpedimentException;

public class PoisonIvy {

	public PoisonIvy() {
		throw new TestingImpedimentException(
				"Do not instantiate concrete class, use interfaces");
	}

	public void poison() {

	}
}
