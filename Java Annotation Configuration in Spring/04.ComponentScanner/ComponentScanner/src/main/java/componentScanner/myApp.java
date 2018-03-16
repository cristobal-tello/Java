package componentScanner;

import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myApp {

	public static void main(String[] args) throws IOException {
	    
		ApplicationContext appContext = new ClassPathXmlApplicationContext("appContext.xml");
	    
	    System.out.println("04. Component Scanner:\n");
	    
	    Fruit fruit = appContext.getBean("unique_id_fruit", Fruit.class);
	    System.out.println(fruit.talkAboutYourSelf());
	    
	    
    	
	    ((ClassPathXmlApplicationContext) appContext).close();
	}
}
