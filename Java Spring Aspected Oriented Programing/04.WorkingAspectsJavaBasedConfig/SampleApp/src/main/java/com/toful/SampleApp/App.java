package com.toful.SampleApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.toful.Config.AppConfig;
import com.toful.vehicles.Car;

public class App 
{
    public static void main(String[] args)
    {
    	// Works using ClassPathXmlApplicationContext
    	// ApplicationContext appContext = new ClassPathXmlApplicationContext("com/toful/Config/appContext.xml");
    	
    	ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	Car myCar = appContext.getBean("car", Car.class);
        myCar.drive();
        myCar.stop();
        ((AnnotationConfigApplicationContext) appContext).close();
        
        //((ClassPathXmlApplicationContext) appContext).close();
    }
}
