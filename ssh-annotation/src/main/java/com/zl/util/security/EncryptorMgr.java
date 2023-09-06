package com.zl.util.security;

public class EncryptorMgr {

	private static Encryptor encryptor = new MD5Encryptor();

	private EncryptorMgr() {

	}

	public static String encrypt(String input) {
		return encrypt(EncryptorMgr.encryptor, input);
	}

	public static String encrypt(Encryptor encryptor, String input) {
		return encryptor.encrypt(input);
	}

	public static void switchEncryptor(Encryptor encryptor) {
		EncryptorMgr.encryptor = encryptor;
	}

}
