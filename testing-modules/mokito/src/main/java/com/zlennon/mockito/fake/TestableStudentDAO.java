package com.zlennon.mockito.fake;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestableStudentDAO extends StudentDAOImpl {

	int[] valuesToReturn;
	protected Map<String, Integer> sqlCount = new HashMap<String, Integer>();
	
	public int update(String sql, List<Map<String, Object>> params) {
		Integer count = sqlCount.get(sql);
		if (count == null) {
			sqlCount.put(sql, params.size());
		} else {
			sqlCount.put(sql, count + params.size());
		}

		if (sqlCount != null) {
			return sqlCount.size();
		} else {
			return 0;
		}

	}
}
