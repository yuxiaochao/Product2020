package com.huarui.common.utils;

import com.huarui.common.Constant;
import com.huarui.common.config.Global;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileUtil {
	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
	
	private static String EXT = null;
	private static boolean showFolder = false;
	private static List<String> fileList = new ArrayList<String>();
	
	private static final int BUFFER_SIZE = 2 * 1024;
	
	public List<String> fileOpertion(String path) {
		clearList();
		listFile(path);
		return fileList;
	}

	public void listFile(String path) {
		if (StringUtils.isEmpty(path)) {
			return;
		}
		File file = isFile(path);
		int n = fileType(file);
		if (n == 1) {
			String filep = getFilePath(file);
			putFilePath(filep);
		} else if (n == 2) {
			if (showFolder) {
				putFilePath(file.getAbsolutePath());
			}

			File[] files = file.listFiles();
			for (File f : files) {
				listFile(f.getAbsolutePath());
			}
		}
		return;
	}

	public String outputStreamToString(OutputStream outputStream){
		OutputStreamWriter out = new OutputStreamWriter(outputStream);
		String str = "";
		try {
			out.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	// 临时文件删除
	public void deleteFile(String filePath) throws IOException {
		if (StringUtils.isEmpty(filePath)) {
			return;
		}
		File targetFile = new File(filePath);
		if (targetFile.isDirectory()) {
			FileUtils.deleteDirectory(targetFile);
		} else if (targetFile.isFile()) {
			targetFile.delete();
		}
	}
	
	/**
	 * 删除文件夹
	 * 
	 * @param dir
	 * @return
	 */
	public boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		// 目录此时为空，可以删除
		return dir.delete();
	}
	
	/**
	 * 删除文件夹
	 * 
	 * @param dirFilePath
	 * @return
	 */
	public boolean deleteDir(String dirFilePath) {
		boolean flag = false;
		if (ThreadUtils.getRTex().isNotEmpty(dirFilePath)) {
			File dirFile = new File(dirFilePath);
			if (null != dirFile && dirFile.exists()) {
				flag = deleteDir(dirFile);
			}
		}
		return flag;
	}

	/*
	 * public boolean renameFile(String resFilePath, String newFileName)
	 * { String newFilePath = StringToolkit.formatPath(StringToolkit
	 * .getParentPath(resFilePath) + "/" + newFileName); File resFile = new
	 * File(resFilePath); File newFile = new File(newFilePath); return
	 * resFile.renameTo(newFile); }
	 */

	public String getFilePath(File file) {
		if (!StringUtils.isEmpty(EXT)) {
			if (EXT.toUpperCase().equals(getFileExt(file).toUpperCase())) {
				return file.getAbsolutePath();
			}
		} else {
			return file.getAbsolutePath();
		}
		return null;
	}

	public String getFileExt(File file) {
		File f = isFile(file);
		if (f != null) {
			String filepath = f.getAbsolutePath();
			return filepath.substring(filepath.lastIndexOf(".") + 1);
		}
		return null;
	}
	
	public String getFileExt(String filePath) {
		String ext = null;
		if (!ThreadUtils.getRTex().isEmpty(filePath)) {
			ext = filePath.substring(filePath.lastIndexOf(".") + 1);
		}
		return ext;
	}

	public File isFile(String path) {
		File file = new File(path);
		if (file.exists()) {
			return file;
		} else {
			return null;
		}
	}

	public File isFile(String path, boolean isCreate) {
		File file = new File(path);
		if (file.exists()) {
			return file;
		} else {
			if (isCreate) {
				return createFile(path);
			}
			return null;
		}
	}

	public File isFile(File file) {
		if (file == null) {
			return null;
		}
		if (file.exists()) {
			return file;
		} else {
			return null;
		}
	}

	/**
	 * �ļ�����
	 * 
	 * @param file
	 * @return 1 ��׼�ļ� 2�ļ���
	 */
	public int fileType(File file) {
		if (isFile(file) == null) {
			return -1;
		}
		if (file.isFile()) {
			return 1;
		} else if (file.isDirectory()) {
			return 2;
		}
		return 0;
	}

	public void clearList() {
		fileList.clear();
	}

	public List<String> getFileList() {
		return fileList;
	}

	public void putFilePath(String path) {
		if (!StringUtils.isEmpty(path)) {
			fileList.add(path);
		}
	}

	public void copyFile(String srcFile, String descFile) {
		int n = fileType(new File(srcFile));

		if (n == 1) {
			disposeFile(srcFile, descFile);
		} else if (n == 2) {
			showFolder = true;
			EXT = null;
			List<String> list = fileOpertion(srcFile);
			int k = srcFile.lastIndexOf("/");
			for (String str : list) {
				disposeFile(str, descFile + str.substring(k));
			}
		}

	}

	public void moveFile(String srcFile, String descFile) {
		copyFile(srcFile, descFile);
		try {
			deleteFile(srcFile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public File createFile(String filePath) {

		File file = new File(filePath);
		if (!file.exists()) {
			if (file.isDirectory()) {
				file.mkdirs();
			} else {
				String parent = file.getParent();
				File parentFile = new File(parent);
				if (!parentFile.exists()) {
					parentFile.mkdirs();
				}
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return file;
	}

	/**
	 * 合并文件
	 * 
	 * @param srcFile
	 */
	public String mergeFile(String srcFile, String fileName, int chunk,
                            int chunks, String fileTempPath) {
		boolean tag = true;
		try {
			File file = isFile(srcFile);
			File dFile = new File(fileTempPath + File.separator + fileName);
			if (!dFile.exists() || chunk == 0) {
				dFile.createNewFile();
				tag = false;
			}
			BufferedInputStream inputStream = new BufferedInputStream(
					new FileInputStream(srcFile));
			BufferedOutputStream outputStream = new BufferedOutputStream(
					new FileOutputStream(dFile, tag));
			long size = file.length();
			long k = (size / 1024);
			transitionStream(inputStream, outputStream, k);
			deleteFile(srcFile);
			if (chunk == chunks - 1) {
				return dFile.getAbsolutePath();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public void disposeFile(String srcFile, String descFile) {
		File file = isFile(srcFile);
		File desc = isFile(descFile, true);
		try {
			BufferedInputStream inputStream = new BufferedInputStream(
					new FileInputStream(srcFile));
			BufferedOutputStream outputStream = new BufferedOutputStream(
					new FileOutputStream(descFile));
			long size = file.length();
			long k = (size / 1024);
			transitionStream(inputStream, outputStream, k);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}

	}

	// 文件的复制
	public void transitionStream(InputStream inputStream,
                                 OutputStream outputStream, long k) {
		if (k < 1024) {
			k = 1024;
		} else if (k > 1048576) {
			k = 1048576;
		}
		byte[] buffer = new byte[(int) k];
		try {
			while ((inputStream.read(buffer)) != -1) {
				outputStream.write(buffer);
			}
			outputStream.flush();
			inputStream.close();
			outputStream.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public void inputStreamToFile(InputStream input, String filePath) {
		BufferedInputStream inputStream = new BufferedInputStream(input);
		BufferedOutputStream outputStream = null;
		try {
			outputStream = new BufferedOutputStream(new FileOutputStream(
					filePath));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}

		transitionStream(inputStream, outputStream, 1024);
	}
	
	public void inputStreamToFile(byte[] img, String filePath) {
		ByteArrayInputStream inputStream = new ByteArrayInputStream(img);
		
		BufferedOutputStream outputStream = null;
		try {
			outputStream = new BufferedOutputStream(new FileOutputStream(
					filePath));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}

		transitionStream(inputStream, outputStream, 1024);
	}

	public FileInputStream fileToInputStream(String filePath) {
		File file = isFile(filePath);
		FileInputStream inputStream = null;
		if (file != null) {
			try {
				inputStream = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}
		return inputStream;
	}

	public FileInputStream fileToInputStream(File file) {
		FileInputStream inputStream = null;
		if (file != null) {
			try {
				inputStream = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}
		return inputStream;
	}

	public FileInputStream readFile(String filePath, HttpServletRequest request) {
		filePath = ObjectUtils.toString(request.getAttribute("RESOURCE_FOLDER")) + filePath;
		return fileToStream(filePath);
	}

	public FileInputStream fileToStream(String filePath) {
		File file = isFile(filePath);
		FileInputStream inputStream = null;
		if (file != null) {
			inputStream = fileToInputStream(filePath);
		}
		return inputStream;
	}

	public String FileToString(String filepath) {
		return inputStreamToString(fileToInputStream(filepath));
	}

	public String inputStreamToString(InputStream inp) {
		try {
			return IOUtils.toString(inp, "UTF-8");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public InputStream StringToInputStream(String content) {
		try {
			return IOUtils.toInputStream(content, "utf-8");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public boolean StringToFile(String str, String filePath) {
		boolean flag = true;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		try {
			File distFile = new File(filePath);
			if (!distFile.getParentFile().exists())
				distFile.getParentFile().mkdirs();
			bufferedReader = new BufferedReader(new StringReader(str));
			bufferedWriter = new BufferedWriter(new FileWriter(distFile));
			char buf[] = new char[1024]; // 字符缓冲区
			int len;
			while ((len = bufferedReader.read(buf)) != -1) {
				bufferedWriter.write(buf, 0, len);
			}
			bufferedWriter.flush();
			bufferedReader.close();
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
			flag = false;
			return flag;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	public long getFileSize(String filePath) {
		File distFile = new File(filePath);
		if (distFile.isFile()) {
			return distFile.length();
		} else if (distFile.isDirectory()) {
			return FileUtils.sizeOfDirectory(distFile);
		}
		return -1L;
	}

	public String FormetFileSize(long fileSize) {// ת���ļ���С
		DecimalFormat df = new DecimalFormat("#.00");
		String fileSizeString = "";
		if (fileSize < 1024) {
			fileSizeString = df.format((double) fileSize) + "B";
		} else if (fileSize < 1048576) {
			fileSizeString = df.format((double) fileSize / 1024) + "K";
		} else if (fileSize < 1073741824) {
			fileSizeString = df.format((double) fileSize / 1048576) + "M";
		} else {
			fileSizeString = df.format((double) fileSize / 1073741824) + "G";
		}
		return fileSizeString;
	}

	public String FormatFilePath(String path) {
		if (!StringUtils.isEmpty(path)) {
			path = path.replaceAll("\\\\", "/");
		}
		return path;
	}

	public void renameFile(String path, String newname) {
		File oldfile = new File(path);
		File newfile = new File(oldfile.getParent() + "/" + newname);
		String oldname = oldfile.getName();
		if (!oldname.equalsIgnoreCase(newname)) {// 新的文件名和以前文件名不同时,才有必要进行重命名
			oldfile.renameTo(newfile);
		}
	}

	/**
	 * \文件签名
	 * 
	 * @param filePath
	 * @return
	 */
	public String fileSignature(String filePath) {
		try {
			return DigestUtils.md5Hex(new FileInputStream(new File(filePath)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 得到随机文件名
	 * 
	 * @param fileName
	 * @return
	 */
	public String getRandomName(String fileName) {
		String randomName = null;
		if (!ThreadUtils.getRTex().isEmpty(fileName)) {
			String ext = getFileExt(fileName);
			if (!ThreadUtils.getRTex().isEmpty(ext)) {
				StringBuilder sb = new StringBuilder(getRandomName());
				randomName = sb.append(".").append(ext).toString();
			}
		}
		return randomName;
	}

	/**
	 * 获取随机文件名
	 * 
	 * @return
	 */
	public String getRandomName() {
		StringBuilder sb = new StringBuilder(ThreadUtils.getRDate().getStampCharacters());
		sb.append(ThreadUtils.getRTex().getRandomNum(3)).toString();
		return sb.toString();
	}
	
	/**
	 * 得到临时文件上传的绝对路径
	 * 
	 * @return
	 */
	public String getUploadTmpPath(String suffix) {
//		StringBuilder sb = new StringBuilder(ThreadUtils.getWebUtil().getRequestRealPath(Constant.Upload_Temp_Path))
//				.append(File.separator);
		//获取临时文件路径
		StringBuilder sb = new StringBuilder(Global.getConfig(Global.WEBSITE_UPLOADPATH)).append(File.separator);
		if (ThreadUtils.getRTex().isNotEmpty(suffix)) {
			sb.append(suffix).append(File.separator);
		}
		return sb.toString();
	}
	
	/**
	 * 得到随机文件名
	 * 
	 * @return
	 */
	public String getRandomNameForExt(String ext) {
		String randomName = null;
		if (!ThreadUtils.getRTex().isEmpty(ext)) {
			if (!ThreadUtils.getRTex().isEmpty(ext)) {
				StringBuilder sb = new StringBuilder(getRandomName());
				randomName = sb.append(".").append(ext).toString();
			}
		}
		return randomName;
	}
	
	/**
	 * <p>
	 * 合并文件
	 * </p>
	 * 
	 * @param file
	 *            指定合并后的文件
	 * @throws Exception
	 */
	public void mergechunkFiles(String file, String filePath, String chunkFileName) throws Exception {
		int max = validateChunkMergeFile(filePath);
		if (max > 0) {
			RandomAccessFile ok = new RandomAccessFile(new File(file), "rw");
			String chunkFilePathName = filePath + chunkFileName + ".chunk";
			for (int i = 0; i <= max; i++) {
				RandomAccessFile read = new RandomAccessFile(new File(chunkFilePathName + i), "r");
				byte[] b = new byte[1024];
				int n = 0;
				while ((n = read.read(b)) != -1) {
					ok.write(b, 0, n);
				}
				read.close();
			}
			ok.close();
		} else {
			logger.info("文件不完整，不能进行合并");
		}
	}
	
	/**
	 * 验证分片文件是完整
	 * 
	 * @return 0不完整，其他值完整，返回分片的最大值
	 */
	public int validateChunkMergeFile(String chunkPath) {
		File files = new File(chunkPath);
		int max = 0;
		if (null != files && files.exists()) {
			String fileName = null;
			String chunkName = null;
			List<Integer> list = new ArrayList<Integer>();

			for (File file : files.listFiles()) {
				fileName = file.getName();
				chunkName = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
				if (ThreadUtils.getRTex().isNotEmpty(chunkName)) {
					int tmp = ThreadUtils.getRTex().toInteger(chunkName.replace("chunk", ""));
					list.add(tmp);
					max = max < tmp ? tmp : max;
				}
			}
			boolean flag = true;
			Collections.sort(list);
			for (int i = 0; i < max; i++) {
				if (list.get(i).intValue() != i) {
					flag = false;
					break;
				}
			}
			if (!flag) {
				max = 0;
			}
		}
		return max;
	}
	/**
	 * 文件下载
	 * 
	 * @param fileName
	 */
	public void downloadFile(String fileName, byte[] bytes) {
		HttpServletRequest request = ThreadUtils.getWebUtil().getWebRequest();
		HttpServletResponse response = ThreadUtils.getWebUtil().getWebResponse();
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			ThreadUtils.getWebUtil().setFileDownloadHeader(request, response, fileName);
			os.write(bytes);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 下载文件
	 * 
	 * @param out
	 */
	public void flushOutputStream(OutputStream out) {
		try {
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * inputStream转byte数组
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public byte[] inputStreamToByte(InputStream in) throws IOException {
		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
		byte[] buff = new byte[100];
		int rc = 0;
		while ((rc = in.read(buff, 0, 100)) > 0) {
			swapStream.write(buff, 0, rc);
		}
		return swapStream.toByteArray();
	}

	/**
	 * 获取Excel导入模版文件
	 * @param fileName
	 * @return
	 */
	public InputStream getExcelImportTemplateFile(String fileName) {
		InputStream in = null;
		if (ThreadUtils.getRTex().isNotEmpty(fileName)) {
//			String excelTemplatePath = ThreadUtils.getWebUtil().getRequestRealPath(Constant.ExcelImp_Template_Path)
//					+ File.separator + fileName;
//			in = fileToInputStream(excelTemplatePath);

			// 获取资源中的模板文件
			ClassPathResource resource = new ClassPathResource(Constant.ExcelImp_Template_Path + fileName);
			try {
				in = resource.getInputStream();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return in;
	}

	/**
	 * 获取Excel导出模版文件
	 * @param fileName
	 * @return
	 */
	public InputStream getExcelExportTemplateFile(String fileName) {
		InputStream in = null;
		if (ThreadUtils.getRTex().isNotEmpty(fileName)) {
//			String excelTemplatePath = ThreadUtils.getWebUtil().getRequestRealPath(Constant.ExcelExp_Template_Path)
//					+ File.separator + fileName;
//			in = fileToInputStream(excelTemplatePath);

			// 获取资源中的模板文件
			ClassPathResource resource = new ClassPathResource(Constant.ExcelExp_Template_Path + fileName);
			try {
				in = resource.getInputStream();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return in;
	}
}
