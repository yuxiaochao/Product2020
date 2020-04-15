package com.huarui.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.huarui.common.config.Global;
import com.huarui.common.utils.RedisUtil;
import com.huarui.common.utils.ThreadUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class MyInterceptor implements HandlerInterceptor {
	private final static Logger LOGGER =  LoggerFactory.getLogger(MyInterceptor.class);
	@Autowired
	private RedisUtil redisUtil;


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String origin = request.getHeader("origin");// 获取源站
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type", "application/json");
		response.setHeader("Access-Control-Allow-Origin", origin);
		response.setHeader("Access-Control-Allow-Headers", "Authorization,DNT,User-Agent,Keep-Alive,Content-Type,accept,origin,X-Requested-With,always");
		response.setHeader("Access-Control-Allow-Methods", "*");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		//验证token是否有效
		boolean flag = false;
		if(request.getMethod().equals(RequestMethod.OPTIONS.name())) { //预检测将其放行
			response.setStatus(HttpStatus.OK.value()); return flag; 
		}
		String authorization = request.getHeader(Global.AUTHORIZATION);
        if (authorization == null || !authorization.startsWith("Bearer ")) {
				response.setStatus(HttpStatus.UNAUTHORIZED.value());
				return flag;
        }
        authorization = StringUtils.substring(authorization, 7);

        //jwt解密
        JSONObject jwtData = new JSONObject();
		try {
			decodeJwt(authorization, jwtData);
		} catch (Exception e) {
			LOGGER.error("解密jwt数据失败！", e);
		}
		
		if(StringUtils.isBlank(jwtData.getString(Global.JWT_Token)) && StringUtils.isBlank(jwtData.getString(Global.JWT_USER_NAME))) {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			return flag;
		}
	
		//校验token是否存在
		flag = existsToken(jwtData.getString(Global.JWT_Token),jwtData.getString(Global.JWT_USER_NAME),jwtData.getString(Global.JWT_USER_ID));
		
		if(!flag) {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
		}
        return flag;
		//return true;
	}
	
	//jwt解密
	public void decodeJwt(String authorization, JSONObject jwtData) throws IllegalArgumentException, UnsupportedEncodingException {
		Algorithm algorithm = Algorithm.HMAC256(Global.PRIVATEKEY);
		JWTVerifier verifier = JWT.require(algorithm).build();
		DecodedJWT jwt = verifier.verify(authorization);
		if(jwt != null) {
			 DecodedJWT jwt1 = JWT.decode(authorization);
			 Claim claim = jwt1.getClaim(Global.USERTOKEN);
			 String[] authorizations = claim.asString().split(":");
			 jwtData.put(Global.JWT_USER_NAME, authorizations[0]);
			 jwtData.put(Global.JWT_Token, authorizations[1]);
			 jwtData.put(Global.JWT_USER_ID, authorizations[2]);
		}
	}
	
	//校验token是否存在
	public boolean existsToken(String token, String username, String userid) {
		boolean flag = false;
		if(redisUtil.exists(token+":"+ Global.USERTOKEN)){//先验证token对应的用户信息是否存在
			String key = Global.TOKEN+username;
			List<Object> tokenList = redisUtil.lget(key);
			ThreadUtils.getJwtData().put(Global.JWT_USER_NAME, username);
			ThreadUtils.getJwtData().put(Global.JWT_Token, token);
			ThreadUtils.getJwtData().put(Global.JWT_USER_ID, userid);
			flag = tokenList.contains(token);
		}
		return flag;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		ThreadUtils.removeJwtData();
	}

}
