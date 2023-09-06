package com.zlennon.mockito.dummy;


import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TeacherTest {
	
	private DummyStudent dummy;
	Mark inEnglish;
	Mark inMath;
	Mark inHistory;
	List<Mark> marks;
	
	@Before
	public void initialize() {
		dummy = new DummyStudent();
		
		inEnglish = new Mark(dummy, "English001", new BigDecimal("81.00"));
		inMath = new Mark(dummy, "Math002", new BigDecimal("97.00"));
		inHistory = new Mark(dummy, "History003", new BigDecimal("79.00"));
		
	    marks = Arrays.asList(inEnglish, inMath, inEnglish);
		
	}
	
	@Test
	public void when_marks_above_seventy_five_percent_returns_VERY_GOOD() {
		Grade grade = new Teacher().generateGrade(marks);
		assertEquals(Grade.VeryGood, grade);
	}
}
