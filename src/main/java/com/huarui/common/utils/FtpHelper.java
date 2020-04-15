package com.huarui.common.utils;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.enterprisedt.net.ftp.FTPFile;
import com.enterprisedt.net.ftp.FileTransferClient;
import com.huarui.product2020.entity.HrswTSysconfig;
import com.huarui.product2020.service.impl.HrswTSysconfigServiceImpl;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

@Component
public class FtpHelper implements ApplicationContextAware {

	private static ApplicationContext applicationContext = null;
	// 连接到ftp 
	public static FileTransferClient connect(String type) {
		type = ThreadUtils.getRTex().decodeParameters(type);
		FileTransferClient ftp = new FileTransferClient();
		ftp.getAdvancedSettings().setControlEncoding("gb2312");
		
		// HashMap<String, String> configMap = (HashMap<String, String>)
		// application.get("Config");
		/*String ftpServer = ObjectUtils.toString(Constant.Global_SC
				.getAttribute(Constant.Config_FtpServer_0));
		int ftpPort = NumberUtils.toInt(ObjectUtils.toString(Constant.Global_SC
				.getAttribute(Constant.Config_FtpPort_0)), 21);
		String ftpUser = ObjectUtils.toString(Constant.Global_SC
				.getAttribute(Constant.Config_FtpUser_0));
		// String ftpUser = "123";
		String ftpPassword = ObjectUtils.toString(Constant.Global_SC
				.getAttribute(Constant.Config_FtpPassword_0));*/

			String ftpServer = getFtpServer();
			int ftpPort = getFtpPort();
			String ftpUser = getFtpUser();
			String ftpPassword = getFtpPassword();
		try {
			System.out.println("ftpServer:"+ftpServer);
			System.out.println("ftpPort:"+ftpPort);
			System.out.println("ftpUser:"+ftpUser);
			System.out.println("ftpPassword:"+ftpPassword);
			
			ftp.setRemoteHost(ftpServer);
			ftp.setRemotePort(ftpPort);
			ftp.setUserName(ftpUser);
			ftp.setPassword(ftpPassword);
			
			ftp.connect();
			System.out.println("创建一次ftp");
			
			type = StringUtils.removeStart(type, "/");
			String[] typeArray = type.split("/");
			for (int i = 0; i < typeArray.length; i++) {
				if (!checkDirectory(ftp, typeArray[i]))
					ftp.createDirectory(typeArray[i]);
				ftp.changeDirectory(typeArray[i]);
			}
		} catch (Exception e) {
			System.out.println("ftp连接失败！！！Exception："+e);
			//e.printStackTrace();
			ftp = null;
		}
		
		return ftp;
	}

	public static FileTransferClient connect(Map serverMap, String type) {
		FileTransferClient ftp = new FileTransferClient();
		ftp.getAdvancedSettings().setControlEncoding("gb2312");

		String ftpServer = ObjectUtils.toString(serverMap.get("FTPSERVER"));
		int ftpPort = NumberUtils.toInt(
				ObjectUtils.toString(serverMap.get("FTPPORT")), 21);
		String ftpUser = ObjectUtils.toString(serverMap.get("FTPUSER"));
		String ftpPassword = ObjectUtils.toString(serverMap.get("FTPPASSWORD"));

		try {
			ftp.setRemoteHost(ftpServer);
			ftp.setRemotePort(ftpPort);
			ftp.setUserName(ftpUser);
			ftp.setPassword(ftpPassword);
			ftp.connect();

			String[] typeArray = type.split("/");
			for (int i = 0; i < typeArray.length; i++) {
				if (!checkDirectory(ftp, typeArray[i]))
					ftp.createDirectory(typeArray[i]);
				ftp.changeDirectory(typeArray[i]);
			}
		} catch (Exception e) {
			//e.printStackTrace();
			ftp = null;
		}

		return ftp;
	}

