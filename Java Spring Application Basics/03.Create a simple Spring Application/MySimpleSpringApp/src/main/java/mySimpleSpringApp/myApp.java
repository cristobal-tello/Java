package mySimpleSpringApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class myApp {

	public static void main(String[] args) {
		// Old fashion way
		// Fruit f = new Fruit();
		// Vegetable v = new Vegetable();
		
		// Using spring if the file is on the root of project folder
		ApplicationContext appContext = new FileSystemXmlApplicationContext("appContext.xml");
		//ApplicationContext appContenxt = new ClassPathXmlApplicationContext(<path here>);
		// Make sure next object have a cctor without arguments or simply, doens't have a cctor.
		
		// Scope:
		// Singleton: By default 
		// Prototype: Multiple instances
		// Request: One instance per HTTP request
		// Session: One instace per HTTP session
		// Global session: One instance per Global HTTP session
		
		// Using class
		Fruit f = appContext.getBean("unique_id_fruit", Fruit.class);
		f.anyValue = 3;
		System.out.println("f.anyValue="+f.anyValue);
		
		// Or using cast
		Vegetable v = (Vegetable) appContext.getBean("unique_id_vegetable");
		
		System.out.println(f.talkAboutYourSelf());
		System.out.println(v.talkAboutYourSelf());
		
		System.out.println("\r\n");
		System.out.println("Scopes");
		
		Fruit f2 = appContext.getBean("unique_id_fruit", Fruit.class);
		System.out.println("f2.anyValue="+f.anyValue);
		System.out.println(f2.talkAboutYourSelf());
		
	}

}
