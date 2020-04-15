package com.huarui.task;

import com.huarui.common.SendMessageThread;
import com.huarui.common.utils.ThreadUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TimedTask {

public final static long ONE_Minute =  1 * 1000;
	
	/**
	 * 	定时任务每个月删除上个月的聊天消息
	 */
    @Scheduled(cron="0 0 0 1 * ?")//每月一号执行一遍
    public void cronJob(){
    	//TODO 删除聊天消息
    	Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date)+" >>fixedDelay执行....");
    }
    
    /**
	 * 	每10秒执行一遍
	 */
    @Scheduled(cron="0/10 * * * * ?")
    public void checkSendMessage(){
    	System.out.println("---------------每十秒检测未发消息----------------------");
    	SendMessageThread smt = ThreadUtils.getSendMessage();
    	smt.checkUnsentMsg();
    }

}
