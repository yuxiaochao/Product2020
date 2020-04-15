package com.huarui.common.utils;

import org.apache.commons.lang3.math.NumberUtils;

import java.text.ParseException;
import java.util.Date;


public class ExamUtil {	
	
	/**
	 * 优选题算分
	 * @param userAnswer
	 * @param topicK
	 * @return
	 */
	public float getScore(String userAnswer, String topicK) {
		float returnValue = 0;
		String optionChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		if(topicK!=null) {
			String[] topickArray = topicK.split("$$");
			if(topickArray.length>0) {
				if(StringUtils.isNotEmpty(userAnswer) && StringUtils.isNotBlank(userAnswer)) {
					int answerIndex = optionChar.indexOf(userAnswer);
					if(answerIndex>=0 && topickArray.length>answerIndex) {
						returnValue = NumberUtils.toFloat(topickArray[answerIndex]);
					}
				}
			}
		}
		return returnValue;
	}
	
	/**
	 * 不定项题算分：全部正确结果为1，部分正确结果为0.5，不正确为0
	 * @param topicKey
	 * @param topicAnswer
	 * @return
	 */
   public float getScoreRate(String userAnswer, String topicAnswer) {
	   float returnValue = 0;
       if(userAnswer == null |userAnswer.equals("")){
       	return returnValue;
       }else if(userAnswer.equals(topicAnswer)) {
           returnValue = 1f;
       } else {
           boolean hitFlag = true;
           for (int i = 0; i < userAnswer.length(); i++) {
               if(topicAnswer.indexOf(userAnswer.charAt(i))==-1) {
                   hitFlag = false;
                   break;
               }
           }
           if(hitFlag) returnValue = 0.5f;
       }
       return returnValue;
    }
   
   /**
    * 统一交卷时获取交卷时间与当前时间的差，单位为秒
    * @param time
    * @return
    * @throws Exception
    */
	public int DateDiff(String time)  {
		int returnValue = -1;
		try {
			String dateString = "";

			Date nowDate = new Date();
			java.text.DateFormat dateDF = new java.text.SimpleDateFormat("yyyy-MM-dd");
			dateString = dateDF.format(nowDate);

			java.text.DateFormat datetimeDF = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date toDate = datetimeDF.parse(dateString + " " + time);

			long num = (toDate.getTime() - nowDate.getTime()) / 1000;
			returnValue = (int) num;
		} catch (ParseException e) {
		}
		
		return returnValue;
	}
	
   /**
    * 统一交卷时获取答题时长，单位为秒
    * @param time
    * @return
    * @throws Exception
    */
	public int TimeDiff(String startTime, String endTime)  {
		int returnValue = -1;
		try {
			String dateString = "";

			Date nowDate = new Date();
			java.text.DateFormat dateDF = new java.text.SimpleDateFormat("yyyy-MM-dd");
			dateString = dateDF.format(nowDate);

			java.text.DateFormat datetimeDF = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date startDate = datetimeDF.parse(dateString + " " + startTime);
			Date endDate = datetimeDF.parse(dateString + " " + endTime);

			long num = (endDate.getTime() - startDate.getTime()) / 1000;
			returnValue = (int) num;
		} catch (ParseException e) {
		}
		
		return returnValue;
	}
	
//	public void replacePlus(TopicEntity topic) {
//		if(topic!=null) {
//			topic.setTopi006(topic.getTopi006().replaceAll("\\$\\{plus\\}", "+"));
//		}
//	}

}
