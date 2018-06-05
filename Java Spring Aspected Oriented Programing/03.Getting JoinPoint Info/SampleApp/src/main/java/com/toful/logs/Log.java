package com.toful.logs;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Log {
	
	@Before("execution(void com.toful.vehicles.Car.drive(..))")		// (..) any parameter
	public void vehicleAboutToMove(JoinPoint jp)
	{
		System.out.println("Saving to log (from aspect): Vehicle action: About to move");
		
		System.out.println("JoinPoint kind: "+jp.getKind());
		System.out.println("JoinPoint static part: "+jp.getStaticPart());
		
		Object[] args = jp.getArgs();
		Integer speed = ((Integer)args[0]).intValue();
		System.out.println("JoinPoint argumenent: "+ speed);
		
		System.out.println("JoinPoint target: "+ jp.getTarget());
	}
}
