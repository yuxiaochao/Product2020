package com.huarui.wrapper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.huarui.common.config.Global;
import com.huarui.common.utils.RedisUtil;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.common.utils.WebUtil;
import com.huarui.product2020.entity.base.AllowedLinks;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.LinkedCaseInsensitiveMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;
import java.util.*;

//import freemarker.template.utility.StringUtil;

public class ParameterRequestWrapper extends HttpServletRequestWrapper {

	private static Logger logger = LoggerFactory.getLogger(ParameterRequestWrapper.class);

	private Map<String, String[]> parameters = new LinkedHashMap<String, String[]>();

	private Map<String, String> headerParameter = new LinkedCaseInsensitiveMap<String>();

	public String body = null;


	public ParameterRequestWrapper(HttpServletRequest request, RedisUtil redisUtil, AllowedLinks allowedLinks) throws UnsupportedEncodingException {
		super(request);

		String authorization = request.getParameter(Global.AUTHORIZATION);
		if(ThreadUtils.getRTex().isNotEmpty(authorization)){
			headerParameter.put(Global.AUTHORIZATION, "Bearer " + authorization);
		}
		//获取所有请求头信息
		Enumeration er = request.getHeaderNames();//获取请求头的所有name值
		while(er.hasMoreElements()) {
			String name = (String) er.nextElement();
			String value = request.getHeader(name);
			headerParameter.put(name, value);
		}

		List<String> linksList = new ArrayList<>();
		if(allowedLinks != null){
			linksList = allowedLinks.getLinksList();
		}
		decryptionParameters(request, redisUtil, linksList);
	}

	@Override
	public String getHeader(String name) {
		return headerParameter.get(name);
	}
	
	/**
	 * 参数解密
	 * 
	 * @param request
	 * @throws UnsupportedEncodingException
	 */
	public void decryptionParameters(HttpServletRequest request, RedisUtil redisUtil, List<String> linksList) throws UnsupportedEncodingException {

		getInputStream(request);
		if (StringUtils.isNotBlank(body)) {
			//获取body数据
			JSONObject requestParameters = JSON.parseObject(body);//转换json格式数据
			Set<String> keys = requestParameters.keySet();
			for (String key : keys) {
				String[] value = new String[]{requestParameters.getString(key)};
//			for (int i = 0; i < value.length; i++) {
//				value[i] = StringUtil.XHTMLEnc(value[i]);
//			}
				parameters.put(key, value);
			}
		}

		//获取URL参数
		Map<String, String[]> parameterMap = request.getParameterMap();
		for (String key : parameterMap.keySet()) {
			parameters.put(key, parameterMap.get(key));
		}

		if (headerParameter.get("content-type") != null && headerParameter.get("content-type").contains("multipart/form-data")) {
			return;
		}


		boolean flag = false;//登录使用默认的秘钥解密数据
		if(linksList != null){
			for (String links : linksList) {
				flag = StringUtils.endsWith(request.getRequestURI(), links);
				if(flag){
					break;
				}
			}
		}

		String redisSecrecyKey = Global.REDIS_SECRECY_KEY;
		String secrecyKey = Global.AES_KEY;
		if (!flag) {
			String userName = getTokenData(request).getString("userName");
			String token = getTokenData(request).getString("token");
			if (StringUtils.isNotBlank(userName) && StringUtils.isNotBlank(token)) {
				redisSecrecyKey = token + Global.REDIS_SECRECY_KEY + userName;
				secrecyKey = ObjectUtils.toString(redisUtil.get(redisSecrecyKey));
			}
		}
		
		//获取私钥
		if (StringUtils.isNotBlank(ObjectUtils.toString(secrecyKey))) {
			Map decryptionMap = new WebUtil().decryptionParametersAES(parameters,ObjectUtils.toString(secrecyKey));
				if (decryptionMap != null) {
				parameters.remove(ThreadUtils.getWebUtil().ecryptedKey);
				parameters.remove("secreKkey");
				parameters.putAll(decryptionMap);
			}
		}
	}

	public static JSONObject getTokenData(HttpServletRequest request) {
		JSONObject tokenData = new JSONObject();
		String authorization = request.getHeader(Global.AUTHORIZATION);
		authorization = StringUtils.substring(authorization, 7);
		try {
			if(authorization != null){
				Algorithm algorithm = Algorithm.HMAC256(Global.PRIVATEKEY);
				JWTVerifier verifier = JWT.require(algorithm).build(); //Reusable verifier instance
				DecodedJWT jwt = verifier.verify(authorization);
				if (jwt != null) {
					DecodedJWT jwt1 = JWT.decode(authorization);
					Claim claim = jwt1.getClaim(Global.USERTOKEN);
					String[] authorizations = claim.asString().split(":");
					tokenData.put("userName", authorizations[0]);
					tokenData.put("token", authorizations[1]);
				}
			}

		} catch (Exception e) {
			logger.error("解密参数，解密jwt失败！", e);
		}
		return tokenData;
	}

	public String getParameter(String key) {
		String[] values = parameters.get(key);
		return ThreadUtils.getRTex().arrayToString(values);
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		return parameters;
	}

	@Override
	public Enumeration<String> getParameterNames() {
		return new Vector<String>(parameters.keySet()).elements();
	}

	@Override
	public String[] getParameterValues(String name) {
		String[] result = null;

		Object value = parameters.get(name);
		if (value == null) {
			result = null;
		} else if (value instanceof String[]) {
			result = (String[]) value;
		} else if (value instanceof String) {
			result = new String[] { (String) value };
		} else {
			result = new String[] { value.toString() };
		}

		return result;
	}

	public void getInputStream(HttpServletRequest request) {
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;
		InputStream inputStream = null;
		JSONObject params = new JSONObject();
		try {
			inputStream = request.getInputStream();
			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}
		} catch (IOException ex) {

		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		body = stringBuilder.toString();
	}

}
