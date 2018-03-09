package beanPropertiesApp;

import java.io.File;
import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class myApp {

	public static void main(String[] args) throws IOException {
	    ApplicationContext appContext = new ClassPathXmlApplicationContext("appContext.xml");
	    
		Fruit f = appContext.getBean("unique_id_fruit", Fruit.class);
	    Vegetable v = (Vegetable) appContext.getBean("unique_id_vegetable");
	    
	    // Take a look on appContext.xml to check how to use cctor
	    Fruit f2 = appContext.getBean("unique_id_fruit_orange", Fruit.class);
	    
	    // Take a look on appContext.xml to check how to use set/get methods 
	    Vegetable v2 = (Vegetable) appContext.getBean("unique_id_vegetable_use_prop"); 
	    
	    // Take a look on appContext.xml to check how to fill a list 
	    Fruit f3 = appContext.getBean("unique_id_fruit_list", Fruit.class);
	    Fruit f4 = appContext.getBean("unique_id_fruit_map", Fruit.class);
	    
	
	    System.out.println(f.talkAboutYourSelf());
	    System.out.println(v.talkAboutYourSelf());
	    System.out.println("--");
	    System.out.println(f2.talkAboutYourSelf());
	    System.out.println(v2.talkAboutYourSelf());
	    System.out.println("--");
	    System.out.println(f3.talkAboutYourSelf());
	    System.out.println(f4.talkAboutYourSelf());
	    
	    ((ClassPathXmlApplicationContext) appContext).close();
	}

}
