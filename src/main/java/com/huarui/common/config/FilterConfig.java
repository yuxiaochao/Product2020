package com.huarui.common.config;

import com.huarui.filter.ParametersFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import com.huarui.filter.ParametersFilter2;

@Configuration
public class FilterConfig {
	/**
	 * 拦截器注册
	 *
	 * @return
	 */
	@Bean
	public FilterRegistrationBean myFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new ParametersFilter());
		registration.addUrlPatterns("/*");// 拦截路径
		registration.setName("ParametersFilter");// 拦截器名称
		registration.setOrder(1);// 顺序
		return registration;
	}

//	/**
//	 * 拦截器注册
//	 * 
//	 * @return
//	 */
//	@Bean
//	public FilterRegistrationBean myOncePerRequestFilterRegistration() {
//		FilterRegistrationBean registration = new FilterRegistrationBean();
//		registration.setFilter(new ParametersFilter2());
//		registration.addUrlPatterns("/*");// 拦截路径
//		registration.setName("ParametersFilter2");// 拦截器名称
//		registration.setOrder(2);// 顺序
//		return registration;
//	}
}
