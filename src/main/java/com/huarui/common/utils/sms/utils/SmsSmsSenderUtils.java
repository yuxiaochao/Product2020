package com.huarui.common.utils.sms.utils;

import com.huarui.common.utils.RedisUtil;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.common.utils.sms.SendSmsResult;
import com.huarui.common.utils.sms.SendSmsSender;
import com.huarui.common.utils.sms.httpclient.HttpException;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class SmsSmsSenderUtils {

	
	
/*
 * 测试方法
 */
	public static void main(String[] args) {
		SendSmsSender sender = new SendSmsSender("dlzgyykj", "B9Ldi9uT");//账号：密码
		ArrayList<String> phoneNumbers = new ArrayList<String>();
		/*
		 * phoneNumbers.add("13266853033"); phoneNumbers.add("18701699488");
		 */
        phoneNumbers.add("17791760604");
        
		try {
			String verifyCode  = String.valueOf(new Random().nextInt(899999) + 100000);
			SendSmsResult result = sender.send("", "1012888", phoneNumbers, "短信验证码："+verifyCode+"【中国健康传媒集团】", "", "");
			
			//assertEquals("succ", result.Result);
			System.out.println(verifyCode);
			System.out.println(result);
			
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SendSmsResult sendSms(String phone) {
		SendSmsSender sender = new SendSmsSender("dlzgyykj", "B9Ldi9uT");//账号：密码
		ArrayList<String> phoneNumbers = new ArrayList<String>();
		/*
		 * phoneNumbers.add("13266853033"); phoneNumbers.add("18701699488");
		 */
        phoneNumbers.add(phone);
        
        SendSmsResult result = null;
		try {
			String verifyCode  = String.valueOf(new Random().nextInt(899999) + 100000);
			 result = sender.send("", "1012888", phoneNumbers, "短信验证码："+verifyCode+"【中国健康传媒集团】", "", "");
			
			//assertEquals("succ", result.Result);
			System.out.println(verifyCode);
			RedisUtil redisUtil = ThreadUtils.getRedisUtil();
			//redisUtil.set(phone, verifyCode);//将验证码放进redis保存，便于验证
			redisUtil.set(phone, verifyCode, 120L);//设置120秒过期时间
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} 
			
		return result;
		
	
	}
}
