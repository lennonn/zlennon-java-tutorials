package com.zlennon.test;

public class Something {
	final int i=1;
	int j;
	String str =new String("good");
	char[] ch ={'a','b','c'};
	 public Something() {
	        //System.out.println(++j + i);
	    }
	public static void main(String[] args) {

		/*
		 * test length();
		 * String s1 = null; int i= s1.length(); System.out.println(i);
		 */
		//Something something = new Something();
		test();
		Something something = new Something();
		//something.change(something.str,something.ch);



	}
	public void foregate(String s){

	}
	public int  foregate(int tring){
		return 1;
	}
	//public void foregate(int stringBuffer,String s){};
	//private void foregate(String s){};
	public static void test(){
		int i=5;
		int j,k;
		k=j=i--!=5?1:0;
		System.out.println(k);
	}
}
