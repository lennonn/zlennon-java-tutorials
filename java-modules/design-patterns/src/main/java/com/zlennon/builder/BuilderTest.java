package com.zlennon.builder;

public class BuilderTest {

	public static void main(String[] args) {
        Person person = new Person.Builder(1, "张三").age(18).sex("男").desc("测试使用builder模式").build();
        System.out.println(person.toString());
	}

}
