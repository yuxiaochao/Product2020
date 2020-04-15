package com.huarui.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RDate {
	/**
	 * 
	 */
	public static final String datePattern = "yyyy-MM-dd";

	public static final String DateMinutesPattern = "yyyy-MM-dd HH:mm";

	public static final String DateTimePattern = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 日期转字符串
	 * 
	 * @param date
	 *            日期
	 * @param datePattern
	 *            转换格式
	 * @return
	 */
	public String dateFormat(Date date, String datePattern) {
		if (null == date) {
			return "";
		}
		SimpleDateFormat formatter = new SimpleDateFormat(datePattern);
		String dateString = formatter.format(date);
		return dateString;
	}

	/**
	 * 字符串转日期
	 * 
	 * @param dateString
	 *            日期字符串
	 * @param datePattern
	 *            转换格式
	 * @return
	 */
	public Date dateFormat(String dateString, String datePattern) {
		SimpleDateFormat formatter = new SimpleDateFormat(datePattern);
		Date date = null;
		if(ThreadUtils.getRTex().isAllNotEmpty(dateString,datePattern)){
			try {
				dateString.replaceAll("/", "-");
				date = formatter.parse(dateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		return date;
	}
	

	/**
	 * 自动日期格式化，不推荐使用
	 * 
	 * @return
	 */
	public Date autoDateFormat(String dateString) {
		Date date = dateFormat(dateString, DateTimePattern);
		if (null == date) {
			date = dateFormat(dateString, datePattern);
		}
		if (null == date) {
			date = dateFormat(dateString, DateMinutesPattern);
		}
		return date;
	}

	/**
	 * 日期转字符串 格式 ：YYYY-MM-dd
	 * 
	 * @param date
	 *            日期
	 * @return
	 */
	public String toDate(Date date) {
		return dateFormat(date, datePattern);
	}

	/**
	 * 字符串转日期 格式 ：YYYY-MM-dd
	 * 
	 * @param date
	 *            日期
	 * @return
	 */
	public Date toDate(String date) {
		return dateFormat(date, datePattern);
	}

	/**
	 * 日期转字符串 格式 ：YYYY-MM-dd HH:mm:ss
	 * 
	 * @param date
	 *            日期
	 * @return
	 */
	public String toDateTime(Date date) {
		return dateFormat(date, DateTimePattern);
	}

	/**
	 * 字符串转日期和时间 格式 ：YYYY-MM-dd HH:mm:ss
	 * 
	 * @param date
	 *            日期
	 * @return
	 */
	public Date toDateTime(String date) {
		return dateFormat(date, DateTimePattern);
	}
	
	/**
	 * 日期转字符串 格式 ：YYYY-MM-dd HH:mm:ss
	 * 
	 * @param date
	 *            日期
	 * @return
	 */
	public String toDateMinutes(Date date) {
		if (null == date) {
			return "";
		}
		return dateFormat(date, DateMinutesPattern);
	}

	/**
	 * 得到今天的日期 格式 YYYY-MM-dd
	 * 
	 * @return
	 */
	public String getNowDate() {
		return toDate(new Date());
	}

	/**
	 * 得到今天的日期和时间 格式 YYYY-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public String getNowDateTime() {
		return toDateTime(new Date());
	}
	
	/**
	 * 得到今天的日期和时间 格式 YYYY-MM-dd HH:mm
	 * 得到本月最后一天 格式 YYYY-MM-dd HH:mm
	 * @return
	 */
	public String getNowDateMinutes() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		String nowDate = String.valueOf(year) + "-" + StringUtils.right("0" + String.valueOf(month),2) + "-" + StringUtils.right("0" + String.valueOf(day),2) + " 23:59";
		return nowDate;
	}

	/**
	 * 计算两个时间的差
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public int diff(Date date1, Date date2) {
		int diff = 0;
		if (null != date1 && null != date2) {
			diff = timeToNumber(Math.abs(date1.getTime() - date2.getTime()), 2);
		}

		return diff;

	}

	/**
	 * 毫秒数转相应的数量
	 * 
	 * @param times
	 *            毫秒数
	 * @param type
	 *            相应的数量 0：秒数，1：分钟数，2：小时数，3：天数，def：秒数
	 * @return
	 */
	public int timeToNumber(Long times, int type) {
		int num = 0;
		if (null != times) {
			if (type == 0) {
				num = ThreadUtils.getRTex().toInteger(times / 1000);
			} else if (type == 1) {
				num = ThreadUtils.getRTex().toInteger(times / 60000);
			} else if (type == 2) {
				num = ThreadUtils.getRTex().toInteger(times / 3600000);
			} else if (type == 3) {
				num = ThreadUtils.getRTex().toInteger(times / 86400000);
			} else {
				num = 0;
			}

		}
		return num;
	}

	/**
	 * 得到当前分钟数
	 * 
	 * @return
	 */
	public int getMinute() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.MINUTE);
	}

	/**
	 * 得到当前24小时的小时数
	 * 
	 * @return
	 */
	public int getHour24() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 得到今天几号
	 * 
	 * @return
	 */
	public int getDay() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 得到当前星期几 格式化为 1-7 周一到周日
	 * 
	 * @return
	 */
	public int getWeek() {
		Calendar calendar = Calendar.getInstance();
		int week = calendar.get(Calendar.DAY_OF_WEEK);
		week--;
		if (week == 0) {
			week = 7;
		}
		return week;
	}

	/**
	 * 得到当前星期的可视输出
	 * 
	 * @return
	 */
	public String getWeekVisable() {
		int week = getWeek();
		String weekVisable = null;
		switch (week) {

		case 1:
			weekVisable = "星期一";
			break;
		case 2:
			weekVisable = "星期二";
			break;
		case 3:
			weekVisable = "星期三";
			break;
		case 4:
			weekVisable = "星期四";
			break;
		case 5:
			weekVisable = "星期五";
			break;
		case 6:
			weekVisable = "星期六";
			break;
		case 7:
			weekVisable = "星期日";
			break;
		}
		return weekVisable;
	}

	/**
	 * 获取日期字符戳
	 * 
	 * @return
	 */
	public String getStampCharacters() {
		return dateFormat(new Date(), "yyyyMMddHHmmssSSS");
	}

	/**
	 * java 日期格式化转mysql日期格式化
	 * 
	 * @param pattern
	 * @return
	 */
	public String javaDatePatternToMysqlPattern(String pattern) {
		String mySqlPattern = pattern;
		if (ThreadUtils.getRTex().isNotEmpty(pattern)) {
			mySqlPattern = pattern.replace("yyyy", "%Y").replace("MM", "%m").replace("dd", "%d").replace("HH", "%H")
					.replace("mm", "%i").replace("ss", "%s");
		}
		return mySqlPattern;
	}

	/**
	 * 获取当年年份
	 * @return
	 */
	public int getYear() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.YEAR);
	}
	
	
	/**
	 * 获取cntDateBeg开始时间cntDateEnd结束时间之间的年月日
     * @param cntDateBeg 开始时间，格式yyyy-MM-dd
     * @param cntDateEnd 结束时间，格式yyyy-MM-dd
     * @return
     */
    public List<String> getIntervalDays(String cntDateBeg, String cntDateEnd) {
        List<String> list = new ArrayList<>();
        //拆分成数组
        String[] dateBegs = cntDateBeg.split("-");
        String[] dateEnds = cntDateEnd.split("-");
        //开始时间转换成时间戳
        Calendar start = Calendar.getInstance();
        start.set(Integer.valueOf(dateBegs[0]), Integer.valueOf(dateBegs[1]) - 1, Integer.valueOf(dateBegs[2]));
        Long startTIme = start.getTimeInMillis();
        //结束时间转换成时间戳
        Calendar end = Calendar.getInstance();
        end.set(Integer.valueOf(dateEnds[0]), Integer.valueOf(dateEnds[1]) - 1, Integer.valueOf(dateEnds[2]));
        Long endTime = end.getTimeInMillis();
        //定义一个一天的时间戳时长
        Long oneDay = 1000 * 60 * 60 * 24l;
        Long time = startTIme;
        //循环得出
        while (time <= endTime) {
            list.add(new SimpleDateFormat("yyyy-MM-dd").format(new Date(time)));
            time += oneDay;
        }
        return list;
    }

}
