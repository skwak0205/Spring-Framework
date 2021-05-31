package com.mvc.update.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// servlet-context.xml을 .java로 변환

@Configuration
@EnableWebMvc // <mvc:annotation-driven />을 의미
@ComponentScan("com.mvc.update") // <context:component-scan base-package="com.mvc.update" />
public class ServletConfig implements WebMvcConfigurer {
	
	@Override
	// <resources mapping="/resources/**" location="/resources/" />
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	
	}
	
	/*
	 * <beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		 <beans:property name="prefix" value="/WEB-INF/views/" />
		 <beans:property name="suffix" value=".jsp" />
	   </beans:bean>
	 */
	@Bean
	public InternalResourceViewResolver viewResolver() {
		String prefix = "/WEB-INF/views/";
		String suffix = ".jsp";
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix(prefix);
		resolver.setSuffix(suffix);
		
		return resolver;
	}
}
