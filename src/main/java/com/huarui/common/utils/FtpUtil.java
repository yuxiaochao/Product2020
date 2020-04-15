package com.huarui.common.utils;

import com.huarui.common.config.Global;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPHTTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.Arrays;
import java.util.List;

/**
 * FTP工具类，使用Apache的FTP组件实现
 *
 */
public class FtpUtil {

	private FTPClient getFtp(String ftpServer, String ftpusername, String ftppassword, int port) throws SocketException, IOException {
		FTPClient ftp = null;
		String proxySet = System.getProperty("proxySet");

		if ("true".equals(proxySet)) {
			ftp = new FTPHTTPClient(System.getProperty("http.proxyHost"),
					Integer.parseInt(System.getProperty("http.proxyPort")));
		} else {
			ftp = new FTPClient();
		}

		int reply;
		// 连接FTP服务器
		// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
		// ftp.connect(SystemConfiguration.getProperty("ftpserver"),
		// ThreadUtils.getRTex().toInteger(SystemConfiguration.getProperty("ftpport"),
		// 21)); // 登录ftp
		// ftp.login(SystemConfiguration.getProperty("ftpusername"),
		// SystemConfiguration.getProperty("ftppassword"));

		ftp.connect(ftpServer, port); // 登录ftp
		ftp.login(ftpusername, ftppassword);

		// 看返回的值是不是230，如果是，表示登陆成功

		//ftp.connect("192.168.1.171", 21);
		//ftp.login("ftp1", "abc@123");

		ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
		ftp.setControlEncoding("UTF-8");
		ftp.enterLocalPassiveMode();
		ftp.setConnectTimeout(2000);
		ftp.setBufferSize(1024);
		reply = ftp.getReplyCode();
		// 以2开头的返回值就会为真
		if (!FTPReply.isPositiveCompletion(reply)) {
			ftp.disconnect();
			return null;
		}

		return ftp;

	}

	private FTPClient getFtp() throws SocketException, IOException {
		FTPClient ftp = null;
		String proxySet = System.getProperty("proxySet");

		if ("true".equals(proxySet)) {
			ftp = new FTPHTTPClient(System.getProperty("http.proxyHost"),
					Integer.parseInt(System.getProperty("http.proxyPort")));
		} else {
			ftp = new FTPClient();
		}

		int reply;
		
		ftp.connect(Global.getConfig("ftpServer"),
				ThreadUtils.getRTex().toInteger(Global.getConfig("ftpport"), 21)); // 登录ftp
		ftp.login(Global.getConfig("ftpusername"), Global.getConfig("ftppassword"));

		// 看返回的值是不是230，如果是，表示登陆成功

		ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
		ftp.setControlEncoding("UTF-8");
		ftp.enterLocalPassiveMode();
		ftp.setConnectTimeout(2000);
		ftp.setBufferSize(1024);
		reply = ftp.getReplyCode();
		// 以2开头的返回值就会为真
		if (!FTPReply.isPositiveCompletion(reply)) {
			ftp.disconnect();
			return null;
		}

		return ftp;

	}

	/**
	 * 向ftp上传文件
	 * 
	 * @param path
	 *            需要上传到ftp的路径
	 * @param filename
	 *            上传ftp的文件名
	 * @param input
	 *            上传的流
	 * @return
	 */
	public boolean uploadFile(String ftpServer, String ftpusername, String ftppassword, int port, String ftpPath, String filename, InputStream input) {
		boolean flag = false;
		if (ftpPath != null && !"".equals(filename)) {
			FTPClient ftp = null;
			try {
				ftp = getFtp(ftpServer,ftpusername,ftppassword,port);
				if (null != ftp) {
					changeWorkingDirectory(ftp, ftpPath);

					String proxySet = System.getProperty("proxySet");
					// 如果有配置代理参数时，需要设置如下模式
					if ("true".equals(proxySet)) {
						ftp.enterLocalPassiveMode();
					}
					// 将上传文件存储到指定目录
					ftp.storeFile(filename, input);
					// 关闭输入流
					input.close();
					flag = true;
				}
			} catch (SocketException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				closeFTPClient(ftp);
			}

		} else {

		}
		return flag;
	}

