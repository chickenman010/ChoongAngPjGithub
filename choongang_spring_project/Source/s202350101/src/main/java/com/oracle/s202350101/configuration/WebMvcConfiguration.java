package com.oracle.s202350101.configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.oracle.s202350101.service.mkhser.LoginInterceptor;

public class WebMvcConfiguration implements WebMvcConfigurer {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 누군가가 URL로  /user_login라고 친다면 LoginInterceptor() 에서 처리 해줌
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/interCeptor")
		;
	}

}
