package com.huarui.common;

import com.huarui.common.utils.ApplicationContextUtil;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.entity.HrswTChatmessage;
import com.huarui.product2020.entity.HruxTConfirmationsending;
import com.huarui.product2020.service.IHrswTChatmessageService;
import com.huarui.product2020.service.IHruxTConfirmationsendingService;
import com.huarui.product2020.service.SendMessageAPI;
import io.swagger.client.model.Msg;
import io.swagger.client.model.UserName;

import java.util.*;

public class SendMessageThread implements Runnable {
	private List<HrswTChatmessage> mesList = new LinkedList<HrswTChatmessage>();
	private static SendMessageThread sendMessage;
	private static Thread thread;
	private Object object = new Object();

//	static {
//		sendMessage = new SendMessageThread();
//		thread = new Thread(sendMessage);
//		thread.start();
//	}
	
	public SendMessageThread() {
		thread = new Thread(this);
		thread.start();
	}

	public static SendMessageThread getFtpUploadThread() {
		return sendMessage; 
	}

	public synchronized void addChatmessage(HrswTChatmessage entity) {
		synchronized (object) {
			mesList.add(entity);
			object.notify();
		}
	}


	private synchronized HrswTChatmessage pop() {
		HrswTChatmessage entity = null;
		if (mesList.size() > 0) {
			entity = mesList.remove(0);
		}else {
			return null;
		}
		return entity;
	}

	
	/**
	 * 检测未发送消息
	 */
	public  int checkUnsentMsg() {
		IHrswTChatmessageService chmes = (IHrswTChatmessageService)ApplicationContextUtil.getBean("hrswTChatmessageServiceImpl");
		List<HrswTChatmessage> list = chmes.checkUnsentMsg(new HashMap());
		if(list == null || list.size() == 0) {
			return 0;
		}else {
			for(HrswTChatmessage map : list) {
				sendMessage(map);
			}
			return 1;
		}
		
	}
	
	public void sendMessage(HrswTChatmessage entity) {
		if(entity==null) {
			return;
		}
		Msg msg = new Msg();
		SendMessageAPI sendMsg = (SendMessageAPI)ApplicationContextUtil.getBean("easemobSendMessage");
		//发送的目标类型；users：给用户发消息，chatgroups：给群发消息，chatrooms：给聊天室发消息
		String targetType = "users";
		// 消息类型：1、系统消息 2、群组消息 3、一对一消息等 4、新的好友消息 5、党建办消息
		if(2 == entity.getChme002()||6 == entity.getChme002()) {
			targetType = "chatgroups";
		}
		msg.setTargetType(targetType);
		UserName userName = new UserName();
		userName.add(entity.getChme007());
		msg.setTarget(userName);
		Map map02 = new HashMap();
		map02.put("type", "txt");
		map02.put("msg", entity.getChme012());
		msg.setMsg(map02);
		msg.setFrom(entity.getChme004());
		Object res = sendMsg.sendMessage(msg);
		System.out.println("---------------发送："+res);
		//TODO  判断是否回馈是否接受到
		IHruxTConfirmationsendingService conf = (IHruxTConfirmationsendingService)ApplicationContextUtil.getBean("hruxTConfirmationsendingServiceImpl");
		HruxTConfirmationsending confen = new HruxTConfirmationsending();
		confen.setCose001(ThreadUtils.getRTex().getUUID());
		confen.setCose002(entity.getChme001());
		confen.setCose003(new Date());
		conf.insert(confen);
		
		
	}


	public void run() {
		while (true) {
			HrswTChatmessage htc = pop();
			if(htc == null) {
				synchronized (object) {
					try {
						object.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			sendMessage(htc);
		}

	}

}
