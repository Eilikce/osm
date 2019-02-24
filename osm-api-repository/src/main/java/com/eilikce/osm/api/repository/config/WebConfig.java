package com.eilikce.osm.api.repository.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.eilikce.osm.api.repository.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Autowired
	private LoginInterceptor loginInterceptor;
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
		// 登录拦截
				// 坑之，拦截器是从工程名开始的/login表示http://localhost:8080/eilikce/login
				registry.addInterceptor(loginInterceptor)
						.addPathPatterns("/**")
						.excludePathPatterns("/css/**")
						.excludePathPatterns("/js/**")
						.excludePathPatterns("/html/**")
						.excludePathPatterns("/external/**")
						.excludePathPatterns("/login*");
    }
}
