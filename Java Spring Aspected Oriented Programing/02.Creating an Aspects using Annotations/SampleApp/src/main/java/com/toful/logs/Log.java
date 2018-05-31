package com.toful.logs;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Log {
	
	@Before("execution(void com.toful.vehicles.Car.drive())")
	public void vehicleAboutToMove()
	{
		System.out.println("Saving to log (from aspect): Vehicle action: About to move");
	}
}
