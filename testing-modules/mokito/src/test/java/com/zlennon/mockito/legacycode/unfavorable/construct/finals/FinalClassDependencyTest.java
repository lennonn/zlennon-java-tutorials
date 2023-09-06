package com.zlennon.mockito.legacycode.unfavorable.construct.finals;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FinalClassDependencyTest {
	@Mock
	FinalDepencyClass finalDependency;
	
	FinalClassDependency test;

	@Before
	public void setUp() {
		test = new FinalClassDependency(finalDependency);
	}
	@Test
	public void testMe() throws Exception {
		Mockito.doNothing().when(finalDependency).poison();
		test.testMe();
	}
}
