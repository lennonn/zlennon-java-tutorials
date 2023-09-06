package com.zlennon.mockito.fake;

import com.zlennon.mockito.dummy.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StudentDAOTest extends TestableStudentDAO {

	private TestableStudentDAO dao;
	
	@Before
	public void setup() {
		dao = new TestableStudentDAO();
	}

	@Test(expected = IllegalStateException.class)
	public void when_row_count_does_not_match_then_rollbacks_tarnsaction() {
		
		List<Student> students = new ArrayList<>();
		students.add(new Student(null, "Gautam Kohli"));

		int expectedInsertCount = 1;
		
		dao.batchUpdate(students);
		
		int actualInsertCount = dao.sqlCount.get("insert");
		
		assertEquals(expectedInsertCount, actualInsertCount);

	}

	@Test
	public void when_new_student_then_creates_student() {
		
		List<Student> students = new ArrayList<>();
		students.add(new Student(null, "Gautam Kohli"));
		dao.batchUpdate(students);

		int actualInsertCount = dao.sqlCount.get("insert");
		int expectedInsertCount = 1;
		assertEquals(expectedInsertCount, actualInsertCount);
		
	}

		@Test
		public void when_existing_student_then_updates_student_successfully() {
			
			List<Student> students = new ArrayList<>();
			students.add(new Student("001", "Mark Leo"));
	
			dao.batchUpdate(students);
			int actualUpdateCount = dao.sqlCount.get("update");
			int expectedUpdate = 1;
			
			assertEquals(expectedUpdate, actualUpdateCount);
		}

	@Test
	public void when_new_and_existing_students_then_creates_and_updates_students() {
		
		List<Student> students = new ArrayList<>();
		students.add(new Student("001", "Mark Joffe"));
		students.add(new Student(null, "John Villare"));
		students.add(new Student("002", "Maria Rubinho"));
		
		int expectedUpdateCount = 2;
		
		dao.batchUpdate(students);

		int actualUpdateCount = dao.sqlCount.get("update");
		
		assertEquals(expectedUpdateCount, actualUpdateCount);
	}

}
