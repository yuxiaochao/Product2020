package com.huarui.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.huarui.common.JsonValidator;
import com.huarui.common.Req;
import com.huarui.common.config.Global;
import com.huarui.product2020.entity.HrswTUserpurview;
import com.huarui.product2020.service.IHrswTUserService;
import com.huarui.product2020.service.IHrswTUserpurviewService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebUtil {
	public final String ecryptedKey = "$@$.ecryptedData";
	private static final Logger logger = LoggerFactory.getLogger(WebUtil.class);
	
	/**
	 * DES解密加密的参数参数
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public Map<String, String[]> decryptionParameters(Map<String, String[]> encParameterMap, String secretkey)
			throws UnsupportedEncodingException {
		Map<String, String> decryptionMap = null;
		Map<String, String[]> requestdecryptionMap = new LinkedHashMap<String, String[]>();
		if (!ThreadUtils.getRTex().isEmpty(secretkey)) {
			String[] ecryptedDataParams = encParameterMap.get(ecryptedKey);
			if (null != ecryptedDataParams) {
				String ecryptedData = (ecryptedDataParams)[0];
				String decryptionJson = ThreadUtils.getDesEncryption().strDec(ecryptedData, secretkey);
				if (new JsonValidator().validate(decryptionJson)) {
					decryptionMap = (Map) ThreadUtils.getRTex().jsonSerializeObject(decryptionJson, Map.class);
					Set<String> keys = decryptionMap.keySet();
					for (String key : keys) {
						String value = ThreadUtils.getRTex().toString(decryptionMap.get(key));
						if (StringUtils.isNotBlank(value)) {
							value = ThreadUtils.getRTex().URLEncoderUTF8(value);
							requestdecryptionMap.put(key, new String[] { value });
						}
					}
				} else {
					logger.info("发送加密数据解密失败,用户与服务器密钥不一致，刷新浏览器解决...");
				}

			}
		}
		return requestdecryptionMap;
	}

	/**
	 * AES解密加密的参数参数
	 *
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public Map<String, String[]> decryptionParametersAES(Map<String, String[]> encParameterMap, String secretkey)
			throws UnsupportedEncodingException {
		Map<String, String> decryptionMap = null;
		Map<String, String[]> requestdecryptionMap = new LinkedHashMap<String, String[]>();
		if (!ThreadUtils.getRTex().isEmpty(secretkey)) {
			String[] ecryptedDataParams = encParameterMap.get(ecryptedKey);
			if (null != ecryptedDataParams) {
				String ecryptedData = (ecryptedDataParams)[0];
				String decryptionJson = null;
				try {
					decryptionJson = ThreadUtils.getAesUtil().decrypt(ecryptedData, secretkey);
				} catch (Exception e) {

					e.printStackTrace();
				}
				if (ThreadUtils.getJsonValidators().validate(decryptionJson)) {
					decryptionMap = (Map) ThreadUtils.getRTex().jsonSerializeObject(decryptionJson, Map.class);
					Set<String> keys = decryptionMap.keySet();
					for (String key : keys) {
						String value = ThreadUtils.getRTex().toString(decryptionMap.get(key));
						//if (ThreadUtils.getRTex().isNotEmpty(value)) {
						value = ThreadUtils.getRTex().decodeURI(value);
						requestdecryptionMap.put(key, new String[] { value });
						//}
					}
				} else {
					logger.info("发送加密数据解密失败,用户与服务器密钥不一致，请重新登录解决...");

				}

			}
		}
		return requestdecryptionMap;
	}
	
	/**
	 * 生成Web与服务器通讯的加密密钥
	 * 
	 * @return
	 */
	public String generateSecreKkey() {
		String key = ThreadUtils.getRTex().getRandomStr(16);
		return ThreadUtils.getRTex().toString(key);
	}
	
	/**
	 * 获取用户编号
	 * @return
	 */
	public String getWebUserId() {
		HttpServletRequest request = getWebRequest();
		String loginlogId = ObjectUtils.toString(request.getAttribute("userid"));
		return loginlogId;
	}
	
	/**
	 * 获取用户名
	 * @return
	 */
	public String getWebUserName() {
		HttpServletRequest request = getWebRequest();
		String loginlogId = ObjectUtils.toString(request.getAttribute("username"));
		return loginlogId;
	}
	
	/**
	 * 获取用户姓名
	 * @return
	 */
	public String getWebUserAlias() {
		HttpServletRequest request = getWebRequest();
		String loginlogId = ObjectUtils.toString(request.getAttribute("useralias"));
		return loginlogId;
	}
	
	/**
	 * 获取用户性别
	 * @return
	 */
	public String getWebUserSex() {
		HttpServletRequest request = getWebRequest();
		String loginlogId = ObjectUtils.toString(request.getAttribute("usersex"));
		return loginlogId;
	}
	
	/**
	 * 获取机构编号
	 * @return
	 */
	public String getWebOrganId() {
		HttpServletRequest request = getWebRequest();
		String loginlogId = ObjectUtils.toString(request.getAttribute("organid"));
		return loginlogId;
	}
	
	/**
	 * 获取机构名称
	 * @return
	 */
	public String getWebOrganName() {
		HttpServletRequest request = getWebRequest();
		String loginlogId = ObjectUtils.toString(request.getAttribute("organname"));
		return loginlogId;
	}
	
	/**
	 * 获取LogId
	 * @return
	 */
	public String getWebLoginLogId() {
		HttpServletRequest request = getWebRequest();
		String loginlogId = ObjectUtils.toString(request.getAttribute("loginlogId"));
		return loginlogId;
	}
	
	/**
	 * 获取request对象
	 * @return
	 */
	public HttpServletRequest getWebRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}

	/**
	 * 得到resources目录的路径
	 *
	 * @return
	 */
	public String getRequestRealPath(String relativePath) {
		HttpServletRequest request = getWebRequest();
		String absolutePath = request.getSession().getServletContext().getRealPath(relativePath);
		return absolutePath;
	}
	
	/**
	 * 获取response 通过WEB.xml配置request固化器来实现
	 * 
	 * @return
	 */
	public HttpServletResponse getWebResponse() {
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getResponse();
		return response;
	}
	
	/**
	 * 从request 得到Map
	 * 
	 * @return
	 */
	public Map<String, String> getWebParameterMap() {
		HttpServletRequest request = getWebRequest();
		Map<String, String[]> map = request.getParameterMap();
		Map<String, String> parameters = new HashMap<String, String>(map.size());
		Set<String> keys = map.keySet();
		for (String key : keys) {
			String[] values = map.get(key);
			parameters.put(key, StringUtils.join(values,"$$"));
		}
		map = null;
		return parameters;
	}
	
	/**
	 * 解析req参数
	 * 
	 * @param req
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 */
	public Req getWebReq(Req req) throws NoSuchFieldException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, ClassNotFoundException, InstantiationException {
		Map<String, String> paramsMap = getWebParameterMap();
		
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		Set<String> keys = paramsMap.keySet();
		// 初始化排序表达式
		// 将基础的分页参数设置进req的分页参数
		for (String key : keys) {
			Object value = paramsMap.get(key);
			if ("IDS".equalsIgnoreCase(key)) {
				req.setIds(ThreadUtils.getRTex().toString(value));
			} else if ("selectUserOrganId".equalsIgnoreCase(key)) {//选择机构数据
				try {
					if(value != null) {
						parameterMap.put(key, value.toString().split(","));
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			} else {
				// 过滤script标签
				String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>";
		        Pattern p_script= Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
		        Matcher m_script=p_script.matcher(ThreadUtils.getRTex().toString(value));
		        value=m_script.replaceAll("");
				parameterMap.put(key, value);
			}
		}
		req.putParameter(parameterMap);
		//获取user信息map
		Map<String, Object> userMap = getRedisUser();
		req.setUserId(ThreadUtils.getRTex().toString(userMap.get("USER001")));//用户id
		req.setUserName(ThreadUtils.getRTex().toString(userMap.get("USER004")));//账号
		req.setUserAlias(ThreadUtils.getRTex().toString(userMap.get("USER005")));//姓名
		req.setUserOrganId(ThreadUtils.getRTex().toString(userMap.get("USER002")));//机构ID
		req.setUserOrganName(ThreadUtils.getRTex().toString(userMap.get("ORGA006")));//机构简称
		req.setManagement(ThreadUtils.getRTex().toInteger(userMap.get("isManager"))==1?true:false);//是否为管理员 
		req.setCompanySource(ThreadUtils.getRTex().toInteger(userMap.get("companySource"), -1));//获得该角色来源   1,'运营单位',2,'认证单位',3,'报名单位'
		req.setAuthenticationOrganType(ThreadUtils.getRTex().toInteger(userMap.get("authenticationOrganType"), -1));//认证单位类型 默认-1 0 中电联 1省级鉴定中心 2市级鉴定站
		req.setUserManagerOrganId(ThreadUtils.getRTex().toString(userMap.get("managerOrganID")));//得到主办单位
		//当前第几页
		int start = ThreadUtils.getRTex().toInteger(parameterMap.get("START"));
		if(start != 0) {
			req.setCurrentPage(start);
		}
		//每页显示几条
		int limit = ThreadUtils.getRTex().toInteger(parameterMap.get("LIMIT"));
		if(limit != 0) {
			req.setPageSize(limit);
		}
		
		
		
		return req;
	}
	
	/**
	 * 获取redis中的user信息
	 * @return
	 */
	public Map<String, Object> getRedisUser() {
		HttpServletRequest request = getWebRequest();
		String authorization = request.getHeader("Authorization");
		String token = "";
		String key = "";
		Map<String, Object> userMap = new HashMap<String, Object>();
		try {
			authorization = StringUtils.substring(authorization, 7);
			Algorithm algorithm = Algorithm.HMAC256(Global.PRIVATEKEY);
			JWTVerifier verifier = JWT.require(algorithm).build(); // Reusable verifier instance
			DecodedJWT jwt = verifier.verify(authorization);
			if (jwt != null) {
				DecodedJWT jwt1 = JWT.decode(authorization);
				Claim claim = jwt1.getClaim(Global.USERTOKEN);
				String[] authorizations = claim.asString().split(":");
				token = authorizations[1];
				key = token + ":" + Global.USERTOKEN;
				userMap = ThreadUtils.getRedisUtil().mget(key);
				if(userMap.isEmpty()) {
					String username = authorizations[0];
					IHrswTUserService htus = (IHrswTUserService)ApplicationContextUtil.getBean("hrswTUserServiceImpl");
					userMap = htus.selectMapForUserInfo(username, "loginAgain1070331325"); // 查询用户信息
					
					//设置user管理员信息
					setUserManagementInformation(userMap);
					
					ThreadUtils.getRedisUtil().setMap(token + ":" + Global.USERTOKEN, userMap,
							NumberUtils.toLong(Global.getConfig(Global.EXPIRETIME)));
				}else {
					return userMap;
				}
				
			}
		} catch (Exception e) {
			logger.error("----------获取redis中的user信息 error:", e);
			e.printStackTrace();
		}
		return userMap;
	}
	
	/**
	 * 设置user管理员信息
	 * @param userMap
	 * @return
	 */
	public Map<String, Object> setUserManagementInformation(Map<String, Object> userMap){
		if(userMap == null) {
			return new HashMap<String, Object>();
		}
		/****************** 查询是否管理员及管理员信息 ********************/
		// 用户ID
		String userID = ObjectUtils.toString(userMap.get("USER001"));
		String isManager = "0";
		IHrswTUserpurviewService userpurviewService = (IHrswTUserpurviewService)ApplicationContextUtil.getBean("hrswTUserpurviewServiceImpl");
		List<Map<String, Object>> organ = userpurviewService.findOrganByUserId(userID);
		if (organ != null && organ.size() >= 1) {
			isManager = "1";
			Map<String, Object> topOrgan = organ.get(0);
			String userpurviewId = ThreadUtils.getRTex().toString(topOrgan.get("UPUR001"));
			String managerOrganID = ThreadUtils.getRTex().toString(topOrgan.get("ORGA001"));
			userMap.put("managerOrganID", managerOrganID);
			
			//认证单位类型 默认-1 0 中电联 1省级鉴定中心 2市级鉴定站
			Integer authenticationOrganType = ThreadUtils.getRTex().toInteger(topOrgan.get("ORGA026"));
			
			HrswTUserpurview userpurview = userpurviewService.selectById(userpurviewId);
			//查询机构类型    1,'运营单位',2,'认证单位',3,'报名单位'
			Long companySource = userpurview.getUpur011();
			userMap.put("companySource", companySource);
			
			if(companySource != null && companySource == 2) {//2,'认证单位'
				userMap.put("authenticationOrganType", authenticationOrganType);
			}else {
				userMap.put("authenticationOrganType", "-1");
			}
		}
		userMap.put("isManager", isManager);
		return userMap; 
	}
	
	/**
	 * 设置让浏览器弹出下载对话框的Header. 根据浏览器的不同设置不同的编码格式 防止中文乱码
	 * 
	 * @param fileName
	 *            下载后的文件名.
	 */
	public void setFileDownloadHeader(HttpServletRequest request, HttpServletResponse response, String fileName) {
		try {
			// 中文文件名支持
			String encodedfileName = null;
			String agent = request.getHeader("USER-AGENT");
			if (null != agent && (-1 != agent.indexOf("MSIE") || -1 != agent.indexOf("rv:11.0"))) {// IE
				encodedfileName = java.net.URLEncoder.encode(fileName, "UTF-8");
			} else if (null != agent && -1 != agent.indexOf("Mozilla")) {
				encodedfileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
			} else {
				encodedfileName = java.net.URLEncoder.encode(fileName, "UTF-8");
			}
			response.reset();
			response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedfileName + "\"");
			response.setContentType("application/octet-stream; charset=utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 文件下载
	 * 
	 * @param fileName
	 * @param in
	 * @throws IOException
	 */
	public void downloadFile(String fileName, InputStream in) throws IOException {
		if (null != in) {
			byte[] bytes = ThreadUtils.getFileUtils().inputStreamToByte(in);
			if (null != bytes) {
				downloadFile(fileName, bytes);
			}

		}

	}

	/**
	 * 获取sessionID
	 *
	 * @return
	 */
	public String getWebSessionID() {
		HttpSession session = getWebSession();
		String sessionID = null;
		if (null != session) {
			sessionID = session.getId();
		}
		return sessionID;
	}

	/**
	 * 获取session
	 *
	 * @return
	 */
	public HttpSession getWebSession() {
		HttpServletRequest request = getWebRequest();
		HttpSession session = null;
		if (null != request) {
			session = request.getSession();
		}
		return session;
	}

	/**
	 * 文件下载
	 * 
	 * @param fileName
	 */
	public void downloadFile(String fileName, byte[] bytes) {
		HttpServletRequest request = getWebRequest();
		HttpServletResponse response = getWebResponse();
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
	 * 得到临时文件上传的绝对路径
	 *
	 * @return
	 */
	public String getUploadTmpPathName(String fileName) {
		File path = null;
		try {
			path = new File(ResourceUtils.getURL("classpath:").getPath());
			if(!path.exists()) {
				path = new File("");
			}
		} catch (FileNotFoundException e) {
			path = new File("");
		}


		String filePath = path.getAbsolutePath() + fileName;
		return filePath;

//		String filePath = Constant.Upload_Temp_Path + File.separator + fileName;
//		return filePath;
//		String filePath = Constant.website_uploadpath + File.separator;
//		return filePath += fileName;
//		return Global.getConfig(Global.WEBSITE_UPLOADPATH) + File.separator + fileName;
	}


}
