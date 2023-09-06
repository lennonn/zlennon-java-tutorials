package com.zlennon.examples;

public class IndexOfAndSpirt {

	public IndexOfAndSpirt() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
			String string ="images/download/3.txt";
			String temp[] = string.split("/");
			for(int i=0;i<temp.length;i++){
				System.out.println(temp[i]);
			}

	}

}