	/**
	 * 向ftp上传文件
	 * 
	 * @param path
	 *            需要上传到ftp的路径
	 * @param filename
	 *            上传ftp的文件名
	 * @param input
	 *            上传的流
	 * @return
	 */
	public boolean uploadFile(String ftpPath, String filename, InputStream input) {
		boolean flag = false;
		if (ftpPath != null && !"".equals(filename)) {
			FTPClient ftp = null;
			try {
				ftp = getFtp();
				if (null != ftp) {
					changeWorkingDirectory(ftp, ftpPath);

					String proxySet = System.getProperty("proxySet");
					// 如果有配置代理参数时，需要设置如下模式
					if ("true".equals(proxySet)) {
						ftp.enterLocalPassiveMode();
					}
					// 将上传文件存储到指定目录
					ftp.storeFile(filename, input);
					// 关闭输入流
					input.close();
					flag = true;
				}
			} catch (SocketException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				closeFTPClient(ftp);
			}

		} else {
		}
		return flag;
	}

	/**
	 * 向ftp上传文件
	 * 
	 * @param path
	 *            需要上传到ftp的路径
	 * @param filename
	 *            上传ftp的文件名
	 * @param input
	 *            上传的文件
	 * @return
	 * @throws FileNotFoundException
	 */
	public boolean uploadFile(String ftpPath, String ftpFilename, String filePath) throws FileNotFoundException {
		boolean flag = false;
		if (ThreadUtils.getRTex().isNotEmpty(filePath)) {
			FileInputStream in = new FileInputStream(filePath);
			flag = uploadFile(ftpPath, ftpFilename, in);
		}
		return flag;
	}
	

	/**
	 * 关闭FTP连接
	 * 
	 * @param ftp
	 * @throws Exception
	 */
	private void closeFTPClient(FTPClient ftp) {
		if (null != ftp) {
			try {
				if (ftp.isConnected()) {
					ftp.logout();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					ftp.disconnect();
				} catch (IOException e) {
					try {
						throw new Exception("关闭FTP服务出错!");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		}

	}

	private boolean changeWorkingDirectory(FTPClient ftp, String ftpPath) throws IOException {
		boolean changeWorkingDirectoryB = false;
		if (ftpPath.isEmpty()) {
			ftpPath = "";
		}
		String nowPath = "";
		String ftpEachLayerPath[] = ftpPath.split("/");
		for (int i = 0; i < ftpEachLayerPath.length; i++) {
			nowPath += "/" + ftpEachLayerPath[i];
			changeWorkingDirectoryB = ftp.changeWorkingDirectory(nowPath);
			if (!changeWorkingDirectoryB) {
				// 逐级创建目录
				ftp.makeDirectory(nowPath);
			}
		}

		return ftp.changeWorkingDirectory(ftpPath);
	}

	/**
	 * 连接ftp
	 * 
	 * @return FTPClient
	 * @throws Exception
	 */
	public FTPClient getFtpClient(String remotePath) throws Exception {
		FTPClient ftp = getFtp();
		changeWorkingDirectory(ftp, remotePath);
		return ftp;
	}
	
	/**
	 * 获取当前工作目录中包含的目录的列表
	 * 
	 * @param remoteFoldPath
	 * @return
	 */
	public List<FTPFile> listFold(String remoteFoldPath) throws Exception {
		FTPClient ftp = getFtp();
		List<FTPFile> ftpfiles = Arrays.asList(ftp.listDirectories(remoteFoldPath));
		closeFTPClient(ftp);
		return ftpfiles;
	}
	
	/**
	 * 获取FTP服务器上[指定路径]下的文件列表
	 * 
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public List<FTPFile> getFileList(String remotePath) throws Exception {
		FTPClient ftp = getFtp();
		List<FTPFile> ftpfiles = Arrays.asList(ftp.listFiles(remotePath));
		closeFTPClient(ftp);
		return ftpfiles;
	}
	
	/**
	 * 创建目录
	 * 
	 * @param remoteFoldPath
	 * @return
	 */
	public boolean createFold(String remoteFoldPath) throws Exception {
		FTPClient ftp = getFtp();
		boolean flag = ftp.makeDirectory(remoteFoldPath);
		closeFTPClient(ftp);
		if (!flag) {
			throw new Exception("创建目录失败");
		}
		return false;
	}
	
	/**
	 * 删除文件
	 * 
	 * @param remoteFilePath
	 * @return
	 * @throws Exception
	 */
	public Boolean deleteFtpServerFile(String remoteFilePath) throws Exception {
		FTPClient ftp = getFtp();
		boolean flag = ftp.deleteFile(remoteFilePath);
		closeFTPClient(ftp);
		return flag;
	}
	/**
	 * 从FTP服务器获取文件流
	 * 
	 * @param remoteFilePath
	 * @return
	 * @throws Exception
	 */
	public InputStream downloadFile(String remoteFilePath) throws Exception {
		FTPClient ftp = getFtp();
		return ftp.retrieveFileStream(remoteFilePath);
	}
}