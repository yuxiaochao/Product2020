
package com.huarui.common.utils;


public class Common {
	
	public static String authCode(String string, String operation, String key, int expiry) {
		long currentTime = System.currentTimeMillis();
		int time = (int) (currentTime / 1000);
		try {
			int ckey_length = 4;
			key = md5(key );
			String keya = md5(key.substring(0, 16));
			String keyb = md5(key.substring(16, 32));
			String keyc = ckey_length > 0 ? ("DECODE".equals(operation) ? string.substring(0, ckey_length)
					: md5(String.valueOf(currentTime)).substring(32 - ckey_length)) : "";
			String cryptkey = keya + md5(keya + keyc);
			int key_length = cryptkey.length();
			string = "DECODE".equals(operation) ? Base64.decode(string.substring(ckey_length),
					"UTF-8") : (expiry > 0 ? expiry + time : "0000000000")
					+ md5(string + keyb).substring(0, 16) + string;
			int string_length = string.length();
			StringBuffer result = new StringBuffer(string_length);
			int range = 128;
			int[] rndkey = new int[range];
			for (int i = 0; i < range; i++) {
				rndkey[i] = cryptkey.charAt(i % key_length);
			}
			int tmp;
			int[] box = new int[range];
			for (int i = 0; i < range; i++) {
				box[i] = i;
			}
			for (int i = 0, j = 0; i < range; i++) {
				j = (j + box[i] + rndkey[i]) % range;
				tmp = box[i];
				box[i] = box[j];
				box[j] = tmp;
			}
			for (int a = 0, i = 0, j = 0; i < string_length; i++) {
				a = (a + 1) % range;
				j = (j + box[a]) % range;
				tmp = box[a];
				box[a] = box[j];
				box[j] = tmp;
				result.append((char) ((int) string.charAt(i) ^ (box[(box[a] + box[j]) % range])));
			}
			if ("DECODE".equals(operation)) {
				int resulttime = Common.intval(result.substring(0, 10));
				if ((resulttime == 0 || resulttime - time > 0)
						&& result.substring(10, 26).equals(md5(result.substring(26) + keyb).substring(0, 16))) {
					return result.substring(26);
				} else {
					return "";
				}
			} else {
				return keyc
						+ (Base64.encode(result.toString(), "UTF-8")).replaceAll("=", "");
			}
		} catch (Exception e) {
			return "";
		}
	}
	
	public static String md5(String arg0) {
		return Md5Util.encode(arg0);
	}
	
	public static int intval(String s) {
		return intval(s, 10);
	}
	
	public static int intval(String s, int radix) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		if (radix == 0) {
			radix = 10;
		} else if (radix < Character.MIN_RADIX) {
			return 0;
		} else if (radix > Character.MAX_RADIX) {
			return 0;
		}
		int result = 0;
		int i = 0, max = s.length();
		int limit;
		int multmin;
		int digit;
		boolean negative = false;
		if (s.charAt(0) == '-') {
			negative = true;
			limit = Integer.MIN_VALUE;
			i++;
		} else {
			limit = -Integer.MAX_VALUE;
		}
		if (i < max) {
			digit = Character.digit(s.charAt(i++), radix);
			if (digit < 0) {
				return 0;
			} else {
				result = -digit;
			}
		}
		multmin = limit / radix;
		while (i < max) {
			digit = Character.digit(s.charAt(i++), radix);
			if (digit < 0) {
				break;
			}
			if (result < multmin) {
				result = limit;
				break;
			}
			result *= radix;
			if (result < limit + digit) {
				result = limit;
				break;
			}
			result -= digit;
		}
		if (negative) {
			if (i > 1) {
				return result;
			} else {
				return 0;
			}
		} else {
			return -result;
		}
	}
	
}