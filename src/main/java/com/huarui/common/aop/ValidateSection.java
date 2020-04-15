package com.huarui.common.aop;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huarui.product2020.entity.HrswTLoginlog;
import com.huarui.product2020.entity.ResultEntity;
import com.huarui.product2020.service.IHrswTLoginlogService;
import com.huarui.product2020.service.IHrswTUserService;
import org.apache.commons.lang3.ObjectUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Aspect
@Component
public class ValidateSection {
	
	@Autowired
	private IHrswTLoginlogService loginlogService;
	
	@Autowired
	private IHrswTUserService userService;
	
	@Around("@annotation(validate)")
	public Object Main(ProceedingJoinPoint jp, Validate validate) throws Throwable {
		
		ServletRequestAttributes req = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = req.getRequest();
        
		String user001 = ObjectUtils.toString(request.getParameter("USER001"));        // 用户编号
		String userCode = ObjectUtils.toString(request.getParameter("userCode"));      // 秘钥
		
		EntityWrapper<HrswTLoginlog> ew = new EntityWrapper<HrswTLoginlog>();
		ew.where("LLOG003 = {0} and LLOG011 = {1}", user001, userCode);
		HrswTLoginlog loginlog = loginlogService.selectOne(ew);
		if(loginlog==null) {
			ResultEntity result = new ResultEntity();
			result.setCode(0);
			result.setErrorMsg("用户请求非法");
			return result;
		} else {
			Map userMap = userService.selectUserInfoById(user001);
			if(userMap!=null) {
				String organid = ObjectUtils.toString(userMap.get("USER002"));
				request.setAttribute("organid", organid);
				String username = ObjectUtils.toString(userMap.get("USER004"));
				request.setAttribute("username", username);
				String useralias = ObjectUtils.toString(userMap.get("USER005"));
				request.setAttribute("useralias", useralias);
				String usersex = ObjectUtils.toString(userMap.get("USER006"));
				request.setAttribute("usersex", usersex);
				String organname = ObjectUtils.toString(userMap.get("ORGA006"));
				request.setAttribute("organname", organname);
			}
			
			request.setAttribute("userid", user001);
			request.setAttribute("loginlogId", loginlog.getLlog001());
			return jp.proceed();
		}

	}

}
