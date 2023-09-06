package com.zlennon.mockito.legacycode.unfavorable.construct.instantiate;

import static org.junit.Assert.*;

import com.zlennon.mockito.legacycode.unfavorable.construct.constructor.DatabaseDependency;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


public class VariableInitializationTest {
	@Mock
	DatabaseDependency dependency;
	VariableInitialization initialization;
	
	@Before
	public void setUp() throws Exception {
		initialization = new VariableInitialization(dependency);
	}
	
	@Test
	public void sanity() throws Exception {
		
	}
}
