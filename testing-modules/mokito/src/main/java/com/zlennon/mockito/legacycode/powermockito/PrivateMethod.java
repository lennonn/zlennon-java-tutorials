package com.zlennon.mockito.legacycode.powermockito;

public class PrivateMethod {

	private String secretValue(){
		return "#$$%^&*";
	}
	
	public String exposeTheSecretValue(){
		return secretValue();
	}
}
