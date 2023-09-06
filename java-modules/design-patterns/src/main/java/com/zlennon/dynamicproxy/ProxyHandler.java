package com.zlennon.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler{

	Object concreteTarget;
	public  ProxyHandler(Object obj) {
		this.concreteTarget=obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
			System.out.println("proxy:"+proxy.getClass().getName());
	        System.out.println("method:"+method.getName());
	        //System.out.println("args:"+args[0].getClass().getName());
	        System.out.println("Before invoke method...");
	        Object object=method.invoke(concreteTarget, args);//普通的Java反射代码,通过反射执行某个类的某方法
	        System.out.println("After invoke method...");
	        return object;
	}

}
