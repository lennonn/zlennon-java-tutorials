package com.zlennon.mockito.legacycode.powermockito;

public class SuppressMethod {

	public String format(String str){
		return str + getCurrency();
	}
	
	private String getCurrency(){
		return "$";
	}
}
