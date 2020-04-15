package com.huarui.common.config;

import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.entity.base.AllowedLinks;
import com.huarui.filter.ParametersFilter;
import com.huarui.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

	@Autowired
	private AllowedLinks allowedLinks;
	
	@Bean
	public MyInterceptor myInterceptor() {
		return new MyInterceptor();
	}

	@Bean
	public ParametersFilter parametersFilter() {
		return new ParametersFilter();
	}

	@Bean
	public FilterRegistrationBean myFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(parametersFilter());
		return registration;

	}


    public void addInterceptors(InterceptorRegistry registry) {
		String[] strings = null;
		List<String> linksList = new ArrayList<>();
		linksList.add("/error");
		if(allowedLinks != null){
			linksList = allowedLinks.getLinksList();
			linksList.addAll(allowedLinks.getDefaultLinksList());
			strings = ThreadUtils.getRTex().listToArray(linksList);
		}
		
		registry.addInterceptor(myInterceptor()).addPathPatterns("/**").excludePathPatterns(
				strings);
        super.addInterceptors(registry);
    }
    
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")    
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedMethods("*").maxAge(360);
    }
    
    /**
	 * 转发json前台406问题解决
	 */
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer){
		configurer.favorPathExtension(false);
	}
}
