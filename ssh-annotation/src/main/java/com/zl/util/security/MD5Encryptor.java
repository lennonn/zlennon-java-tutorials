package com.zl.util.security;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.logging.log4j.LogManager;

public class MD5Encryptor implements Encryptor {

	private final static char[] HEX_CHARS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
			'E', 'F' };

	@Override
	public String encrypt(String inputStr) {
		String result = null;
		if (inputStr != null) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] bytes = md.digest(inputStr.getBytes());
				result = bytes2HexString(bytes);
			} catch (NoSuchAlgorithmException e) {
				LogManager.getLogger(getClass()).error("encrypt error !", e);
			}
		}

		return result;
	}

	/**
	 * 转换字节数组为十六进制字符串
	 *
	 * @param 字节数组
	 * @return 十六进制字符串
	 */
	private static String bytes2HexString(byte[] b) {
		StringBuilder hexBuilder = new StringBuilder();
		for (int i = 0; i < b.length; i++) {
			hexBuilder.append(byteToHexChars(b[i]));
		}
		return hexBuilder.toString();
	}

	/** 将一个字节转化成十六进制形式的字符数组 */
	private static char[] byteToHexChars(byte b) {
		int n = byte2Int(b);
		int d1 = n >> 4;
		int d2 = n % 16;
		char[] result = new char[2];
		result[0] = HEX_CHARS[d1];
		result[1] = HEX_CHARS[d2];
		return result;
	}

	private static int byte2Int(byte b) {
		return b & 0xff;
	}
}
