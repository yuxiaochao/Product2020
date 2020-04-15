package com.huarui.common.utils;

import com.enterprisedt.net.ftp.FileTransferClient;
import com.enterprisedt.net.ftp.FileTransferOutputStream;
import com.huarui.product2020.entity.FileEntity;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FtpUploadThread implements Runnable {
	private List<FileEntity> fileList = new ArrayList<FileEntity>();
	private static FtpUploadThread ftpUpload;
	private static Thread thread;

	static {
		ftpUpload = new FtpUploadThread();
		thread = new Thread(ftpUpload);
		thread.start();
	}

	public static FtpUploadThread getFtpUploadThread() {
		return ftpUpload; 
	}

	public synchronized void addFileEntity(FileEntity entity) {
		fileList.add(entity);
	}

	public synchronized void push(File file, String fileName, String ftpPath) {
		FileEntity entity = new FileEntity();
		entity.setFile(file);
		entity.setFileName(fileName);
		entity.setFtpPath(ftpPath);
		addFileEntity(entity);
	}
	
	public synchronized void push(String filePath, String fileName, String ftpPath) {
		File file = new File(filePath);
		FileEntity entity = new FileEntity();
		entity.setFile(file);
		entity.setFileName(fileName);
		entity.setFtpPath(ftpPath);
		addFileEntity(entity);
	}
	
	public synchronized void push(String filePath, String fileName, String ftpPath, boolean temp) {
		File file = new File(filePath);
		FileEntity entity = new FileEntity();
		entity.setFile(file);
		entity.setFileName(fileName);
		entity.setFtpPath(ftpPath);
		entity.setIsTemp(temp);
		addFileEntity(entity);
	}

	private synchronized FileEntity pop() {
		FileEntity entity = null;
		if (fileList.size() > 0) {
			entity = fileList.remove(0);
		}
		return entity;
	}

	private synchronized void process(FileEntity entity) {
		if(entity==null){
			return; 
		}
		try {
			uplodeFileMethd(entity.getFileName(), entity.getFile(),
					entity.getFtpPath());
			if(entity.getIsTemp()){
			/*	FileUtils.delete(entity.getFile());*/
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void uplodeFileMethd(String fileName, File file,
                                             String ftpPath) throws Exception {
		System.out.println("--------uplodeFileMethd.file:"+file);
		InputStream inStream = ThreadUtils.getFileUtils().fileToInputStream(file);
		if (inStream == null) {
			return; 
		}
		FileTransferClient ftp = FtpHelper.connect(ftpPath);
		FileTransferOutputStream os = ftp.uploadStream(fileName);
		byte[] bytes = new byte[1024];
		int c;
		while ((c = inStream.read(bytes)) != -1) {
			os.write(bytes, 0, c);
		}
		inStream.close();
		os.close();
		inStream = null; 
		os = null;
		ftp.disconnect();
	}

	public void run() {
		while (true) {
			process(pop());
		}

	}

}
