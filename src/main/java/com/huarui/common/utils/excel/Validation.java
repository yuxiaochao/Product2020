package com.huarui.common.utils.excel;

import com.huarui.common.utils.ThreadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 普通数据校验类
 * 
 * @author baiyu
 *
 */
public class Validation {
	private static Logger logger = LoggerFactory.getLogger(Validation.class);
	/**
	 * 验证数字的正则表达式
	 */
	public static final String REGULAR_NUMBER = "[0-9]*";
	/**
	 * 验证电子邮件的正则表达式
	 */
	public static final String REGULAR_EMAIL = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";

	/**
	 * 验证电话号码的正则表达式
	 */
	public static final String REGULAR_MOBILE = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

	/**
	 * 验证URL的正则表达式
	 */
	public static final String REGULAR_URL = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
	/**
	 * 校验日期的正则表达式
	 */
	public static final String REGULAR_DATE = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))?$";

	/**
	 * 校验IP的正则表达式
	 */
	public static final String REGULAR_IP = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
			+ "(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";

	/**
	 * 非空验证
	 */
	public boolean verifyNull(Object obj) {
		boolean flag = false;
		if (null == obj) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 非空验证
	 */
	public boolean verifyNotNull(Object obj) {
		return !verifyNull(obj);
	}

	/**
	 * 非空验证
	 */
	public boolean verifyNotEmpty(Object obj) {
		if (ThreadUtils.getRTex().isEmpty(obj)) {
			return false;
		}
		return true;
	}

	/**
	 * 数据师傅为序列之一的验证
	 * 
	 * @param value
	 * @return
	 */
	public boolean verifySequence(Object value, String[] sequences) {
		String verifyStr = ThreadUtils.getRTex().toString(value);
		for (String seq : sequences) {
			if (seq.equals(verifyStr)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 是否为数字验证
	 */
	public boolean verifyNumber(Object obj) {
		boolean falg = false;
		String verifyStr = ThreadUtils.getRTex().toString(obj);
		if (!ThreadUtils.getRTex().isEmpty(verifyStr)) {
			falg = regularMatcher(REGULAR_NUMBER, verifyStr);
		}
		return falg;
	}

	/**
	 * 是否为email的验证
	 */
	public boolean verifyEmail(Object obj) {
		boolean falg = false;
		String verifyStr = ThreadUtils.getRTex().toString(obj);
		if (!ThreadUtils.getRTex().isEmpty(verifyStr)) {
			falg = regularMatcher(REGULAR_EMAIL, verifyStr);
		}
		return falg;
	}

	/**
	 * 是否为电话号码的验证
	 */
	public boolean verifyMobile(Object obj) {
		boolean falg = false;
		String verifyStr = ThreadUtils.getRTex().toString(obj);
		if (!ThreadUtils.getRTex().isEmpty(verifyStr)) {
			falg = regularMatcher(REGULAR_MOBILE, verifyStr);
		}
		return falg;
	}

	/**
	 * 是否为电话号码的验证
	 */
	public boolean verifyUrl(Object obj) {
		boolean falg = false;
		String verifyStr = ThreadUtils.getRTex().toString(obj);
		if (!ThreadUtils.getRTex().isEmpty(verifyStr)) {
			falg = regularMatcher(REGULAR_URL, verifyStr);
		}
		return falg;
	}

	/**
	 * 是否为电话号码的验证
	 */
	public boolean verifyDate(Object obj, String datePattern) {
		boolean falg = false;
		String verifyStr = ThreadUtils.getRTex().toString(obj);
		if (ThreadUtils.getRTex().isNotEmpty(verifyStr)) {
			Date date = ThreadUtils.getRDate().dateFormat(verifyStr, datePattern);
			if (null != date) {
				falg = true;
			}
		}
		return falg;
	}

	/**
	 * 是否为有效身份证号码的验证
	 * 
	 * @throws ParseException
	 */
	public boolean verifyCardID(Object obj) throws ParseException {
		boolean falg = false;
		String verifyStr = ThreadUtils.getRTex().toString(obj);
		if (!ThreadUtils.getRTex().isEmpty(verifyStr)) {
			CardID cardId = new CardID();
			falg = cardId.cardIDValidate(verifyStr);
			cardId = null;
		}
		return falg;
	}

	/**
	 * 最大长度验证
	 * 
	 * @throws ParseException
	 */
	public boolean verifyMaxLength(Object obj, int length) throws ParseException {
		boolean falg = false;
		String verifyStr = ThreadUtils.getRTex().toString(obj);
		if (!ThreadUtils.getRTex().isEmpty(verifyStr)) {
			falg = verifyStr.length() <= length;
		}
		return falg;
	}

	/**
	 * 最小长度验证
	 * 
	 * @throws ParseException
	 */
	public boolean verifyMin(Object obj, String min) throws ParseException {
		boolean falg = false;
		int verifyInteger = ThreadUtils.getRTex().toInteger(obj);
		int minInteger = ThreadUtils.getRTex().toInteger(min);
		if (verifyInteger >= minInteger) {
			falg = true;
		}
		return falg;
	}

	/**
	 * 最大长度验证
	 * 
	 * @throws ParseException
	 */
	public boolean verifyMax(Object obj, String max) throws ParseException {
		boolean falg = false;
		int verifyInteger = ThreadUtils.getRTex().toInteger(obj);
		int maxInteger = ThreadUtils.getRTex().toInteger(max);
		if (maxInteger >= verifyInteger) {
			falg = true;
		}
		return falg;
	}

	/**
	 * 最小长度验证
	 * 
	 * @throws ParseException
	 */
	public boolean verifyMinLength(Object obj, int length) throws ParseException {
		boolean falg = false;
		String verifyStr = ThreadUtils.getRTex().toString(obj);
		if (!ThreadUtils.getRTex().isEmpty(verifyStr)) {
			falg = verifyStr.length() >= length;
		}
		return falg;
	}

	/**
	 * 是否为有效IP地址的验证
	 * 
	 * @throws ParseException
	 */
	public boolean verifyIP(Object obj) throws ParseException {
		boolean falg = false;
		String verifyStr = ThreadUtils.getRTex().toString(obj);
		if (!ThreadUtils.getRTex().isEmpty(verifyStr)) {
			falg = regularMatcher(REGULAR_IP, verifyStr);
		}
		return falg;
	}

	/**
	 * 正则表达式匹配
	 */
	public boolean regularMatcher(String regexp, String verifyStr) {
		Pattern pattern = Pattern.compile(regexp);
		Matcher matcher = pattern.matcher(verifyStr);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * 正则表达式是否有效验证
	 * 
	 * @throws ParseException
	 */
	public boolean verifyPattern(Object obj, String pattern) throws ParseException {
		boolean falg = false;
		String verifyStr = ThreadUtils.getRTex().toString(obj);
		if (ThreadUtils.getRTex().isAllNotEmpty(verifyStr, pattern)) {
			falg = regularMatcher(pattern, verifyStr);
		}
		return falg;
	}

	/**
	 * 身份证号码的格式：610821-20061222-612-X 由18位数字组成：前6位为地址码，第7至14位为出生日期码，第15至17位为顺序码，
	 * 第18位为校验码。检验码分别是0-10共11个数字，当检验码为“10”时，为了保证公民身份证号码18位，所以用“X”表示。虽然校验码为“X”不能更换，但若需全用数字表示，只需将18位公民身份号码转换成15位居民身份证号码，去掉第7至8位和最后1位3个数码。
	 * 当今的身份证号码有15位和18位之分。1985年我国实行居民身份证制度，当时签发的身份证号码是15位的，1999年签发的身份证由于年份的扩展（由两位变为四位）和末尾加了效验码，就成了18位。
	 * （1）前1、2位数字表示：所在省份的代码； （2）第3、4位数字表示：所在城市的代码； （3）第5、6位数字表示：所在区县的代码；
	 * （4）第7~14位数字表示：出生年、月、日； （5）第15、16位数字表示：所在地的派出所的代码；
	 * （6）第17位数字表示性别：奇数表示男性，偶数表示女性 （7）第18位数字是校检码：根据一定算法生成
	 * 
	 * @author tong
	 * 
	 */

	class CardID {

		public boolean cardIDValidate(String IDStr) throws ParseException {
			String tipInfo = "该身份证有效！";// 记录错误信息
			String Ai = "";
			// 判断号码的长度 15位或18位
			if (IDStr.length() != 15 && IDStr.length() != 18) {
				tipInfo = "身份证号码长度应该为15位或18位。";
				logger.info(IDStr + ":" + tipInfo);
				return false;
			}

			// 18位身份证前17位位数字，如果是15位的身份证则所有号码都为数字
			if (IDStr.length() == 18) {
				Ai = IDStr.substring(0, 17);
			} else if (IDStr.length() == 15) {
				Ai = IDStr.substring(0, 6) + "19" + IDStr.substring(6, 15);
			}
			if (isNumeric(Ai) == false) {
				tipInfo = "身份证15位号码都应为数字 ; 18位号码除最后一位外，都应为数字。";
				logger.info(IDStr + ":" + tipInfo);
				return false;
			}

			// 判断出生年月是否有效
			String strYear = Ai.substring(6, 10);// 年份
			String strMonth = Ai.substring(10, 12);// 月份
			String strDay = Ai.substring(12, 14);// 日期
			if (isDate(strYear + "-" + strMonth + "-" + strDay) == false) {
				tipInfo = "身份证出生日期无效。";
				logger.info(IDStr + ":" + tipInfo);
				return false;
			}
			GregorianCalendar gc = new GregorianCalendar();
			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
			try {
				if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150
						|| (gc.getTime().getTime() - s.parse(strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
					tipInfo = "身份证生日不在有效范围。";
					logger.info(IDStr + ":" + tipInfo);
					return false;
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {
				tipInfo = "身份证月份无效";
				logger.info(IDStr + ":" + tipInfo);
				return false;
			}
			if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {
				tipInfo = "身份证日期无效";
				logger.info(IDStr + ":" + tipInfo);
				return false;
			}

			// 判断地区码是否有效
			Hashtable areacode = GetAreaCode();
			// 如果身份证前两位的地区码不在Hashtable，则地区码有误
			if (areacode.get(Ai.substring(0, 2)) == null) {
				tipInfo = "身份证地区编码错误。";
				logger.info(IDStr + ":" + tipInfo);
				return false;
			}

			if (isVarifyCode(Ai, IDStr) == false) {
				tipInfo = "身份证校验码无效，不是合法的身份证号码";
				logger.info(IDStr + ":" + tipInfo);
				return false;
			}

			return true;
		}

		/*
		 * 判断第18位校验码是否正确 第18位校验码的计算方式： 1. 对前17位数字本体码加权求和 公式为：S = Sum(Ai * Wi), i
		 * = 0, ... , 16 其中Ai表示第i个位置上的身份证号码数字值，Wi表示第i位置上的加权因子，其各位对应的值依次为： 7 9 10
		 * 5 8 4 2 1 6 3 7 9 10 5 8 4 2 2. 用11对计算结果取模 Y = mod(S, 11) 3.
		 * 根据模的值得到对应的校验码 对应关系为： Y值： 0 1 2 3 4 5 6 7 8 9 10 校验码： 1 0 X 9 8 7 6 5
		 * 4 3 2
		 */
		private boolean isVarifyCode(String Ai, String IDStr) {
			String[] VarifyCode = { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };
			String[] Wi = { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7", "9", "10", "5", "8", "4", "2" };
			int sum = 0;
			for (int i = 0; i < 17; i++) {
				sum = sum + Integer.parseInt(String.valueOf(Ai.charAt(i))) * Integer.parseInt(Wi[i]);
			}
			int modValue = sum % 11;
			String strVerifyCode = VarifyCode[modValue];
			Ai = Ai + strVerifyCode;
			if (IDStr.length() == 18) {
				if (Ai.equals(IDStr) == false) {
					return false;

				}
			}
			return true;
		}

		/**
		 * 将所有地址编码保存在一个Hashtable中
		 * 
		 * @return Hashtable 对象
		 */

		private Hashtable GetAreaCode() {
			Hashtable hashtable = new Hashtable();
			hashtable.put("11", "北京");
			hashtable.put("12", "天津");
			hashtable.put("13", "河北");
			hashtable.put("14", "山西");
			hashtable.put("15", "内蒙古");
			hashtable.put("21", "辽宁");
			hashtable.put("22", "吉林");
			hashtable.put("23", "黑龙江");
			hashtable.put("31", "上海");
			hashtable.put("32", "江苏");
			hashtable.put("33", "浙江");
			hashtable.put("34", "安徽");
			hashtable.put("35", "福建");
			hashtable.put("36", "江西");
			hashtable.put("37", "山东");
			hashtable.put("41", "河南");
			hashtable.put("42", "湖北");
			hashtable.put("43", "湖南");
			hashtable.put("44", "广东");
			hashtable.put("45", "广西");
			hashtable.put("46", "海南");
			hashtable.put("50", "重庆");
			hashtable.put("51", "四川");
			hashtable.put("52", "贵州");
			hashtable.put("53", "云南");
			hashtable.put("54", "西藏");
			hashtable.put("61", "陕西");
			hashtable.put("62", "甘肃");
			hashtable.put("63", "青海");
			hashtable.put("64", "宁夏");
			hashtable.put("65", "新疆");
			hashtable.put("71", "台湾");
			hashtable.put("81", "香港");
			hashtable.put("82", "澳门");
			hashtable.put("91", "国外");
			return hashtable;
		}

		/**
		 * 判断字符串是否为数字,0-9重复0次或者多次
		 * 
		 * @param strnum
		 * @return
		 */
		private boolean isNumeric(String strnum) {
			Pattern pattern = Pattern.compile(REGULAR_NUMBER);
			Matcher isNum = pattern.matcher(strnum);
			if (isNum.matches()) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * 功能：判断字符串出生日期是否符合正则表达式：包括年月日，闰年、平年和每月31天、30天和闰月的28天或者29天
		 * 
		 * @return
		 */
		public boolean isDate(String strDate) {

			Pattern pattern = Pattern.compile(REGULAR_DATE);
			Matcher m = pattern.matcher(strDate);
			if (m.matches()) {
				return true;
			} else {
				return false;
			}
		}

	}

}
