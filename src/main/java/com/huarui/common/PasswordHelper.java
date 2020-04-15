package com.huarui.common;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.Validate;

import javax.xml.bind.DatatypeConverter;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;

public class PasswordHelper {
	private static final String MD5 = "MD5";
	public static final int SALT_SIZE = 22;
	private static SecureRandom random = new SecureRandom();
	private PasswordHelper() {
		
	}

	/**
	 * 生成盐
	 * @return
	 */
	public static String generateSalt(){
		byte[] salt = generateSalt(SALT_SIZE);
		return encodeHex(salt);
	}

	/**
	 * 通过随机生成的22位salt并经过1次 md5 hash生成安全的密码，
	 * @param plainPassword 明文密码
	 * @param salt 盐
	 * @return
	 */
	public static String entryptPassword(String plainPassword, String salt) {
		byte[] hashPassword = md5(String.valueOf(plainPassword).concat(
				String.valueOf(salt)).getBytes());
		return DatatypeConverter.printBase64Binary(hashPassword);
	}


	/**
	 * 验证密码
	 * @param plainPassword 明文密码
	 * @param salt 盐
	 * @param password 密文密码
	 * @return 验证成功返回true
	 */
	public static boolean validatePassword(String plainPassword, String salt, String password) {
		return password.equals(entryptPassword(plainPassword,salt));
	}

	/**
	 * 生成随机的Byte[]作为salt.
	 *
	 * @param numBytes byte数组的大小
	 */
	public static byte[] generateSalt(int numBytes) {
		Validate.isTrue(numBytes > 0, "numBytes argument must be a positive integer (1 or larger)", numBytes);

		byte[] bytes = new byte[numBytes];
		random.nextBytes(bytes);
		return bytes;
	}

	/**
	 * 对输入字符串进行md5散列.
	 */
	public static byte[] md5(byte[] input) {
		return digest(input, MD5, null, 1);
	}
	/**
	 * Hex编码.
	 */
	public static String encodeHex(byte[] input) {
		return new String(Hex.encodeHex(input));
	}

	/**
	 * 对字符串进行散列, 支持md5与sha1算法.
	 */
	private static byte[] digest(byte[] input, String algorithm, byte[] salt, int iterations) {
		try {
			MessageDigest digest = MessageDigest.getInstance(algorithm);

			if (salt != null) {
				digest.update(salt);
			}

			byte[] result = digest.digest(input);

			for (int i = 1; i < iterations; i++) {
				digest.reset();
				result = digest.digest(result);
			}
			return result;
		} catch (GeneralSecurityException e) {
			throw unchecked(e);
		}
	}

	/**
	 * 将CheckedException转换为UncheckedException.
	 */
	public static RuntimeException unchecked(Exception e) {
		if (e instanceof RuntimeException) {
			return (RuntimeException) e;
		} else {
			return new RuntimeException(e);
		}
	}
}
