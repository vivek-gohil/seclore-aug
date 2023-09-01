package com.seclore.main.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.seclore.main.intercepter.RequestProcessingTimeIntercepter;

@Configuration
public class SpringConfiguration implements WebMvcConfigurer {
	@Bean
	public ViewResolver getViewResolver() {
		System.out.println("Resolving View");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new RequestProcessingTimeIntercepter());
	}
}
