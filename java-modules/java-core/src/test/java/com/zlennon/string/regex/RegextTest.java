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
		String s="ABC  DSF";

		byte[] byteSig = s.getBytes(StandardCharsets.UTF_8);
		String s1= s.replaceAll(pattern.pattern(), "");
		String s2 = pattern.matcher(s).replaceAll("");
		System.out.println(s1+"---"+s2);
		System.out.println(s.toLowerCase(Locale.CHINA));
	}


	//基本使用
	@Test
	public void characterClass(){
		String text = "A sample text with 123 numbers and some symbols: @#$";

		// 匹配所有数字字符
		Pattern digitPattern = Pattern.compile("[0-9]");
		Matcher digitMatcher = digitPattern.matcher(text);

		System.out.println("匹配所有数字字符:");
		while (digitMatcher.find()) {
			System.out.print(digitMatcher.group() + " ");
		}
		System.out.println();

		// 匹配所有大写字母
		Pattern uppercaseLetterPattern = Pattern.compile("[A-Z]");
		Matcher uppercaseLetterMatcher = uppercaseLetterPattern.matcher(text);

		System.out.println("匹配所有大写字母:");
		while (uppercaseLetterMatcher.find()) {
			System.out.print(uppercaseLetterMatcher.group() + " ");
		}
		System.out.println();

		// 匹配所有小写字母
		Pattern lowercaseLetterPattern = Pattern.compile("[a-z]");
		Matcher lowercaseLetterMatcher = lowercaseLetterPattern.matcher(text);

		System.out.println("匹配所有小写字母:");
		while (lowercaseLetterMatcher.find()) {
			System.out.print(lowercaseLetterMatcher.group() + " ");
		}
		System.out.println();

		// 匹配所有字母和数字字符
		Pattern alphaNumericPattern = Pattern.compile("[a-zA-Z0-9]");
		Matcher alphaNumericMatcher = alphaNumericPattern.matcher(text);

		System.out.println("匹配所有字母和数字字符:");
		while (alphaNumericMatcher.find()) {
			System.out.print(alphaNumericMatcher.group() + " ");
		}
		System.out.println();

		// 匹配所有非字母和非数字字符
		Pattern nonAlphaNumericPattern = Pattern.compile("[^a-zA-Z0-9]");
		Matcher nonAlphaNumericMatcher = nonAlphaNumericPattern.matcher(text);

		System.out.println("匹配所有非字母和非数字字符:");
		while (nonAlphaNumericMatcher.find()) {
			System.out.print(nonAlphaNumericMatcher.group() + " ");
		}
		System.out.println();
	}


	//使用分组匹配
	@Test
	public void useGroup(){
		// 要匹配的文本
		String text = "我的电话号码是 (123) 456-7890，另一个号码是 (555) 555-5555。";

		// 定义正则表达式，使用分组捕获区号和电话号码
		String regex = "\\((\\d{3})\\) (\\d{3}-\\d{4})";

		// 编译正则表达式
		Pattern pattern = Pattern.compile(regex);

		// 创建匹配器对象
		Matcher matcher = pattern.matcher(text);

		// 查找匹配
		while (matcher.find()) {
			// 获取完整匹配
			String fullMatch = matcher.group(0);

			// 获取第一个分组（区号）
			String areaCode = matcher.group(1);

			// 获取第二个分组（电话号码）
			String phoneNumber = matcher.group(2);

			// 输出结果
			System.out.println("完整匹配: " + fullMatch);
			System.out.println("区号: " + areaCode);
			System.out.println("电话号码: " + phoneNumber);
		}
	}


	//反向引用，查找替换
	@Test
	public void backReference() {
		// 要匹配的文本
		String text = "This is an example example example。";

		// 定义正则表达式，使用反向引用匹配重复的单词
		String regex = "\\b(\\w+)\\s+\\1\\b";

		// 编译正则表达式
		Pattern pattern = Pattern.compile(regex);

		// 创建匹配器对象
		Matcher matcher = pattern.matcher(text);

		// 查找匹配
		while (matcher.find()) {
			// 获取完整匹配
			String fullMatch = matcher.group(0);

			// 获取第一个分组（重复的单词）
			String repeatedWord = matcher.group(1);
			String replace = matcher.replaceFirst("$1 is replaced");
			System.out.println("替换: " + replace);

			// 输出结果
			System.out.println("完整匹配: " + fullMatch);
			System.out.println("重复的单词: " + repeatedWord);
		}
	}

	@Test
	public  void greedyVsLazyMatching(){
		String text = "This is a <b>sample</b> text with <b>multiple</b> HTML tags.";

		// 贪婪匹配示例
		Pattern greedyPattern = Pattern.compile("<b>.*</b>");
		Matcher greedyMatcher = greedyPattern.matcher(text);

		if (greedyMatcher.find()) {
			System.out.println("贪婪匹配: " + greedyMatcher.group());
		}

		// 非贪婪匹配示例
		Pattern lazyPattern = Pattern.compile("<b>.*?</b>");
		Matcher lazyMatcher = lazyPattern.matcher(text);

		if (lazyMatcher.find()) {
			System.out.println("非贪婪匹配: " + lazyMatcher.group());
		}
	}

	@Test
	public void lookahead(){
		String text = "The quick brown fox jumps over the lazy dog.";

		// 预搜索示例：查找包含"fox"并且后面跟着"jumps"的文本
		Pattern lookaheadPattern = Pattern.compile("fox(?=jumps)");
		Matcher lookaheadMatcher = lookaheadPattern.matcher(text);

		while (lookaheadMatcher.find()) {
			System.out.println("预搜索匹配: " + lookaheadMatcher.group());
		}

		// 反向预搜索示例：查找包含"fox"但后面不跟着"jumps"的文本
		Pattern negativeLookaheadPattern = Pattern.compile("fox(?!jumps)");
		Matcher negativeLookaheadMatcher = negativeLookaheadPattern.matcher(text);

		while (negativeLookaheadMatcher.find()) {
			System.out.println("反向预搜索匹配: " + negativeLookaheadMatcher.group());
		}
	}

}
