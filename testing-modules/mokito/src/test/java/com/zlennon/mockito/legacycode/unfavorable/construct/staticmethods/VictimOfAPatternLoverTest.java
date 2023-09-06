package com.zlennon.mockito.legacycode.unfavorable.construct.staticmethods;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class VictimOfAPatternLoverTest {
	@Mock
	SingletonDependency dependency;
	VictimOfAPatternLover aPatternLover;

	@Before
	public void setUp() throws Exception {
		aPatternLover = new VictimOfAPatternLover(dependency);
	}
	
	@Test
	public void testMe() throws Exception {
		//Mockito.doNothing().when(dependency).wrapper();
		aPatternLover.testMe();
	}

}
