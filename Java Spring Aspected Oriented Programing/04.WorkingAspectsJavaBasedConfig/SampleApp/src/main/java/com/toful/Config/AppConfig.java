package com.toful.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import com.toful.vehicles.Car;

@Configuration
@ComponentScan("com.toful.logs")	// <context:component-scan base-package="com.toful.logs"/>
@EnableAspectJAutoProxy				// <aop:aspectj-autoproxy>
public class AppConfig {
	@Bean(name="car")
	public Car getCar()
	{
		return new Car();
	}
}
