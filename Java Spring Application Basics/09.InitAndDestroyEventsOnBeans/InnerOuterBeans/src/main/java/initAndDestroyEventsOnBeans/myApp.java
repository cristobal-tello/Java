package initAndDestroyEventsOnBeans;

import java.io.File;
import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class myApp {

	public static void main(String[] args) throws IOException {
	    
		// If you take a look appContext.xml. Scope is set to singleton(default).
		// If you change the scope to Prototype, you will note the 'destroy' method is not call
		// Prototype means you as developer takes care how the instances are destroyed!!!!
		ApplicationContext appContext = new ClassPathXmlApplicationContext("appContext.xml");
	    
	    
	    System.out.println("09. Init And Destroy Events On Beans sample:\n");
	    
	    Fruit fruit = appContext.getBean("unique_id_fruit", Fruit.class);
	    System.out.println(fruit.talkAboutYourSelf());
	    
	    ((ClassPathXmlApplicationContext) appContext).close();
	}
}
