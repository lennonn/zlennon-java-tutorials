package com.zl.common.aop;

public class AOPClass {
	public void before(){
		System.out.println("方法执行之前，使用aop实现，-----------------------------------start");
	}
	public void after(){
		System.out.println("方法执行之后，使用aop实现，-----------------------------------end");
	}
}
