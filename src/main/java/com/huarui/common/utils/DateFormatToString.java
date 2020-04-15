package com.huarui.common.utils;

import java.util.regex.Pattern;

public class DateFormatToString {
//	public static void main(String[] args) throws ParseException {
//		System.out.println(getDateFormat("01-12"));
//		System.out.println(getDateFormat("2018-01"));
//		System.out.println(getDateFormat("2018-01-12"));
//		System.out.println(getDateFormat("11:22"));
//		System.out.println(getDateFormat("2018-01-12 11:22:33"));
//		System.out.println(getDateFormat("2018-01-12 11:22:33:333"));
//		System.out.println(getDateFormat("11时22分33秒333毫秒"));
//		System.out.println(getDateFormat("2018/01/12 11时22分33秒333毫秒"));
//		System.out.println(getDateFormat("当前2018年01月12日日 11时22分33秒333分"));
//
//	}

	/**
	 * 常规自动日期格式识别
	 * 
	 * @param str
	 *            时间字符串
	 * @return DatedownLoadTemplate
	 * @author dc
	 */
	public static String getDateFormat(String str) {
		boolean year = false;
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		if (pattern.matcher(str.substring(0, 4)).matches()) {
			year = true;
		}
		StringBuilder sb = new StringBuilder();
		int index = 0;
		if (!year) {
			if (str.contains("月") || str.contains("-") || str.contains("/")) {
				if (Character.isDigit(str.charAt(0))) {
					index = 1;
				}
			} else {
				index = 3;
			}
		}
		for (int i = 0; i < str.length(); i++) {
			char chr = str.charAt(i);
			if (Character.isDigit(chr)) {
				if (index == 0) {
					sb.append("y");
				}
				if (index == 1) {
					sb.append("M");
				}
				if (index == 2) {
					sb.append("d");
				}
				if (index == 3) {
					sb.append("H");
				}
				if (index == 4) {
					sb.append("m");
				}
				if (index == 5) {
					sb.append("s");
				}
				if (index == 6) {
					sb.append("S");
				}
			} else {
				if (i > 0) {
					char lastChar = str.charAt(i - 1);
					if (Character.isDigit(lastChar)) {
						index++;
					}
				}
				sb.append(chr);
			}
		}
		return sb.toString();
	}

}