	// 更改ftp的路径
	public static boolean checkDirectory(FileTransferClient ftp, String dirName) {
		boolean _flag = false;
		try {
			FTPFile[] files = ftp.directoryList();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDir()) {
					if (dirName.equalsIgnoreCase(files[i].getName())) {
						_flag = true;
						break;
					}
				}
			}
		} catch (Exception e) {
		}
		return _flag;
	}

	// 断开ftp的连接
	public static void disconnect(FileTransferClient ftp) {
		try {
			ftp.disconnect();
		} catch (Exception e) {
		}
	}

	// 得到ftp文件的文件流
	public static InputStream getFileStream(String type, HttpServletRequest request) {
		InputStream inputStream = null;
		try {
			String path = StringUtils.substringBeforeLast(type, "/");
			String filename = StringUtils.substringAfterLast(type, "/");
			FileTransferClient ftp = connect(path);
			byte[] data = ftp.downloadByteArray(filename);
			inputStream = new ByteArrayInputStream(data);
			disconnect(ftp);
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return inputStream;
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		 if(FtpHelper.applicationContext == null){
			 FtpHelper.applicationContext  = applicationContext;
	        } 
	}
	public  static String getFileServerPath(){
		HrswTSysconfigServiceImpl sysConfigService = applicationContext.getBean(HrswTSysconfigServiceImpl.class);
		EntityWrapper ftpEW = new EntityWrapper();
		ftpEW.setEntity(new HrswTSysconfig());
		ftpEW.where("SYSC005 = {0}", "server.fileServer");
		HrswTSysconfig fileEntity = sysConfigService.selectOne(ftpEW);
		String fileServer = ObjectUtils.toString(fileEntity.getSysc007(),"");
		return fileServer;
	}
	public static String getFtpServer(){
		HrswTSysconfigServiceImpl sysConfigService = applicationContext.getBean(HrswTSysconfigServiceImpl.class);
		EntityWrapper ftpEW = new EntityWrapper();
		ftpEW.setEntity(new HrswTSysconfig());
		ftpEW.where("SYSC005 = {0}", "ftpServer");
		HrswTSysconfig fileEntity = sysConfigService.selectOne(ftpEW);
		String ftpServer = ObjectUtils.toString(fileEntity.getSysc007(),"");
		return ftpServer;
	}
	public static  int getFtpPort(){
		HrswTSysconfigServiceImpl sysConfigService = applicationContext.getBean(HrswTSysconfigServiceImpl.class);
		EntityWrapper ftpEW = new EntityWrapper();
		ftpEW.setEntity(new HrswTSysconfig());
		ftpEW.where("SYSC005 = {0}", "ftpport");
		HrswTSysconfig fileEntity = sysConfigService.selectOne(ftpEW);
		int ftpport = Integer.parseInt(ObjectUtils.toString(fileEntity.getSysc007(),""));
		return ftpport;
	}
	public static String getFtpUser(){
		HrswTSysconfigServiceImpl sysConfigService = applicationContext.getBean(HrswTSysconfigServiceImpl.class);
		EntityWrapper ftpEW = new EntityWrapper();
		ftpEW.setEntity(new HrswTSysconfig());
		ftpEW.where("SYSC005 = {0}", "ftpusername");
		HrswTSysconfig fileEntity = sysConfigService.selectOne(ftpEW);
		String ftpUser = ObjectUtils.toString(fileEntity.getSysc007(),"");
		return ftpUser;
	}
	public static String getFtpPassword(){
		HrswTSysconfigServiceImpl sysConfigService = applicationContext.getBean(HrswTSysconfigServiceImpl.class);
		EntityWrapper ftpEW = new EntityWrapper();
		ftpEW.setEntity(new HrswTSysconfig());
		ftpEW.where("SYSC005 = {0}", "ftppassword");
		HrswTSysconfig fileEntity = sysConfigService.selectOne(ftpEW);
		String ftpPassword = ObjectUtils.toString(fileEntity.getSysc007(),"");
		return ftpPassword;
	}

	
}
