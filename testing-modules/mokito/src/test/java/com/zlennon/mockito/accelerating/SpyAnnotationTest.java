package com.zlennon.mockito.accelerating;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class SpyAnnotationTest {

	@Spy
	ErrorHandler errorHandler;
	
	@Test
	public void when_spy_annotation_is_used() throws Exception {
		assertNotNull(errorHandler);
	}
}

