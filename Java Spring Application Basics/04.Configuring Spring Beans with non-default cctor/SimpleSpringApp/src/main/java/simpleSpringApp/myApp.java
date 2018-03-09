package simpleSpringApp;

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
	    Fruit f2 = appContext.getBean("unique_id_fruit_orange", Fruit.class);	// Take a look appContext.xml to check how to use cctor
	
	    System.out.println(f.talkAboutYourSelf());
	    System.out.println(v.talkAboutYourSelf());
	    System.out.println(f2.talkAboutYourSelf());
	}

}
