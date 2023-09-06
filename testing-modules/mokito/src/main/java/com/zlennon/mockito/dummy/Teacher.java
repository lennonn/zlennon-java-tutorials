package com.zlennon.mockito.dummy;

import java.math.BigDecimal;
import java.util.List;

public class Teacher {

	private int numberOfSubjects;
	List<Mark> marks;

	public Grade generateGrade(List<Mark> marks) {
		this.marks = marks;

		BigDecimal average = calculateAverage();

		if (average.compareTo(new BigDecimal("90.00")) > 0) {
			return Grade.Excellent;
		}

		if (average.compareTo(new BigDecimal("75.00")) > 0) {
			return Grade.VeryGood;
		}

		if (average.compareTo(new BigDecimal("60.00")) > 0) {
			return Grade.Good;
		}

		if (average.compareTo(new BigDecimal("40.00")) > 0) {
			return Grade.Average;
		}

		return Grade.Poor;
	}

	private BigDecimal getAggregatedMarks() {

		setNumberOfSubjects(marks.size());

		BigDecimal aggregate = BigDecimal.ZERO;

		for (Mark mark : marks) {
			aggregate = aggregate.add(mark.getMark());
		}

		return aggregate;
	}

	private void setNumberOfSubjects(int size) {
		this.numberOfSubjects = size;
	}

	private BigDecimal calculateAverage() {

		return new BigDecimal(getAggregatedMarks().doubleValue() / getNumberOfSubjects());
	}

	public int getNumberOfSubjects() {
		return numberOfSubjects;
	}
}
