package com.zlennon.string;

import org.junit.Test;

public class StrSubStringTest {
	@Test
	public String f() {
		String professionalName = "专业名称";
		String pName1 = "专业(测试)";
		String pName11 = pName1.substring(0, pName1.indexOf("("));// 截取第一个（前的名称继续查找
		if (pName11.equals(professionalName)) {
			return pName1;	
		} else {
			String pName2 = "专业(测试)名称";
			String pName3 = pName2.substring(1, pName2.indexOf("("));
			String pName4 = pName2.substring(pName2.lastIndexOf(")")+1);
			String pName5 = (pName3 + pName4).trim();
			if(pName5.equals(professionalName)) {
				return pName5;
			}else {
				return pName2;
			}
		}

	}
	
	@Test
	public void run() {
		String str =f();
		System.out.println(str);
	}
}
