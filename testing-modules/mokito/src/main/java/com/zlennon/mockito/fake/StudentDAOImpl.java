package com.zlennon.mockito.fake;


import com.zlennon.mockito.dummy.Student;

import java.util.*;

public class StudentDAOImpl implements StudentDAO {

	public StudentDAOImpl() {}
	
	@Override
	public void batchUpdate(List<Student> students) {

		Collection<Student> insertStudents = new ArrayList<>();
		Collection<Student> updateStudents = new ArrayList<>();

		determineListToPersist(students, insertStudents, updateStudents);

		int rowsInserted = 0;
		int rowsUpdated = 0;

		rowsInserted = batchInsertStudents(insertStudents, rowsInserted);

		rowsUpdated = batchUpdateStudents(updateStudents, rowsUpdated);

		if (students.size() != (rowsInserted + rowsUpdated)) {
			throw new IllegalStateException("Database update error, expected " + students.size()
					+ " updates but actual " + (rowsInserted + rowsUpdated));
		}

	}

	private void determineListToPersist(List<Student> students, Collection<Student> insertStudents,
			Collection<Student> updateStudents) {
		for (Student student : students) {
			if (student.getRoleNumber() == null) {
				insertStudents.add(student);
			} else {
				updateStudents.add(student);
			}
		}
	}

	private int batchUpdateStudents(Collection<Student> updateStudents, int rowsUpdated) {
		if (!updateStudents.isEmpty()) {
			List<Map<String, Object>> paramList = new ArrayList<>();
			for (Student student : updateStudents) {
				Map<String, Object> param = new HashMap<>();
				param.put("roleId", student.getRoleNumber());
				param.put("name", student.getName());
				paramList.add(param);
			}

			rowsUpdated = update("update", paramList);
		}
		return rowsUpdated;
	}

	private int batchInsertStudents(Collection<Student> insertStudents, int rowsInserted) {
		if (!insertStudents.isEmpty()) {
			List<Map<String, Object>> paramList = new ArrayList<>();
			for (Student student : insertStudents) {
				Map<String, Object> param = new HashMap<>();
				param.put("name", student.getName());
				paramList.add(param);
			}

			rowsInserted = update("insert", paramList);
		}
		return rowsInserted;
	}

	public int update(String sql, List<Map<String, Object>> params) {
		return new JdbcSupport().batchUpdate(sql, params);
	}


}
