package com.zlennon.string.regex;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegextTest {
	private static final Pattern pattern = Pattern.compile("\\s*");

	@Test
	public void test() {
		String regex ="('|')(.*?)(\1)";
		Pattern p=Pattern.compile(regex); 
		String str ="'Hello', 'World'";
		Matcher re=p.matcher(str);
		 while(re.find()){
			 System.out.println(re.group());
		 }

	}

	@Test
	public void test1(){
		String s="sfFSSDF";

		byte[] byteSig = s.getBytes(StandardCharsets.UTF_8);
		String s1= s.replaceAll(pattern.pattern(), "");
		String s2 = pattern.matcher(s).replaceAll("");
		System.out.println(s1+"---"+s2);
		System.out.println(s.toLowerCase(Locale.CHINA));
	}

}
