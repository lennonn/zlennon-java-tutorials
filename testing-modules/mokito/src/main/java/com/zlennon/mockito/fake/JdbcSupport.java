package com.zlennon.mockito.fake;

import java.util.List;
import java.util.Map;

public class JdbcSupport {

	public int batchUpdate(String sql, List<Map<String, Object>> param) {
		// original db access code is hidden
		return 0;
	}
	
}
