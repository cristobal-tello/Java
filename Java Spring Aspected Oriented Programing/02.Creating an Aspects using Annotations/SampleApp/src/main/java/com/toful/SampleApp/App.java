package com.toful.SampleApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.toful.vehicles.Car;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext appContext = new FileSystemXmlApplicationContext("appContext.xml");
        
        Car myCar = appContext.getBean("car", Car.class);
        
        myCar.drive();
        
        ((FileSystemXmlApplicationContext) appContext).close();
    }
}
