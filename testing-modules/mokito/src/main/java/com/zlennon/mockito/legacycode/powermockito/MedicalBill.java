package com.zlennon.mockito.legacycode.powermockito;

import java.util.Random;

public class MedicalBill {

	public static int generateId(){
		return new Random().nextInt();
	}
}
