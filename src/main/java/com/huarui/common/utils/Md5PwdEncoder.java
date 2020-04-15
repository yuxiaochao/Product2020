package com.huarui.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5PwdEncoder {

	private static final char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
			'f' };
	private static String defaultSalt = "";

	public static String encode(String rawPass, String salt) {
		String saltedPass = mergePasswordAndSalt(rawPass, salt, false);
		if (saltedPass == null) {
			saltedPass = "";
		}
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.update(saltedPass.getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toHex(md5.digest());
	}

	public static String encode(String rawPass) {
		return encode(rawPass, Md5PwdEncoder.defaultSalt);
	}

	static String mergePasswordAndSalt(String password, Object salt, boolean strict) {
		if (password == null) {
			password = "";
		}
		if (strict)
			;

		if (salt == null || "".equals(salt)) {
			return password;
		}
		return String.valueOf(password) + salt.toString();
	}

	private static String toHex(byte[] bytes) {
		StringBuffer str = new StringBuffer(32);
		byte b1;
		int i;
		for (i = bytes.length, b1 = 0; b1 < i;) {
			byte b = bytes[b1];
			str.append(hexDigits[(b & 0xF0) >> 4]);
			str.append(hexDigits[b & 0xF]);
			b1++;
		}

		return str.toString();
	}
	
	
	protected static final MessageDigest getMessageDigest() {
		String algorithm = "MD5";
		try {
			return MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException("No such algorithm ["
					+ algorithm + "]");
		}
	}
}
