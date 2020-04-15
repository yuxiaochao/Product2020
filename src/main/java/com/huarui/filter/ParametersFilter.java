package com.huarui.filter;

import com.huarui.common.config.Global;
import com.huarui.common.utils.RedisUtil;
import com.huarui.product2020.entity.base.AllowedLinks;
import com.huarui.wrapper.ParameterRequestWrapper;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 参数过滤器
 */
@Component
public class ParametersFilter extends OncePerRequestFilter {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private AllowedLinks allowedLinks;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
//        Map<String, String> headersInfo = getHeadersInfo(request);
        if (StringUtils.equals(request.getMethod(), HttpMethod.OPTIONS.name())
        ) {//get请求走默认的doFilter
            chain.doFilter(request, response);
            return;
        }
        
        if(allowedLinks.getDefaultLinksList().contains(request.getRequestURI().replace(request.getContextPath(), ""))) {
        	 chain.doFilter(request, response);
             return;
        }

        try {
            HttpServletRequestWrapper parameterRequestWrapper = new ParameterRequestWrapper(request, redisUtil,allowedLinks);
            chain.doFilter(parameterRequestWrapper, response);
        } catch (Exception e) {
            e.printStackTrace();
            if (StringUtils.contains(e.getMessage(), ObjectUtils.toString(Global.SECRECY_ERROR_CODE))) {
//                cleanTokenSecrecy(request);
                response.setStatus(Global.SECRECY_ERROR_CODE);//发送加密数据解密失败,用户与服务器密钥不一致
            } else if (StringUtils.contains(e.getMessage(), "Cannot get Jedis connection")) {//redis连接失败
                response.setStatus(Global.REDIS_ERROR_CODE);
            }
        }

    }

//    public void cleanTokenSecrecy(HttpServletRequest request) {
//        //解密失败将token与秘钥key从redis中清除
//        JSONObject jwtData = ParameterRequestWrapper.getTokenData(request);
//        String token = jwtData.getString("token");
//        String userName = jwtData.getString("userName");
//        if (StringUtils.isNotBlank(token) && StringUtils.isNotBlank(userName)) {
//            String key = Global.TOKEN + jwtData.getString("userName");
//            redisUtil.lremove(key, 0, token);
//            redisUtil.remove(token + ":" + Global.USERTOKEN);
//            redisUtil.remove(token + Global.REDIS_SECRECY_KEY + userName);
//        }
//    }

    private Map<String, String> getHeadersInfo(HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }

}
