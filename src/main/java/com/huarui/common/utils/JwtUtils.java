package com.huarui.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.huarui.common.config.Global;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JwtUtils {
	private final static Logger LOGGER =  LoggerFactory.getLogger(JwtUtils.class);
	
	public static String jwtToken(String token, String username, String user001) {
		String newToken="";
		try {
			Algorithm algorithm = Algorithm.HMAC256(Global.PRIVATEKEY);
		    newToken = JWT.create()
		    		 .withClaim(Global.USERTOKEN, username+":"+token+":"+user001)
		    		 .sign(algorithm);
		} catch (Exception e) {
			LOGGER.info("生成token异常！---"+e.getMessage());
		}
			
		return newToken;
	}
}
