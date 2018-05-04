package com.demo.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// This project doens't have myDemo-servletConfig.xml
// Instead AppConfig class is used

@EnableWebMvc		// Like <mvc:annotation-driven/>
@ComponentScan(basePackages="com.demo.controllers")	// <context:component-scan base-package="com.demo.controllers" />
@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public InternalResourceViewResolver getIRVR()
	{
		/*<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="WEB-INF/jsp/" />
		<property name="suffix" value=".jsp" />
		</bean>*/
		
		System.out.println("Setting up view resolver");
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		irvr.setPrefix("WEB-INF/jsp/");
		irvr.setSuffix(".jsp");
		return irvr;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		/*<mvc:resources location="/resources/" mapping="/myResources/**" />
		 */
		System.out.println("Setting up resources");
		registry.addResourceHandler("/myResources/**").addResourceLocations("/resources/");
	}
	
	
	
}
