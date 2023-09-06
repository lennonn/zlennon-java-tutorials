package com.zlennon.examples;

public class Singleton {
	private static Singleton singleton;
	private Singleton(){

	}
	public  static Singleton getInstance(){
		if(singleton ==null)
			 singleton = new Singleton();
		return singleton;
	}
	/*private static final Singleton singleton = new Singleton();
	public static Singleton getSingleton(){
		return singleton;
	}*/
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		if(s1==s2){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
		//System.out.println(sin.getClass().getName());
	}

}
