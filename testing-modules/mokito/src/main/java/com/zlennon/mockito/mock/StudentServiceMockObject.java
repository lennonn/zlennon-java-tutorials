package com.zlennon.mockito.mock;

import com.zlennon.mockito.spy.MethodInvocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StudentServiceMockObject {

	private Map<String, List<MethodInvocation>> invocationMap = new HashMap<>();

	void registerMethodCall(MethodInvocation invocation) {
		List<MethodInvocation> list = invocationMap.get(invocation.getMethod());
		if (list == null) {
			list = new ArrayList<>();
		}
		if (!list.contains(invocation)) {
			list.add(invocation);
		}

		invocationMap.put(invocation.getMethod(), list);
	}

	public int getNumberOfMethodInvocation(String methodName) {
		List<MethodInvocation> list = invocationMap.get(methodName);
		if (list == null) {
			return 0;
		}

		return list.size();
	}

	public MethodInvocation getMethodArguments(String methodName, int invocationIndex) {
		List<MethodInvocation> list = invocationMap.get(methodName);
		if (list == null || (invocationIndex > list.size())) {
			return null;
		}

		return list.get(invocationIndex - 1);
	}

	public void verify(String methodName, int numberOfInvocation) {
		int actual = getNumberOfMethodInvocation(methodName);
		if (actual != numberOfInvocation) {
			throw new IllegalStateException(methodName + " was expected [" + numberOfInvocation+ "]  + "
					+ "times but actuallyactaully invoked[" + actual + "] times");
		}
	}

}
