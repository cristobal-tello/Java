package mySimpleSpringApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class myApp {

	public static void main(String[] args) {
		// Old fashion way
		// Fruit f = new Fruit();
		// Vegetable v = new Vegetable();
		
		// Using spring
		ApplicationContext appContext = new FileSystemXmlApplicationContext("appContext.xml");
		// Using class
		Fruit f = appContext.getBean("unique_id_fruit", Fruit.class);
		// Or using cast
		Vegetable v = (Vegetable) appContext.getBean("unique_id_vegetable");
		
		System.out.println(f.talkAboutYourSelf());
		System.out.println(v.talkAboutYourSelf());
	}

}
