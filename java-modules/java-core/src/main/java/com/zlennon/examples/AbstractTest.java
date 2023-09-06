package com.zlennon.examples;

public abstract class AbstractTest {
	public int num;
	public AbstractTest() {
		System.out.println("hello");
	}
	public void hello() {
		System.out.println("hello");
	}
	//public abstract String helloWorld();
	public static void main(String[] args) {
		//AbstractTest abstractTest = new AbstractTest() 抽象类不能被实例化，有抽象方法，实例化无意义,不能实例为具体的哪一个
	AbstractTest abstractTest = new AbstractTest() {
			public void hello(){
				System.out.println("test");
			};
		};
	}

}
